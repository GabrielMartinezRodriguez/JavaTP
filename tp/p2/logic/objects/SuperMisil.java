package tp.p2.logic.objects;

import tp.p2.logic.Game;
import tp.p2.util.Cord;

public class SuperMisil extends UCMShipLaser {
	
	private static int coste = 20;
	public SuperMisil(Game game, Cord cord, int live) {
		super(game, cord, live);
		damage = 2;
	}
	public static int getCoste()
	{
		return (coste);
	}
	public String toString() {
		return (" OO ");
	}
	public String objectAsString() {
		String str = "X;" + cord.get_col() + ";" + cord.get_row() + "\n";
		return str;
	}
	public boolean imUCMShipLaserStrict()
	{
		return false;
	}
	public boolean imSuperMisil()
	{
		return true;
	}
}
