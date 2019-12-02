package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class Ovni extends EnemyShip implements IExecuteRandomActions{

	public Ovni(Game game, Cord cord, int live) {
		super(game, cord, live);
		points = 25;
	}
	public String toString()
	{
		return ("O["+live+"]");
	}
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
}
