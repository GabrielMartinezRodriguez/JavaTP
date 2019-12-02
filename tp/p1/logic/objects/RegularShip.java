package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class RegularShip extends AlienShip {

	public RegularShip(Game game, Cord cord, int live) {
		super(game, cord, live);
		points = 5;
		// TODO Auto-generated constructor stub
	}
	public String toString()
	{
		return ("R["+live+"]");
	}
}
