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
	public static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	public void move()
	{
		cord.set_col(cord.get_col() - 1);
	}
	public void computerAction()
	{
		if(!isAlive())
		{
			cord = new Cord(0, Game.DIM_X);
			live = 1;
		}
	}
	public String objectAsString() {
		String str = "O;" + cord.get_col() + ";" + cord.get_row() + ";" + live + "\n";
		return str;
	}
}
