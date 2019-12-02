package tp.p1.control;

import tp.p1.logic.*;
import java.util.*;

public class Control {
	private Game juego;
	private Scanner in;
	private Random rand;
	public Control(Level Level)
	{
		in = new Scanner(System.in);
		juego = new Game(Level, rand);
		juego.initGame();
	}
	public void run(Random rand)
	{
		boolean mod_game; 
		boolean flag;
		String [] words;
		Command command;
		
		flag = true;
		while(flag)
		{
			System.out.println(juego);
			if(true)//if(juego.Fin() == 0)
			{
				mod_game = false;
				while(mod_game == false)
				{
					System.out.print("Command >");
					words = in.nextLine().toLowerCase().trim().split("\\s+");
					command = CommandGenerator.parseCommand(words);
					
					if(command != null)
						mod_game = command.execute(juego);
					else
						System.out.println("Comando desconocido");
				}
				juego.update();
			}
			else
				flag = false;
			
		}
		if(true)//if(juego.Fin() == 1)
			System.out.println("PLAYER WIN");
		else
			System.out.println("ALIEN WIN");
	}
	
}
	
