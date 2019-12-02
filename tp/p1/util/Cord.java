package tp.p1.util;

public class Cord {
	private int row;
	private int col;
	
	public Cord(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	public Cord(Cord cord)
	{
		this.row = cord.get_row();
		this.col = cord.get_col();
	}
	public int get_row()
	{
		return (row);
	}
	public int get_col()
	{
		return (col);
	}
	public void set_row(int row)
	{
		this.row = row;
	}
	public void set_col(int col)
	{
		this.col = col;
	}
	public boolean equals(Cord cmp)
	{
		if(row == cmp.get_row() && col == cmp.get_col())
			return true;
		return false;
	}
}
