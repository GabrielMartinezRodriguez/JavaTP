package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class AlienShip extends EnemyShip {
	
	protected int points;
	protected static int move;
	
	public AlienShip(Game game, Cord cord, int live) {
		super(game, cord, live);
		// TODO Auto-generated constructor stub
	}
	public int getPoints()
	{
		return (points);
	}

}
