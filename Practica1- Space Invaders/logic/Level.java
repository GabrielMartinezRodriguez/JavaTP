package tp.p1.logic;
import tp.p1.util.*;

public enum Level {
		EASY,HARD,INSANE;
	private int		n_destroyer;
	private int		n_regular;
	private float	f_shoot;
	private int		speed;
	private float	f_ovni;
	private Cord 	cord_regular;
	private Cord 	cord_destroyer;
	
	public void ini_level()
	{
		if(this == EASY)
		{
			n_destroyer = 2;
			n_regular = 4;
			f_shoot = 0.1f;
			speed = 3;
			f_ovni = 0.5f;
			cord_regular = new Cord(1,3);
			cord_destroyer = new Cord(2,4);
		}
		else if(this == HARD)
		{
			n_destroyer = 2;
			n_regular = 8;
			f_shoot = 0.3f;
			speed = 2;
			f_ovni = 0.2f;
			cord_regular = new Cord(1,3);
			cord_destroyer = new Cord(3,4);
		}
		else
		{
			n_destroyer = 4;
			n_regular = 12;
			f_shoot = 0.5f;
			speed = 1;
			f_ovni = 1f;
			cord_regular = new Cord(1,3);
			cord_destroyer = new Cord(4,3);
		}
	}
	public int get_n_destroyer()
	{
		return (n_destroyer);
	}
	public int get_n_regular()
	{
		return (n_regular);
	}
	public float get_f_shoot()
	{
		return (f_shoot);
	}
	public int get_speed()
	{
		return (speed);
	}
	public float get_f_ovni()
	{
		return (f_ovni);
	}
	public Cord get_cord_destroyer()
	{
		return (cord_destroyer);
	}
	public Cord get_cord_regular()
	{
		return (cord_regular);
	}
}
