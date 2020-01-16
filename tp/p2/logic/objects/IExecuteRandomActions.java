package tp.p2.logic.objects;

import tp.p2.logic.Game;

public interface IExecuteRandomActions {
	
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
	}
	static boolean canGenerateExplosiveShip(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getExplosiveShipFrequency();
	}
}