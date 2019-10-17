package tp.p1.logic.objects;

import tp.p1.util.*;

public class UCMShipLaser {
	private Cord cord;
	
	public UCMShipLaser(int row, int col)
	{
		cord = new Cord(row,col);
	}
	public String toString() 
	{
		return (" oo ");
	}
	public boolean ImHere(int col, int row)
	{
		if(cord.get_col() == col && cord.get_row() == row)
			return (true);
		else
			return (false);
	}
	public Cord get_cord()
	{
		return (cord);
	}
	public void avanzar()
	{
		cord.set_row(cord.get_row() - 1);
	}
}
