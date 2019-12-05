package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public abstract class AlienShip extends EnemyShip {
	
	protected int points;
	public static int move;
	
	public AlienShip(Game game, Cord cord, int live) {
		super(game, cord, live);
		move = -1;
		// TODO Auto-generated constructor stub
	}
	public int getPoints()
	{
		return (points);
	}
	public void move()
	{
		if(move != 0)
		{
			if(game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0)
				cord.set_col(cord.get_col() + move);
		}
		else
			cord.set_row(cord.get_row() + 1);
	}
	public static boolean allDead(Game game)
	{
		return(game.getBoard().alienAllDead());
	}
	public static boolean haveLanded(Game game)
	{
		return(game.getBoard().haveLanded());
	}
	public static int getMove()
	{
		return (move);
	}
}
