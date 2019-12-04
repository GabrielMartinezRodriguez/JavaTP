package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class ExplosiveShip extends RegularShip {

	public ExplosiveShip(Game game, Cord cord, int live) {
		super(game, cord, live);
	}
	public String toString()
	{
		return ("E[" + live + "]");
	}
	
	public boolean performAttack(GameObject other){
		if(other == null)
			game.explosive(cord);
		return false;
	}
	
	public static boolean canGenerateExplosiveShip(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getExplosiveShipFrequency();
	}
	public String objectAsString() {
		String str = "E;" + cord.get_col() + ";" + cord.get_row() + ";" + live + ";" +
				(game.getLevel().getNumCyclesToMoveOneCell() - game.getCurrentCycle() %
						game.getLevel().getNumCyclesToMoveOneCell())
				+ AlienShip.getMove() + "\n";
		return str;
	}
}
