package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class DestroyerShip extends AlienShip implements IExecuteRandomActions{

	public DestroyerShip(Game game, Cord cord, int live) {
		super(game, cord, live);
		points = 10;
		// TODO Auto-generated constructor stub
	}
	public String toString()
	{
		return ("D["+live+"]");
	}
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
	}
}
