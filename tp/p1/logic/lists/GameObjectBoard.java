package tp.p1.logic.lists;

import tp.p1.logic.objects.Bomb;
import tp.p1.logic.objects.DestroyerShip;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.objects.RegularShip;
import tp.p1.logic.objects.UCMShip;
import tp.p1.logic.objects.UCMShipLaser;
import tp.p1.util.Cord;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects;

	public GameObjectBoard (int width, int height) {
		objects = new GameObject[width * height];
		currentObjects = 0;
	}
	private int getCurrentObjects (){
		return (currentObjects);
	}
	public void add (GameObject object) {
		objects[currentObjects] = object;
		currentObjects++;
	}
	public boolean isInBoard(Cord cord)
	{
		if(getIndex(cord) < 0)
			return (false);
		return (true);
	}
	private GameObject getObjectInPosition (Cord cord) {
		int i;
		
		i = 0;
		while(i < currentObjects)
		{
			if(objects[i].isOnPosition(cord) && objects[i].isAlive())
				return(objects[i]);
			i++;
		}
		return (null);
		
	}
	private int getIndex(Cord cord) {
		int i;
	
		i = 0;
		while(i < currentObjects)
		{
			if(objects[i].isOnPosition(cord))
				return (i);
			i++;
		}
		return (-1);
	}
	//puede ser publico
	private void remove (GameObject object) {
		int i;
	
		i = 0;
		while(i < currentObjects)
		{
			if(objects[i] == object)
				objects[i].onDelete();
			i++;
		}
	}
	public void update() {
		moveLaser();
		testLaser();
		moveBombs();
		testBombs();
		ovniMove();
		alienMove();
		testLaser();
	}
	private void checkAttacks(GameObject object) {
	// TODO implement
	}
	public void computerAction() {
		
	}
	private void removeDead() {
	// TODO implement
	}
	public String toString(Cord cord) {
		GameObject picture;

		picture = getObjectInPosition(cord);
		if(picture != null)
			return(picture.toString());
		else
			return("    ");
	}
	
	public void moveLaser()
	{
		int i;
		boolean flag;
		
		i = 0;
		flag = true;
		while(i < currentObjects && flag)
		{
			if(objects[i].getClass() == UCMShipLaser.class)
					flag = false;
			i++;
		}
		objects[i - 1].move();
	}
	public void testLaser()
	{
		int i;
		int j;
		boolean flag;
		
		i = 0;
		flag = true;
		while(i < currentObjects && flag)
		{
			if(objects[i].getClass() == UCMShipLaser.class)
					flag = false;
			i++;
		}
		i--;
		j = 0;
		while(j < currentObjects)
		{
			if(objects[j].getClass() == Bomb.class || objects[j].getClass() == DestroyerShip.class ||
					objects[j].getClass() == RegularShip.class || objects[j].getClass() == Ovni.class)
			{
				objects[i].performAttack(objects[j]);
			}
			j++;
		}
	}
	public void moveBombs()
	{
		int i;
		
		i = 0;
		while(i < currentObjects)
		{
			if(objects[i].getClass() == Bomb.class)
				objects[i].move();
			i++;
		}
		
	}
	public void testBombs(){
		int i;
		int j;
		boolean flag;
	
		i = 0;
		j = 0;
		flag = true;
		while(i < currentObjects && flag)
		{
			if(objects[i].getClass() == UCMShip.class)
					flag = false;
			i++;
		}
		i--;
		j = 0;
		while(j < currentObjects)
		{
			if(objects[j].getClass() == UCMShip.class)
				objects[j].performAttack(objects[i]);
			j++;
		}
	}
	
	public void ovniMove()
	{
		int 	i;
		boolean flag;
	
		i = 0;
		flag = true;
		while(i < currentObjects && flag)
		{
			if(objects[i].getClass() == Ovni.class)
				flag = false;
			i++;
		}
		i--;
		if(objects[i].getLive() > 0)
			objects[i].move();
	}
	public void alienMove()
	{
		
	}
}
