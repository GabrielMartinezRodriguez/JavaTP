package tp.p1.control;

public class CommandGenerator
{
    private static Command[] availableCommands = {
        new ListCommand(),
        new HelpCommand(),
        new ResetCommand(),
        new ExitCommand(),
        new MoveCommand(),
        new ShockwaveCommand()
    };

    public static Command parseCommand(String[] commandWords)
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