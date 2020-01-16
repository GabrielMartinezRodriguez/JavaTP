package tp.p2.logic.objects;

import tp.p2.logic.Game;
import tp.p2.util.Cord;

public class UCMShipLaser extends Weapon {

	protected int damage;

	public UCMShipLaser(Game game, Cord cord, int live) {
		super(game, cord, live);
		damage = 1;
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
			other.receiveMissileAttack(damage);
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
		String str = "M;" + cord.get_col() + ";" + cord.get_row() + "\n";
		return str;
	}
	public boolean imUCMShipLaser()
	{
		return true;
	}
	public boolean imUCMShipLaserStrict()
	{
		return true;
	}
}
