package tp.p1.logic.lists;
import tp.p1.logic.Level;
import tp.p1.logic.objects.*;

public class BombList {
	private Bomb[] bombas;
	
	public BombList(Level nivel)
	{
		int cantidad;

		cantidad = nivel.get_n_destroyer();
		bombas = new Bomb[cantidad];
		for(int i = 0; i < bombas.length; i++)
			bombas[i] = new Bomb();
	}
	public void shoot(int i, int col, int row)
	{
		if(i < bombas.length)
		{
			if(bombas[i].get_state() != true)
			{
				bombas[i].shoot(col, row); 
			}
		}
	}
	public int is_bomb(int row, int col)
	{
		int flag;
		int i;

		i = 0;
		flag = -1;
		while(i < bombas.length && !bombas[i].ImHere(col, row))
			i++;
		if(i != bombas.length)
			flag = i;
		return (flag);
	}
	public String dibujar(int i)
	{
		return (bombas[i].toString());
	}
	public void eliminate_bomb(int i)
	{
		bombas[i].set_alive(false);
	}
	public void avanzar()
	{
		for(int i = 0; i < bombas.length; i++)
			bombas[i].avanzar();
	}
	
}
