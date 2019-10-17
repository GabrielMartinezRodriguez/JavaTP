package tp.p1.control;

import tp.p1.logic.*;
import java.util.*;

public class Control {
	Game juego;
	Scanner obj;
	public Control(String Level)
	{
		obj = new Scanner(System.in);
		juego = new Game();
		juego.initGame(Level);
	}
	public void run(Random rand)
	{
		boolean mod_game; 
		boolean flag;
		int key;
		String command;
		
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
					command = obj.nextLine();
					command = command_fix(command);
					key = command_scanner(command);
					mod_game = command_exe(key); 
				}
				juego.ComputerAction(rand);
				juego.Update();
			}
			else
				flag = false;
			
		}
		if(juego.Fin() == 1)
			System.out.println("PLAYER WIN");
		else
			System.out.println("ALIEN WIN");
	}
	private int command_scanner(String command)
	{
		int key;
		command = command.toLowerCase();

		if(command.equals("m 1") || command.equals("m 2")|| command.equals("move 1") || command.equals("move 2"))
		{
			if(command.equals("m 1")|| command.equals("move 1"))
				key = 0;
			else
				key = 1;
		}
		else if(command.equals("shoot") || command.equals("s"))
			key = 2;
		else if(command.equals("shockwave") || command.equals("w"))
			key = 3;
		else if(command.equals("reset") || command.equals("r"))
			key = 4;
		else if(command.equals("exit") || command.equals("e"))
			key  = 5;
		else if(command.equals(""))
			key  = 6;
		else if(command.equals("help") || command.equals("h"))
			key = 7;
		else if(command.equals("list") || command.equals("l"))
			key = 8;
		else
			key = 9;
		return (key);
	}
	private String command_fix(String command)
	{
		StringTokenizer aux;
		int count_tokens;
	
		command = command.toLowerCase();
		aux = new StringTokenizer(command);
		command="";
		count_tokens =  aux.countTokens();
		for(int i = 0; i < count_tokens; i++)
		{
			if(i != 0)
				command+=" ";
			command+=aux.nextToken();
		}
		return (command);
	}
	private boolean command_exe(int command)
	{
		boolean command_mod;
		
		if(command < 7)
			command_mod = true;
		else
			command_mod = false;
		
		switch(command)
		{
			case 0:
				juego.c_Move(0);
				break;
			case 1:
				juego.c_Move(1);
				break;
			case 2:
				juego.c_Shoot();
				break;
			case 3:
				juego.c_ShockWave();
				break;
			case 4:
				juego.c_reset();
				break;
			case 5:
				juego.c_exit();
				break;
			case 6:
				//nothing to do
				break;
			case 7:
				juego.c_help();
				break;
			case 8:
				juego.c_list();
				break;
			case 9:
				juego.c_error();
				break;
		}
		return (command_mod);
	}
	
}
	
