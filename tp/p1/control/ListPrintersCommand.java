package tp.p1.control;

import tp.p1.logic.CommandExecuteException;
import tp.p1.logic.Game;
import tp.p1.logic.PrinterTypes;

public class ListPrintersCommand extends Command {

	public ListPrintersCommand() {
		super("ListPrinters", "lp", "ListPrinter", "Show print options");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		
		System.out.println(PrinterTypes.printerHelp(game));
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if((commandWords[0].contentEquals("listPrinters") || commandWords[0].contentEquals("lp")) &&
				commandWords.length == 1)
			return(new ListPrintersCommand());
		return null;
	}

}
