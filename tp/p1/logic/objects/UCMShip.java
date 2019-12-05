package tp.p1.logic.objects;

import tp.p1.logic.CommandExecuteException;
import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class UCMShip extends Ship {

	protected UCMShipLaser laser;
	protected Shockwave		shockwave;
	protected SuperMisil	SuperMisil;
	protected int			nSuperMisil;

	
	public UCMShip(Game game, Cord cord) {
		super(game, new Cord(cord), 3);
		laser = new UCMShipLaser(game, new Cord(this.cord), 0);
		shockwave = new Shockwave(game, this.cord, 0);
		SuperMisil = new SuperMisil(game,new Cord(this.cord), 0);
		game.addObject(laser);
		game.addObject(SuperMisil);
		nSuperMisil = 0;
		
	}
	public String toString()
	{
		if(live > 0)
			return ("^__^");
		else
			return (" !xx!  ");
	}
	public boolean shoot() throws CommandExecuteException
	{
		if(!laser.isAlive())
		{
			Cord cord = new Cord(this.cord);
			laser.setCord(cord); 
			laser.onDelete();
			return true;
		}
		else
			throw new CommandExecuteException("NO TIENES DISPONIBLE El DISPARO");
	}
	public boolean superMisil() throws CommandExecuteException
	{
		if(!SuperMisil.isAlive() && nSuperMisil > 0)
		{
			Cord cord = new Cord(this.cord);
			SuperMisil.setCord(cord); 
			SuperMisil.onDelete();
			nSuperMisil--;
			return true;
		}
		else
			throw new CommandExecuteException("NO TIENES DISPONIBLE El SUPER MISIL");
	}
	public void enableShockWave()
	{
		shockwave.enable();
	}
	
	public int getnSuperMisil() {
		return nSuperMisil;
	}
	
	public void shockWave() throws CommandExecuteException
	{
		if(shockwave.getEnable())
		{
			game.getBoard().shockWave(shockwave);
			shockwave.useShockWave();
		}
		else
			throw new CommandExecuteException("NO TIENES SHOCKWAVE TODAVIA");
	}
	public boolean getShockWave() {
		return(shockwave.getEnable());
	}
	public String objectAsString() {
		String str = "P;" + cord.get_col() + ";" + cord.get_row() + ";" + live + ";"+ shockwave.getEnable() + "\n";
		return str;
	}
	public void addSuper() {
		nSuperMisil++;
	}
	
}
