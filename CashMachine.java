package big26;

/**
 * Created by Елена on 25.02.16.
 */

//import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
//import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import big26.command.CommandExecutor;
import big26.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine
{
    public static final String RESOURCE_PATH = "big26.resources";
    public static void main (String[] args){
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        try
        {
            CommandExecutor.execute(Operation.LOGIN);
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (!operation.equals(Operation.EXIT));
        }
        catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("Bye");

        }

    }


}
