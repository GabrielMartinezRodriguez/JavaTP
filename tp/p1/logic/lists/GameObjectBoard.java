package tp.p1.logic.lists;

import tp.p1.logic.objects.GameObject;
import tp.p1.util.Cord;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects;

	public GameObjectBoard (int width, int height) {
	// TODO implement
	}
	private int getCurrentObjects () {
		return (currentObjects);
	}
	public void add (GameObject object) {
	// TODO implement
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
		while(i < objects.length)
		{
			if(objects[i].isOnPosition(cord))
				return(objects[i]);
			i++;
		}
		return (null);
		
	}
	private int getIndex(Cord cord) {
		int i;
	
		i = 0;
		while(i < objects.length)
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
		while(i < objects.length)
		{
			if(objects[i] == object)
				objects[i].onDelete();
			i++;
		}
	}
	public void update() {
	// TODO implement
	}
	private void checkAttacks(GameObject object) {
	// TODO implement
	}
	public void computerAction() {
	// TODO implement
	}
	private void removeDead() {
	// TODO implement
	}
	public String toString(Cord cord) {
	// TODO implement
	}

}
