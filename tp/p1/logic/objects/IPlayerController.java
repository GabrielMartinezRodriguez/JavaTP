package tp.p1.logic.objects;

public interface IPlayerController {
	
	public boolean move (int numCells);
	public boolean shootMissile();
	public boolean shockWave();
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}
