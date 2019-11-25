package tp.p1.logic.objects;

import tp.p1.logic.lists.*;
import tp.p1.util.Cord;
public class UCMShip {
	private	int row;
	private int col;
	private int life;
	private boolean laser_av;
	private boolean shockwave;
	private UCMShipLaser laser;
	
	public void shoot()
	{
		if(laser_av == true)
		{
			laser = new UCMShipLaser(this.row, this.col);
			laser_av = false;
		}
	}
	public UCMShip()
	{
		this.row = 7;
		this.col = 3;
		this.life = 3;
		laser_av = true;
		shockwave = false;
	}
	public boolean ImHere(int col, int row)
	{
		if(this.col == col && this.row == row)
			return (true);
		else
			return (false);
	}
	public String toString()
	{
		String str;
		if(life > 0)
			str = "^__^";
		else
			str = "�xx�";
		return str;
	}
	public void Hurt()
	{
		life--;
	}
	public boolean LaserIsHere(int col, int row)
	{
		if(laser_av == false)
			return(laser.ImHere(col, row));
		else
			return false;
	}
	public String PrintLaser()
	{
		return(laser.toString());
	}
	public boolean get_shockwave()
	{
		return (shockwave);
	}
	public void move(int key)
	{
		if(key == 0 && col > 0)
			col--;
		else if (key == 1 && col < 8)
			col++;
		else if (key == 2 && col < 7)
			col = col + 2;
		else if (key == 3 && col > 1)
			col = col - 2;
	}
	public void set_shockwave(boolean shock)
	{
		shockwave = shock;
	}
	public int get_life()
	{
		return (life);
	}
	public void AvanzarLaser()
	{
		if(laser_av == false)
			laser.avanzar();
	}
	public int test(DestroyerShipList Destroyers, RegularShipList Regulars, BombList Bombs, Ovni ovni)
	{
		Cord cord;
		int pos;
		int puntos;
		
		puntos = 0;
		if(laser_av == false)
		{
			cord = laser.get_cord();	
			if(cord.get_row() == -1)
				laser_av = true;
			if(Destroyers.is_destroyer(cord.get_row(), cord.get_col()) != -1)
			{
				pos = Destroyers.is_destroyer(cord.get_row(), cord.get_col());
				Destroyers.Hurt(pos);
				laser_av = true;
			}
			if(Regulars.is_regular(cord.get_row(), cord.get_col()) != -1)
			{
				pos = Regulars.is_regular(cord.get_row(), cord.get_col());
				Regulars.Hurt(pos);
				laser_av = true;
			}
			if(Bombs.is_bomb(cord.get_row(), cord.get_col()) != -1)
			{
				pos = Bombs.is_bomb(cord.get_row(), cord.get_col());
				Bombs.eliminate_bomb(pos);
				laser_av = true;
			}
			if(ovni.ImHere(cord.get_col(), cord.get_row()))
			{
				ovni.Eliminate();
				puntos = 25;
				shockwave = true;
				laser_av = true;
			}
		}
		return (puntos);
	}
	public int get_col()
	{
		return (col);
	}
}
