package big26.command;

//import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import big26.ConsoleHelper;
import big26.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Елена on 01.03.16.
 */
class ExitCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("big26.resources.exit_en");

    public void execute() throws InterruptOperationException {
//        ConsoleHelper.writeMessage("Are you sure want to quit? (y, n):");
//        String answer;
//
//        answer = ConsoleHelper.readString();
//        if ("y".equalsIgnoreCase(answer.trim()))
//        {
//            ConsoleHelper.writeMessage("Bye");
//        }
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String answer = ConsoleHelper.readString();
        //if(answer.equalsIgnoreCase("y")){
        if (res.getString("yes").equals(answer)){
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}
