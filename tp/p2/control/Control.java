package tp.p2.control;

import java.util.*;

import tp.p2.logic.*;

public class Control {
	private Game juego;
	private Scanner in;
	@SuppressWarnings("unused")
	private Random rand;

	public Control(Level Level, Random rand)
	{
		this.rand = rand;
		in = new Scanner(System.in);
		juego = new Game(Level, rand);
		juego.initGame();
	}
	public void run()
	{
		boolean mod_game; 
		boolean flag;
		String [] words;
		Command command;
		
		flag = true;
		while(flag)
		{
			System.out.println(juego);
			if(!juego.isFinished())
			{
				mod_game = false;
				while(mod_game == false)
				{
					System.out.print("Command >");
					words = in.nextLine().toLowerCase().trim().split("\\s+");
					try {
						command = CommandGenerator.parseCommand(words);
					
						if(command != null)
							mod_game = command.execute(juego);
						else
							System.out.println("Comando desconocido");
					}catch(CommandParseException | CommandExecuteException ex) {
						System.out.format(ex.getMessage() + " %n %n");
					}
				}
				juego.update();
			}
			else
				flag = false;
		}
		if(!juego.aliensWin())
			System.out.println("PLAYER WIN");
		else
			System.out.println("ALIEN WIN");
	}
	
}
	
