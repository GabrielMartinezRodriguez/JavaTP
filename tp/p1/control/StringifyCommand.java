package tp.p1.control;

import tp.p1.logic.BoardPrinter;
import tp.p1.logic.CommandExecuteException;
import tp.p1.logic.Game;
import tp.p1.logic.GamePrinter;
import tp.p1.logic.Stringifier;

public class StringifyCommand extends Command {

	public StringifyCommand() {
		super("StringifyCommand", "str", "Stringify", "Show the board as a string");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		GamePrinter str = new Stringifier();
		str.setGame(game);
		System.out.print(game);
		str = new BoardPrinter();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if((commandWords[0].contentEquals("str") || commandWords[0].contentEquals("stringify")) &&
				commandWords.length == 1)
			return(new StringifyCommand());
		return null;
	}

}