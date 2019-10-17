package tp.p1.logic;
import tp.p1.util.*;

import java.util.Random;

import tp.p1.logic.lists.*;
import tp.p1.logic.objects.*;

public class Game {
	
	DestroyerShipList Destroyers;
	RegularShipList Regulars;
	BombList Bombs;
	Ovni Ovni;
	UCMShip Ship;
	Level level;
	Move move;
	int puntosOvni;
	public Game()
	{
		
	}
	public void move()
	{
		move.move(Destroyers, Regulars);
	}
	public String toString()
	{
		int vivos;
		int puntos;
		
		puntos = 0;
		puntos = Destroyers.ContarMuertos() * 10 +  Regulars.ContarMuertos() * 5 + puntosOvni;
 		vivos = Destroyers.ContarVivos() + Regulars.ContarVivos();
		
		String Informacion = new String("Life: ");
		Informacion = Informacion + Ship.get_life() + "\nNumber of cycles: ";
		Informacion = Informacion + move.get_ciclos() + "\nPoints: ";
		
		Informacion = Informacion + puntos + "\nRemaining aliens: "; 
		Informacion = Informacion + vivos + "\nShockWave: ";
		
		if(Ship.get_shockwave())
			Informacion = Informacion + "SI";
		else
			Informacion = Informacion + "NO";
		Informacion = Informacion + "\n\n\n";
		GamePrinter print = new GamePrinter(this,8,9);
		return (Informacion + print.toString());
	}
	public void initGame(String Level)
	{
		puntosOvni = 0;
		if(Level.contentEquals("easy"))
			level = level.EASY;
		else if(Level.contentEquals("hard"))
			level = level.HARD;
		else
			level = level.INSANE;
		
		level.ini_level();
		Destroyers = new DestroyerShipList(level);
		Regulars = new RegularShipList(level);
		Ovni = new Ovni(level);
		Bombs = new BombList(level);
		Ship = new UCMShip();
		move = new Move(level);
	}
	public void Update()
	{
		Ship.AvanzarLaser();
		TestLaser();
		TestBombs();
		Ovni.move();
		move();
		TestLaser();
		
	}
	public void ComputerAction(Random rand)
	{
		AlienShoot(rand);
		Ovni.generation(rand);
		
	}
	public String toStringObjectAt(int i, int j)
	{
		int pos;
		String casilla = "    ";

		if(Bombs.is_bomb(i, j) != -1)
		{
			pos = Bombs.is_bomb(i, j);
			casilla = Bombs.dibujar(pos);
		}
		if(Ship.ImHere(j, i))
			casilla = Ship.toString();
		if(Ship.LaserIsHere(j, i))
			casilla = Ship.PrintLaser();
		if(Destroyers.is_destroyer(i, j) != -1)
		{
			pos = Destroyers.is_destroyer(i, j);
			casilla = Destroyers.dibujar(pos);
		}
		if(Regulars.is_regular(i, j) != -1)
		{
			pos = Regulars.is_regular(i, j);
			casilla = Regulars.dibujar(pos);
		}
		
		if(Ovni.ImHere(j, i))
			casilla = Ovni.toString();
		return (casilla);
	}
	
	public void c_Move(int key)
	{
		Ship.move(key);
	}
	public void c_Shoot()
	{
		Ship.shoot();
	}
	public void c_ShockWave()
	{
		if(Ship.get_shockwave())
		{
			Destroyers.ShockWave();
			Regulars.ShockWave();
			Ship.set_shockwave(false);
		}
	}
	public void c_reset()
	{
		String s_level;
		if(level.EASY == level)
			s_level = "easy";
		else if(level.HARD == level)
			s_level = "hard";
		else 
			s_level = "insane";
		initGame(s_level);
	}
	public void c_exit()
	{
		System.out.println("GAME OVER\n");
		System.exit(0);
	}
	public void c_help()
	{
		System.out.println(
				"Command > help\r\n" + 
				"move <left|right><1|2>: Moves UCM-Ship to the indicated direction.\r\n" + 
				"shoot: UCM-Ship launches a missile.\r\n" + 
				"shockWave: UCM-Ship releases a shock wave.\r\n" + 
				"list: Prints the list of available ships.\r\n" + 
				"reset: Starts a new game.\r\n" + 
				"help: Prints this help message.\r\n" + 
				"exit: Terminates the program.\r\n" + 
				"[none]: Skips one cycle.\r\n" + 
				"");
	}
	public void c_list()
	{
		System.out.println(
				"[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\r\n" + 
				"[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1\r\n" + 
				"[O]vni: Points: 25 - Harm: 0 - Shield: 1\r\n" + 
				"^__^: Harm: 1 - Shield: 3");
	}
	public void c_error()
	{
		System.out.println("Invalid command");
	}
	
	public void TestLaser()
	{
		
		puntosOvni += Ship.test(Destroyers, Regulars, Bombs, Ovni);
	}
	public void TestBombs()
	{
		int pos;
		Bombs.avanzar();
		if(Bombs.is_bomb(7, Ship.get_col()) != -1) {
			pos = Bombs.is_bomb(7, Ship.get_col());
			Ship.Hurt();
			Bombs.eliminate_bomb(pos);
		}
	}
	public void AlienShoot(Random rand)
	{
		Destroyers.AlienShoot(rand, Bombs);
	}
	public int Fin()
	{
		int ganador;
		ganador = 0;
		if((Destroyers.ContarVivos() + Regulars.ContarVivos()) == 0) 
			ganador = 1;
		else
		{
			for(int i = 0; i < 9; i++)
			{
				if(Destroyers.is_destroyer(7, i) != -1 || Regulars.is_regular(7, i)  != -1)
					ganador = -1;
			}
			if(Ship.get_life() < 1)
				ganador = -1;
		}
		return (ganador);
	}
	
}
