package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class UCMShip extends Ship {

	protected UCMShipLaser laser;
	protected Shockwave		shockwave;

	public UCMShip(Game game, Cord cord) {
		super(game, new Cord(cord), 3);
		laser = new UCMShipLaser(game, new Cord(this.cord), 0);
		shockwave = new Shockwave(game, this.cord, 0);
		game.addObject(laser);
		
	}
	public String toString()
	{
		if(live > 0)
			return ("^__^");
		else
			return ("¡xx¡");
	}
	public boolean shoot()
	{
		if(!laser.isAlive())
		{
			Cord cord = new Cord(this.cord);
			laser.setCord(cord); 
			laser.onDelete();
			return true;
		}
		else
			return false;
	}
	public void enableShockWave()
	{
		shockwave.enable();
	}
	public void shockWave()
	{
		if(shockwave.getEnable())
		{
			game.getBoard().shockWave(shockwave);
			shockwave.useShockWave();
		}
	}
}
