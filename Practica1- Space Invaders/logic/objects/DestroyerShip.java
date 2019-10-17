package tp.p1.logic.objects;
import tp.p1.util.*;
public class DestroyerShip {
	private Cord cord;
	private int life;
	
	public DestroyerShip(int col, int row){
		cord = new Cord(row, col);
		life = 1;
		
	}
	public boolean ImHere(int col, int row)
	{
		if(cord.get_col() == col && cord.get_row() == row && life > 0)
			return (true);
		else
			return (false);
	}
	public Cord get_cord()
	{
		return(cord);
	}
	public int get_life()
	{
		return(life);
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
	public String toString()
	{
		return("D["+life+"]");
	}
	public void Hurt()
	{
		life--;
	}
}
