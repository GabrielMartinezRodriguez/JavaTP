package tp.p2.logic.objects;

import tp.p2.logic.Game;
import tp.p2.util.Cord;

public abstract class AlienShip extends EnemyShip {
	
	protected int points;
	public static int move = -1;
	
	public AlienShip(Game game, Cord cord, int live) {
		super(game, cord, live);
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
			if(game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0)
				cord.set_row(cord.get_row() + 1);
	}
	public boolean haveLanded()
	{
		if(getCord().get_row() == Game.DIM_Y - 1 && isAlive())
			return true;
		else
			return false;
		
	}
	public boolean imAlien()
	{
		return true;
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
