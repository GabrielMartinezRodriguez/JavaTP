package tp.p1.logic;
import tp.p1.logic.lists.*;
import tp.p1.logic.objects.Ovni;

public class Move {
	private int ciclos;
	private int col;
	private int row;
	private int f_move;
	private int estado;
	
	public Move(Level nivel)
	{
		ciclos = 0;
		estado = -1;
		col = -1;
		row = 0;
		f_move = nivel.get_speed();
	}
	public int get_ciclos()
	{
		return (ciclos);
	}
	public void move(DestroyerShipList Destroyers, RegularShipList Regulars)
	{
		if(ciclos % f_move == 0 || row == 1)
		{
			Regulars.move(row, col);
			Destroyers.move(row, col);
			if(row != 1)
			{
				if(Regulars.islimit())
				{
					row = 1;
					col = 0;
					estado = -estado;
				}
			}
			else
			{
				row = 0;
				col = estado;
			}
		}
		ciclos++;
	}
	public void OvniMove(Ovni ovni)
	{
		ovni.move();
	}
}
