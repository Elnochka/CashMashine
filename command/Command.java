package big26.command;

import big26.exception.InterruptOperationException;

/**
 * Created by Елена on 01.03.16.
 */
//import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

interface Command
{
    public void execute() throws InterruptOperationException;
}
