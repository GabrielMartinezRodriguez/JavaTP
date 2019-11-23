package tp.p1.control;

import tp.p1.logic.*;
import java.util.*;

public class CommandGenerator
{
    private static Command[] availableCommands = {
        new ListCommand(),
        new HelpCommand(),
        new ResetCommand(),
        new ExitCommand(),
        new ListCommand(),
        new UpdateCommand(),
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
        while(i < availableCommands.lenght && flag)
        {
            if((returned = availableCommands[i].parse(commandWords)) != null)
                flag = false;
            i++;
        }
        return (returned);
    }
}