package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class Shockwave extends Weapon {

	protected boolean enable;

	public Shockwave(Game game, Cord cord, int live) {
		super(game, cord, live);
		enable =  false;
	}

	@Override
	public String toString() {
		return null;
	}
	public boolean performAttack(GameObject other){
		if(other.isAlive())
		{
			this.live = -1;
			other.receiveShockWaveAttack(1);
			return true;
		}
		return false;
	}
	public void enable()
	{
		enable = true;
	}
	public void useShockWave()
	{
		enable = false;
	}
	public boolean getEnable()
	{
		return (enable);
	}

	@Override
	public String objectAsString() {
		return "";
	}
}
