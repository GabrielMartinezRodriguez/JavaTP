package tp.p2.logic.objects;

import tp.p2.logic.Game;
import tp.p2.util.Cord;

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
	public  void computerAction() {
	}

	public boolean	haveLanded()
	{
		return false;
		
	}
	
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

	public boolean imAlien() {
		return false;
	}
	public boolean imUCMShip()
	{
		return false;
	}
	public boolean imUCMShipLaser()
	{
		return false;
	}
	public boolean imUCMShipLaserStrict()
	{
		return false;
	}
	public boolean imSuperMisil()
	{
		return false;
	}
	public boolean imBomb()
	{
		return false;
	}
	public boolean imEnemyShip()
	{
		return false;
	}
	public boolean imOvni()
	{
		return false;
	}
}
