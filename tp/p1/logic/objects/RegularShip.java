package tp.p1.logic.objects;
import tp.p1.util.*;

public class RegularShip {
	private Cord cord;
	private int life;
	

	public RegularShip(int row, int col)
	{
		cord = new Cord(row, col);
		life = 2;
	}
	public boolean ImHere(int col, int row)
	{
		if(cord.get_col() == col && cord.get_row() == row && life > 0)
			return (true);
		else
			return (false);
	}
	public String toString()
	{
		String str = new String("C["+life+"]");
		return str;
	}
	public void Hurt()
	{
		life--;
	}
	public boolean isLive()
	{
		if(life > 0)
			return (true);
		else
			return (false);
	}	
	public void move(int row, int col)
	{
		cord.set_col(cord.get_col() + col);
		cord.set_row(cord.get_row() + row);
	}
	public Cord get_cord()
	{
		return(cord);
	}
	
}
