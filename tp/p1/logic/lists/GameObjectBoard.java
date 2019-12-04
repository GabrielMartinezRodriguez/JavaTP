package tp.p1.logic.lists;

import tp.p1.logic.Game;
import tp.p1.logic.objects.AlienShip;
import tp.p1.logic.objects.Bomb;
import tp.p1.logic.objects.DestroyerShip;
import tp.p1.logic.objects.EnemyShip;
import tp.p1.logic.objects.ExplosiveShip;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.objects.RegularShip;
import tp.p1.logic.objects.Shockwave;
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
	public int getCurrentObjects (){
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
	public boolean alienAllDead()
	{
		int			i;
		boolean 	flag;

		i = 0;
		flag = true;
		while(i < currentObjects && flag)
		{
			if((objects[i] instanceof AlienShip)
					&& objects[i].isAlive())
				flag = false;
			i++;
		}
		return flag;
	}
	
	public boolean haveLanded()
	{
		int			i;
		boolean 	flag;

		i = 0;
		flag = true;
		while(i < currentObjects && flag)
		{
			if((objects[i] instanceof AlienShip)
					&& objects[i].getCord().get_row() == Game.DIM_Y - 1 && objects[i].isAlive())
				flag = false;
			i++;
		}
		return !flag;
	}
	
	private GameObject getObjectInPosition (Cord cord) {
		int i;
		GameObject obj = null;
		i = 0;
		while(i < currentObjects)
		{
			if(objects[i].isOnPosition(cord) && (objects[i].isAlive() || objects[i].getClass() == UCMShip.class))
				obj = objects[i];
			i++;
		}
		return (obj);
		
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
		int i;
	
		i = 0;
		while(i < currentObjects)
		{
			if(objects[i].getClass() == DestroyerShip.class
				&& DestroyerShip.canGenerateRandomBomb(objects[i].getGame()))
				objects[i].computerAction();
			if(objects[i].getClass() == Ovni.class
				&& Ovni.canGenerateRandomOvni(objects[i].getGame()))
				objects[i].computerAction();
			if(objects[i].getClass() == RegularShip.class
				&& ExplosiveShip.canGenerateExplosiveShip(objects[i].getGame()))
				objects[i].computerAction();
			i++;
		}
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
		if(objects[i - 1].getCord().get_row() < 0)
			objects[i - 1].getDamage(1);
	}
	public void testLaser()
	{
		int i;
		int j;
		boolean flag;
		UCMShipLaser laser;
		
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
		laser = (UCMShipLaser)objects[i];
		flag = false;
		while(j < currentObjects)
		{
			if(objects[j].getClass() == Bomb.class || objects[j] instanceof EnemyShip)
			{
				if(objects[j].getClass() == Ovni.class && objects[j].isOnPosition(objects[i].getCord()))
					objects[j].getGame().enableShockWave();
				if(laser.performAttack(objects[j]))
					flag = true;
			}
			j++;
		}
		if(flag)
			laser.dead();
	}
	public void moveBombs()
	{
		int i;
		
		i = 0;
		while(i < currentObjects)
		{
			if(objects[i].getClass() == Bomb.class)
			{
				objects[i].move();
				if(objects[i].getCord().get_row() >= Game.DIM_Y)
					objects[i].getDamage(1);
			}
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
			if(objects[j].getClass() == Bomb.class)
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
		if(objects[i].getCord().get_col() < 0)
			objects[i].getDamage(1);
		
	}
	private void checkMove()
	{
		int 	i;
		boolean flag;
		
		i = 0;
		flag = true;
		while(i < currentObjects && flag)
		{
			if((objects[i] instanceof AlienShip)
					&& objects[i].isAlive())
			{
				if(objects[i].getCord().get_col() == 0 && AlienShip.move == -1)
				{
					AlienShip.move = 0;
					flag = false;
				}
				else if(objects[i].getCord().get_col() == 0 && AlienShip.move == 0)
				{
					AlienShip.move = 1;
					flag = false;
				}
				else if(objects[i].getCord().get_col() == Game.DIM_X - 1 && AlienShip.move == 1)
				{
					AlienShip.move = 0;
					flag = false;
				}
				else if(objects[i].getCord().get_col() == Game.DIM_X - 1 && AlienShip.move == 0)
				{
					AlienShip.move = -1;
					flag = false;
				}
			}
			i++;
		}
	}
	public void alienMove()
	{
		int 	i;
	
		i = 0;
		checkMove();
		while(i < currentObjects)
		{
			if(objects[i] instanceof AlienShip)
				objects[i].move();
			i++;
		}
	}
	public void shockWave(Shockwave shock)
	{
		if(shock.getEnable()) {
			for(int i = 0; i < currentObjects; i++)
			{
				if(objects[i] instanceof AlienShip)
					shock.performAttack(objects[i]);
			}
		}
	}
	
	public int countAliens()
	{
		int cont;
	
		cont = 0;
		for(int i = 0; i < currentObjects; i++)
		{
			if(objects[i] instanceof AlienShip)
				cont++;
		}
		return (cont);
	}
	public void explosive(Cord cord) {
		GameObject	object;
		Cord cpy = new Cord(cord);
		
		cpy.set_col(cpy.get_col() - 1);
		cpy.set_row(cpy.get_row() - 1);
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				object = getObjectInPosition(cpy);
				if(object != null)
					object.getDamage(1);
				cpy.set_col(cpy.get_col() + 1);
			}
			cpy.set_col(cpy.get_col() - 3);
			cpy.set_row(cpy.get_row() + 1);
		}
	}
	public boolean replace(GameObject old, GameObject replace)
	{
		int i;
		boolean flag;
	
		i = 0;
		flag = true;
		while(i < currentObjects && flag)
		{
			if(objects[i] == old)
			{
				objects[i] = replace;
				flag = false;
			}
			i++;
		}
		return (!flag);
	}
	public String boardAsString()
	{
		String str = "";
		for(int i = 0; i < currentObjects; i++)
		{
			str += objects[i].objectAsString();
		}
		return (str);
	}
}
