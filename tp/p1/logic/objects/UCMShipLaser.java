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
			this.live = -1;
			other.receiveMissileAttack(1);
			if(!other.isAlive() && (other.getClass() == Ovni.class || other.getClass() == DestroyerShip.class ||
					other.getClass() == RegularShip.class))
			{
				alien = (EnemyShip)other;
				game.setPoints(game.getPoints() + alien.getPoints());
			}
			return true;
		}
		return false;
	}
}
