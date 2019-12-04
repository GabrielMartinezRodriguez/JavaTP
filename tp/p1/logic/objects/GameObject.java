package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.util.Cord;

public abstract class GameObject implements IAttack {
	protected Cord cord;
	protected int live;
	protected Game game;

	public GameObject( Game game, Cord cord, int live) {
		this.cord = cord;
		this. game = game;
		this.live = live;
	}
	public Cord getCord()
	{
		return (this.cord);
	}
	public void setCord(Cord cord)
	{
		this.cord = cord;
	}
	public boolean isAlive() {
		return this.live > 0;
	}

	public int getLive() {
		return this.live;
	}

	public boolean isOnPosition(Cord cord) {
		return this.cord.equals(cord) ;
	}

	public void getDamage (int damage) {
		this.live = ((damage >= this.live) ? (0) : (this.live - damage));
	}

	public boolean isOut() {
		return !game.isOnBoard(this.cord);
	}
	public abstract void computerAction();

	public abstract void onDelete();

	public abstract void move();

	public abstract String toString();
	
	public boolean receiveMissileAttack(int damage) {
		this.getDamage(damage);
		return true;
	};
	public boolean receiveBombAttack(int damage) {
		this.getDamage(damage);
		return true;
	};
	public boolean receiveShockWaveAttack(int damage) {
		this.getDamage(damage);
		return true;
	}
	public boolean receiveExplosiveShipAttack(int damage) {
		this.getDamage(damage);
		return true;
	}
	public Game getGame() {
		return game;
	}
	public abstract String objectAsString();
}
