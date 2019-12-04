package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public abstract class EnemyShip extends Ship {

	protected int points;

	public EnemyShip(Game game, Cord cord, int live) {
		super(game, cord, live);
		// TODO Auto-generated constructor stub
	}

	public int getPoints() {
		return points;
	}
}
