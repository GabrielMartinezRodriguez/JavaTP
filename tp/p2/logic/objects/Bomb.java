package tp.p2.logic.objects;

import tp.p2.logic.Game;
import tp.p2.util.Cord;

public class Bomb extends Weapon {

	public Bomb(Game game, Cord cord, int live) {
		
		super(game, new Cord(cord), live);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return (" .  ");
	}
	
	public void move()
	{
		cord.set_row(cord.get_row() + 1);
	}
	public boolean performAttack(GameObject other){
		if(other.getCord().equals(this.cord) && this.isAlive() && other.isAlive())
		{
			this.live = -1;
			other.receiveBombAttack(1);
			return true;
		}
		return false;
	}

	@Override
	public String objectAsString() {
		String str = "B;" + cord.get_col() + ";" + cord.get_row() + "\n";
		return str;
	}
	
	public boolean imBomb()
	{
		return true;
	}
}
