package tp.p2.logic.objects;

import tp.p2.logic.Game;
import tp.p2.util.Cord;

public abstract class EnemyShip extends Ship {

	protected int points;

	public EnemyShip(Game game, Cord cord, int live) {
		super(game, cord, live);
		// TODO Auto-generated constructor stub
	}

	public int getPoints() {
		return points;
	}
	public boolean imEnemyShip()
	{
		return true;
	}
}
