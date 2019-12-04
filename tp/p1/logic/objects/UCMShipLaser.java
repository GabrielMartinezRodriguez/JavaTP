package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public class UCMShipLaser extends Weapon {

	public UCMShipLaser(Game game, Cord cord, int live) {
		super(game, cord, live);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return (" oo ");
	}
	public void move()
	{
		cord.set_row(cord.get_row() - 1);
	}
	public boolean performAttack(GameObject other){
		EnemyShip alien;
			
		if(other.getCord().equals(this.cord) && this.isAlive() && other.isAlive())
		{
			other.receiveMissileAttack(1);
			if(!other.isAlive() && (other instanceof EnemyShip))
			{
				alien = (EnemyShip)other;
				game.setPoints(game.getPoints() + alien.getPoints());
				if(other.getClass() == ExplosiveShip.class)
					other.performAttack(null);
			}
			return true;
		}
		return false;
	}
	public void dead()
	{
		this.live = -1;
	}
	public String objectAsString() {
		String str = "M;" + cord.get_col() + ";" + cord.get_row();
		return str;
	}
}
