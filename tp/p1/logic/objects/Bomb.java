package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class Bomb extends Weapon {

	public Bomb(Game game, Cord cord, int live) {
		super(game, cord, live);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return (" .  ");
	}

}
