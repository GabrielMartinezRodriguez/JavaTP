package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class UCMShip extends Ship {

	public UCMShip(Game game, Cord cord) {
		super(game, cord, 3);
		// TODO Auto-generated constructor stub
	}
	public String toString()
	{
		if(live > 0)
			return ("^__^");
		else
			return ("¡xx¡");
	}
}
