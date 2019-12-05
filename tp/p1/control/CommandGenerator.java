package tp.p1.control;

public class CommandGenerator
{
    private static Command[] availableCommands = {
        new ListCommand(),
        new ListPrintersCommand(),
        new HelpCommand(),
        new ResetCommand(),
        new ExitCommand(),
        new MoveCommand(),
        new ShockwaveCommand(),
        new ShootCommand(),
        new ComprarCommand(),
        new StringifyCommand(),
        new NoneCommand()
    };

    public static Command parseCommand(String[] commandWords) throws CommandParseException
    {
        int i;
        boolean flag;
        Command returned;

        flag = true;
        i = 0;
        returned = null;
        while(i < availableCommands.length && flag)
        {
            if((returned = availableCommands[i].parse(commandWords)) != null)
                flag = false;
            i++;
        }
        if(flag)
        	throw new CommandParseException("COMANDO INVALIDO");
        return (returned);
    }
    
    public static String commandHelp()
    {
    	int i;
    	String buffer;
    	
    	buffer = new String("");
    	i = 0;
    	while(i < availableCommands.length)
        {
           buffer += availableCommands[i].helpText();
           i++;
        }
    	return (buffer);
    }
}