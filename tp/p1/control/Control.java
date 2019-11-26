package tp.p1.control;

import tp.p1.logic.*;
import java.util.*;

public class Control {
	private Game juego;
	private Scanner in;

	public Control(String Level)
	{
		in = new Scanner(System.in);
		juego = new Game();
		juego.initGame(Level);
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
			if(juego.Fin() == 0)
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
				juego.computerAction(rand);
				juego.update();
			}
			else
				flag = false;
			
		}
		if(juego.Fin() == 1)
			System.out.println("PLAYER WIN");
		else
			System.out.println("ALIEN WIN");
	}
	
}
	
