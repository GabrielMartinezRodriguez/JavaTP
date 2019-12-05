package tp.p1.logic;

import java.util.Random;

import tp.p1.logic.lists.GameObjectBoard;
import tp.p1.logic.objects.AlienShip;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.IPlayerController;
import tp.p1.logic.objects.SuperMisil;
import tp.p1.logic.objects.UCMShip;
import tp.p1.util.Cord;

public class Game implements IPlayerController {

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;

	private int currentCycle;
	private Random rand;
	private Level level;
	private GamePrinter print;

	private boolean change;
	GameObjectBoard board;

	private UCMShip player;

	private int points;
	private boolean doExit;
	private BoardInitializer initializer;

	public Game (Level level, Random random){
		this. rand = random;
		this.level = level;
		doExit = false;
		initializer = new BoardInitializer();
		initGame();
	}

	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize (this, level);
		player = new UCMShip(this, new Cord(DIM_Y - 1, DIM_X / 2));
		board.add(player);
	}
	
	public String toString()
	{
		
		if( print == null || change || print.getClass() != Stringifier.class)
		{
			print = new BoardPrinter(this, DIM_Y, DIM_X);
			change = false;
			return infoToString() + print.toString();
		}
		else
			change = true;
		return (print.toString());
		
	}
	
	public Random getRandom() {
		return rand;
	}

	public Level getLevel() {
		return level;
	}

	public void reset() {
		initGame();
	}

	public void addObject(GameObject object) {
		board.add(object);
	}

	public String positionToString(Cord cord) {
		return board.toString(cord);
	}
	public String toStringObjectAt(int i, int j)
	{
		Cord cord = new Cord(i, j);
		return(positionToString(cord));
	}
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}

	public boolean aliensWin() {
		return !player.isAlive() || AlienShip.haveLanded(this);
	}

	private boolean playerWin() {
		return AlienShip.allDead(this);
	}
	public GameObjectBoard getBoard(){
		return (board);
	}
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}

	public boolean isOnBoard(Cord cord) {
		return (board.isInBoard(cord));
	}

	public void exit() {
		System.out.println("GAME OVER\n");
		System.exit(0);
	}

	public String infoToString() {
		String info = new String("");

		info += "Life: " + player.getLive() + "\n";
		info += "Number of cycles: " + currentCycle + "\n";
		info += "Points: " + points + "\n";
		info += "Remaining aliens: " + board.countAliens() + "\n";
		info += "Shockwave ";
		if(player.getShockWave())
			info += "Si";
		else
			info += "NO";
		info += "\nSuperMisiles: " + player.getnSuperMisil();
		info += "\n\n\n";
		return (info);
	}

	public String getWinnerMessage() {
		if (playerWin())
			return "Player win!";
		else if (aliensWin())
			return "Aliens win!";
		else if (doExit)
			return "Player exits the game";
		else
			return "This should not happen";
	}
	
	@Override
	public boolean move(int numCells) throws CommandExecuteException {
		if(player.getCord().get_col() + numCells >= 0 
			&& player.getCord().get_col() + numCells < Game.DIM_X)
		{
			player.getCord().set_col(player.getCord().get_col() + numCells);
			return true;
		}
		throw new CommandExecuteException("NO PUEDES TRASPASAR PAREDES :(");
		
	}
	public void list()
	{
		System.out.println(
				"[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\r\n" + 
				"[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1\r\n" + 
				"[O]vni: Points: 25 - Harm: 0 - Shield: 1\r\n" + 
				"^__^: Harm: 1 - Shield: 3");
	}

	@Override
	public boolean shootMissile() throws CommandExecuteException {
		return (player.shoot());
		
	}

	@Override
	public boolean shockWave() throws CommandExecuteException {
		player.shockWave();
		return false;
	}

	@Override
	public void receivePoints(int points) {
		// TODO Auto-generated method stub
	}

	@Override
	public void enableShockWave() {
		player.enableShockWave();
	}


	public int getCurrentCycle() {
		return currentCycle;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public void enableMissile() {
		// TODO Auto-generated method stub
		
	}

	public void explosive(Cord cord) {
		board.explosive(cord);
		
	}

	public void setPrint(GamePrinter print) {
		this.print = print;
	}
	public String levelAsString()
	{
		if(level == Level.EASY)
			return ("easy");
		if(level == Level.HARD)
			return ("hard");
		if(level == Level.INSANE)
			return ("insane");
		return ("");
	}

	public void buySuperMisile() {
		points -= SuperMisil.getCoste();
		player.addSuper();
		
	}
	public void shootSuperMissile() throws CommandExecuteException
	{
		player.superMisil();
	}

	
}
