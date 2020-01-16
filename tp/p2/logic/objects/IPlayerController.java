package tp.p2.logic.objects;

import tp.p2.logic.CommandExecuteException;

public interface IPlayerController {
	
	public boolean move (int numCells) throws CommandExecuteException;
	public boolean shootMissile() throws CommandExecuteException;
	public boolean shockWave() throws CommandExecuteException;
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}
