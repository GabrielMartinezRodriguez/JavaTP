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
	
		level = Level.EASY;
		seed = rand.nextInt();
		if(Args.length == 2)
			seed = Integer.parseInt(Args[1]);
		levelString = Args[0].toLowerCase();
		if(levelString.contentEquals("easy"))
			level = Level.EASY;
		else if(levelString.contentEquals("hard"))
			level = Level.HARD;
		else if(levelString.contentEquals("insane"))
			level = Level.INSANE;
		
		control  = new Control(level, rand);
		rand.setSeed(seed);
		control.run();
	}
}
