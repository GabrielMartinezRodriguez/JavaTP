package tp.p1.logic.objects;
import tp.p1.util.*;
public class Bomb {
	private Cord cord;
	private boolean alive;

	public Bomb()
	{
		alive = false;
	}
	public boolean get_state()
	{
		return (alive);
	}
	public void shoot(int col, int row)
	{
		if(alive == false)
		{
			alive = true;
			cord = new Cord(row, col);
		}
	}
	public String toString()
	{
		return(" .  ");
	}
	public boolean ImHere(int col, int row)
	{
		if(alive)
		{
			if(cord.get_col() == col && cord.get_row() == row)
				return (true);
			else
				return (false);
		}
		else
			return (false);
	}
	public void set_alive(boolean alive)
	{
		this.alive = alive;
	}
	public void avanzar()
	{
		if(alive == true)
		{
			cord.set_row(cord.get_row() + 1);
			if(cord.get_row() == 8)
			{
				alive = false;
			}
		}
	}
}
