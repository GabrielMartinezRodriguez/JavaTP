package tp.p2.logic;

import tp.p2.logic.lists.GameObjectBoard;
import tp.p2.logic.objects.DestroyerShip;
import tp.p2.logic.objects.Ovni;
import tp.p2.logic.objects.RegularShip;
import tp.p2.util.Cord;

public class BoardInitializer {
	private Level level;
	private GameObjectBoard board;
	private Game game;

	public BoardInitializer()
	{
		
	}
	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}

	private void initializeOvni() {
		Cord cord = new Cord(0, Game.DIM_X);
		board.add(new Ovni(game, cord, 1));
	}

	private void initializeRegularAliens() {
		Cord cord = new Cord(1, (Game.DIM_X - 1)/2 - 1);
		for(int i = 0; i < level.getNumRowsOfRegularAliens(); i++)
		{
			for(int j = 0; j < level.getNumRegularAliensPerRow(); j++)
			{
				board.add(new RegularShip(game, new Cord(cord), 3));
				cord.set_col(cord.get_col() + 1);
			}
			cord.set_row(cord.get_row() + 1);
			cord.set_col((Game.DIM_X - 1)/2 - 1);
		}
	}

	private void initializeDestroyerAliens() {
		int desplazamiento;
		if(level != Level.INSANE)
			desplazamiento = 0;
		else
			desplazamiento = 1;
		Cord cord = new Cord(1 + level.getNumRowsOfRegularAliens(), (Game.DIM_X - 1)/2 - desplazamiento);
		for(int i = 0; i < level.getNumDestroyerAliensPerRow(); i++)
		{
			board.add(new DestroyerShip(game, new Cord(cord), 3, board));
			cord.set_col(cord.get_col() + 1);
		}
	}
}