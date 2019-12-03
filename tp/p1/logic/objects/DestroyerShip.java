package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.logic.lists.GameObjectBoard;
import tp.p1.util.Cord;

public class DestroyerShip extends AlienShip implements IExecuteRandomActions{

	private Bomb bomb;
	public DestroyerShip(Game game, Cord cord, int live, GameObjectBoard board) {
		super(game, cord, live);
		bomb = new Bomb(game, new Cord(cord), -1);
		board.add(bomb);
		points = 10;
		// TODO Auto-generated constructor stub
	}
	public String toString()
	{
		return ("D["+live+"]");
	}
	public static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
	}
	public void computerAction()
	{
		Cord cpy;
		if(!bomb.isAlive() && isAlive())
		{
			cpy = new Cord(this.cord);
			bomb.setCord(cpy);
			bomb.onDelete();
		}
	}
}
