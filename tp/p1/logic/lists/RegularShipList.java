package tp.p1.logic.lists;
import tp.p1.logic.objects.*;
import tp.p1.util.Cord;
import tp.p1.logic.*;
public class RegularShipList {
		RegularShip[] Regulars;
	public RegularShipList(Level level)
	{
		int cantidad;
		Cord cord;
		cantidad = level.get_n_regular();
		Regulars = new RegularShip[cantidad];
		cord = level.get_cord_regular();
		for(int i = 0; i < cantidad; i++)
			Regulars[i] = new RegularShip(cord.get_row() + i/4, cord.get_col() + i % 4);
	}
	
	public int is_regular(int row, int col)
	{
		int flag;
		int i;

		i = 0;
		flag = -1;
		while(i < Regulars.length && !Regulars[i].ImHere(col, row))
			i++;
		if(i != Regulars.length)
			flag = i;
		return (flag);
	}
	public String dibujar(int i)
	{
		return (Regulars[i].toString());
	}
	public void ShockWave()
	{
		for(int i = 0; i < Regulars.length; i++)
			Regulars[i].Hurt();
	}
	public void Hurt(int i)
	{
		Regulars[i].Hurt();
	}
	public boolean islimit()
	{
		Cord cord;
		boolean limit = false;
		for(int i = 0; i < Regulars.length; i++)
		{
			cord = Regulars[i].get_cord();
			if(cord.get_col() == 0 || cord.get_col() == 8)
			{
				limit = true;
			}
		}
		return (limit);
	}
	public void move(int col, int row)
	{
		for(int i = 0; i < Regulars.length; i++)
		{
			Regulars[i].move(col, row);
		}
	}
	public int ContarVivos()
	{
		int contador;
		
		contador = 0;
		for(int i = 0; i < 	Regulars.length; i++)
		{
			if(Regulars[i].isLive())
				contador++;
		}
		return (contador);
	}
	public int ContarMuertos()
	{
		int contador;
		
		contador = 0;
		for(int i = 0; i < 	Regulars.length; i++)
		{
			if(Regulars[i].isLive())
				contador++;
		}
		return (Regulars.length - contador);
	}
}
