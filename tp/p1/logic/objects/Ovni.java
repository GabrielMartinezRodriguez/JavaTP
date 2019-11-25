package tp.p1.logic.objects;

import tp.p1.util.Cord;

import java.util.Random;

import tp.p1.logic.Level;

public class Ovni {
	private Cord cord;
	private int life;
	private float prob;
	
	public Ovni(Level nivel)
	{	
		prob = nivel.get_f_ovni();
		life = 0;
	}
	public void generation(Random rand)
	{
		if(rand.nextFloat() <= prob && life == 0)
			IniLife();
	}
	public void move()
	{
		if(life > 0)
		{
			cord.set_col(cord.get_col() - 1);
			if(cord.get_col() == -1)
				life = 0;
		}
	}
	public void IniLife()
	{
		cord = new Cord(0, 9);
		life = 1;
	}
	public String toString()
	{
		return("O["+life+"]");
	}
	public boolean ImHere(int col, int row)
	{
		if(life > 0 && cord.get_col() == col && cord.get_row() == row )
			return (true);
		else
			return (false);
	}
	public void Eliminate()
	{
			life--;
	}
}
