package tp.p1;
import java.util.*;
import tp.p1.control.*;
import tp.p1.logic.Level;

public class Main {
	public static void main(String[] Args)
	{
		long seed;
		String levelString;
		Level level;
		Control control;
		Random rand = new Random();
		

		rand.setSeed(123);
		try {
			
			if (Args.length > 2 || Args.length < 1)
				throw new BadArgumentsException("Numero erroneo de parametros");
			
			levelString = Args[0].toLowerCase();
			
			if(levelString.contentEquals("easy"))
				level = Level.EASY;
			else if(levelString.contentEquals("hard"))
				level = Level.HARD;
			else if(levelString.contentEquals("insane"))
				level = Level.INSANE;
			else
				throw new BadArgumentsException("No se ha encontrado el nivel indicado");
			
			if(Args.length == 2)
			{
				seed = Integer.parseInt(Args[1]);
				rand.setSeed(seed);
			}
		}catch(BadArgumentsException | RuntimeException e) {
			System.out.println("Se procededar a ejecutar el juego en modo EASY y semilla 123");
			System.out.println("Cause of exception:");
			System.out.println(" " + e);
			level = Level.EASY;
		}
		control  = new Control(level, rand);
		control.run();
	}
}
