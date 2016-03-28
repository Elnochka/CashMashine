package big26.command;


//import com.javarush.test.level26.lesson15.big01.Operation;
//import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import big26.Operation;
import big26.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Елена on 01.03.16.
 */
public class CommandExecutor
{
    private CommandExecutor()
    {

    }
    private static Map<Operation, Command> map;
    static {
        map = new HashMap<Operation, Command>();
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.EXIT, new ExitCommand());
        map.put(Operation.LOGIN, new LoginCommand());
    }
    public static final void execute(Operation operation) throws InterruptOperationException {
        map.get(operation).execute();
    }
}
