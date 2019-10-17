package tp.p1;
import java.util.*;
import tp.p1.control.*;

public class Main {
	public static void main(String[] Args)
	{
		long seed;
		String Level;
		boolean Correct;
		Control control;
		Random rand = new Random();
		
		Correct = true;
		seed = rand.nextInt();
		if(Args.length == 2)
			seed = Integer.parseInt(Args[1]);
		Level = Args[0].toLowerCase();
		
		if(!Level.contentEquals("easy"))
		{
			if(!Level.contentEquals("hard"))
			{
				if(!Level.contentEquals("insane"))
					Correct = false;
			}
		}
		
		if(Correct)
		{
			control  = new Control(Level);
			rand.setSeed(seed);
			control.run(rand);
		}
		else
			System.out.println("ERROR EN LOS ARGUMENTOS");
		
		
	}
}
