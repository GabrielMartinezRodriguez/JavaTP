package tp.p2.logic.lists;

import tp.p2.logic.Game;
import tp.p2.logic.objects.AlienShip;
import tp.p2.logic.objects.GameObject;
import tp.p2.logic.objects.Shockwave;
import tp.p2.logic.objects.SuperMisil;
import tp.p2.logic.objects.UCMShipLaser;
import tp.p2.util.Cord;

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
			if((objects[i].imAlien())
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
			if(objects[i].haveLanded())
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
			if(objects[i].isOnPosition(cord) && (objects[i].isAlive()))
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
	@SuppressWarnings("unused")
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
	@SuppressWarnings("unused")
	private void checkAttacks(GameObject object) {
	// TODO implement
	}
	public void computerAction() {
		int i;
	
		i = 0;
		while(i < currentObjects)
		{
			objects[i].computerAction();
			i++;
		}
	}
	@SuppressWarnings("unused")
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
		
		i = 0;
		while(i < currentObjects)
		{
			if(objects[i].imUCMShipLaser())
			{
				objects[i].move();
				if(objects[i].getCord().get_row() < 0)
					objects[i].getDamage(1);
			}
			i++;
		}
		
	}
	public void testLaser()
	{
		int i;
		int j;
		int k;
		boolean flag1;
		boolean flag2;
		UCMShipLaser laser;
		SuperMisil misil;
	
		k = 0;
		j = 0;
		i = 0;
		while(j < currentObjects)
		{
			if(objects[j].imUCMShipLaserStrict())
					i = j;
			if(objects[j].imSuperMisil())
					k = j;
			j++;
		}
		j = 0;
		laser = (UCMShipLaser)objects[i];
		misil = (SuperMisil)objects[k];
		flag1 = false;
		flag2 = false;
		while(j < currentObjects)
		{
			if(objects[j].imBomb()|| objects[j].imEnemyShip())
			{
				if(objects[j].imOvni() && objects[j].isOnPosition(objects[i].getCord()))
					objects[j].getGame().enableShockWave();
				if(laser.performAttack(objects[j]))
					flag1 = true;
				if(misil.performAttack(objects[j]))
					flag2 = true;
			}
			j++;
		}
		if(flag1)
			laser.dead();
		if(flag2)
			misil.dead();
	}
	public void moveBombs()
	{
		int i;
		
		i = 0;
		while(i < currentObjects)
		{
			if(objects[i].imBomb())
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
			if(objects[i].imUCMShip())
					flag = false;
			i++;
		}
		i--;
		j = 0;
		while(j < currentObjects)
		{
			if(objects[j].imBomb())
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
			if(objects[i].imOvni())
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
		while(i < currentObjects && flag &&  objects[0].getGame().getCurrentCycle() % objects[0].getGame().getLevel().getNumCyclesToMoveOneCell() == 0)
		{
			if((objects[i].imAlien())
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
			if(objects[i].imAlien())
				objects[i].move();
			i++;
		}
	}
	public void shockWave(Shockwave shock)
	{
		if(shock.getEnable()) {
			for(int i = 0; i < currentObjects; i++)
			{
				if(objects[i].imAlien())
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
			if(objects[i].isAlive())
				str += objects[i].objectAsString();
		}
		return (str);
	}
}
