package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class UCMShip extends Ship {

	protected UCMShipLaser laser;
	public UCMShip(Game game, Cord cord) {
		super(game, cord, 3);
		laser = new UCMShipLaser(game, cord, 0);
		game.addObject(laser);
		
	}
	public String toString()
	{
		if(live > 0)
			return ("^__^");
		else
			return ("¡xx¡");
	}
}
