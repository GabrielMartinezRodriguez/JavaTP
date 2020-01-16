package tp.p2.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import tp.p2.logic.CommandExecuteException;
import tp.p2.logic.Game;
import tp.p2.logic.Stringifier;

public class SaveCommand extends Command {

	public SaveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	public SaveCommand() {
		super("savecommand", "sv", "Save", "Save the game");
	}
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		Stringifier string = new Stringifier(game);
		FileWriter fileName;
		BufferedWriter bw;
		try
		{
			fileName = new FileWriter(name + ".dat");
			bw = new BufferedWriter(fileName);
			bw.write(string.toString());
			bw.close();
		}catch(IOException e) {
			throw new CommandExecuteException("No se ha podida almacenar el contenido en el fichero especificado");
		}
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords.length == 2 && commandWords[0].contentEquals("save"))
			return(new SaveCommand(commandWords[1], "sv", "save", "Save the game"));
		return null;
	}

}
