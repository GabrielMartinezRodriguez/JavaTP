package tp.p1.logic.lists;
import java.util.Random;

import tp.p1.logic.*;
import tp.p1.logic.objects.*;
import tp.p1.util.*;
public class DestroyerShipList {
		DestroyerShip[] Destroyers;
		private float prob;
		
		public DestroyerShipList(Level nivel)
		{
			int cantidad;
			Cord cord;
			
			prob = nivel.get_f_shoot();
			cantidad = nivel.get_n_destroyer();
			Destroyers = new DestroyerShip[cantidad];
			cord = nivel.get_cord_destroyer();
			for(int i = 0; i < cantidad; i++)
				Destroyers[i] = new DestroyerShip(cord.get_col() + i, cord.get_row());
		}
		public int is_destroyer(int row, int col)
		{
			int flag;
			int i;

			i = 0;
			flag = -1;
			while(i < Destroyers.length && !Destroyers[i].ImHere(col, row))
				i++;
			if(i != Destroyers.length)
				flag = i;
			return (flag);
		}
		public String dibujar(int i)
		{
			return (Destroyers[i].toString());
		}
		public void ShockWave()
		{
			for(int i = 0; i < Destroyers.length; i++)
			{
				Destroyers[i].Hurt();
			}
		}
		public void Hurt(int i)
		{
			Destroyers[i].Hurt();
		}
		public void move(int col, int row)
		{
			for(int i = 0; i < Destroyers.length; i++)
			{
				Destroyers[i].move(col, row);
			}
		}
		public void AlienShoot(Random rand, BombList Bombs)
		{
			for(int i = 0; i < Destroyers.length; i++)
			{
				Cord cord;
				if(rand.nextFloat() <= prob )
				{
					if(Destroyers[i].get_life() > 0)
					{
						cord = Destroyers[i].get_cord();
						Bombs.shoot(i, cord.get_col(), cord.get_row());
					}
					
				}
			}
		}
		public int ContarVivos()
		{
			int contador;
			
			contador = 0;
			for(int i = 0; i < 	Destroyers.length; i++)
			{
				if(Destroyers[i].isLive())
					contador++;
			}
			return (contador);
		}
		public int ContarMuertos()
		{
			int contador;
			
			contador = 0;
			for(int i = 0; i < 	Destroyers.length; i++)
			{
				if(Destroyers[i].isLive())
					contador++;
			}
			return (Destroyers.length - contador);
		}
}
