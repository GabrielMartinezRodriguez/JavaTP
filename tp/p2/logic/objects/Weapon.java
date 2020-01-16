package tp.p2.logic.objects;

import tp.p2.logic.Game;
import tp.p2.util.Cord;

public abstract class Weapon extends GameObject {

	public Weapon(Game game, Cord cord, int live) {
		super(game, cord, live);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub

	}

	public void onDelete() {
		live = 1;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
