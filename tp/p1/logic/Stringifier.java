package tp.p1.logic;

public class Stringifier extends GamePrinter {

	Game game;
	
	public Stringifier() {
		
	}
	public String toString()
	{
		String str = "";
		str += "— Space Invaders v2.0 —\n\n";
		str += "G;" + game.getCurrentCycle() + "\n";
		str += "L;" + game.levelAsString() + "\n";
		str += game.getBoard().boardAsString() + "\n";
		return (str);
	}
	@Override
	public void setGame(Game game) {
		this.game = game;
		game.setPrint(this);
	}
}