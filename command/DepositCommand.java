package big26.command;

//import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
//import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import big26.ConsoleHelper;
import big26.CurrencyManipulatorFactory;
import big26.exception.InterruptOperationException;

import java.util.ResourceBundle;


/**
 * Created by Елена on 01.03.16.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("big26.resources.deposit_en");

    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String curCode = ConsoleHelper.askCurrencyCode();
        String[] str = ConsoleHelper.getValidTwoDigits(curCode);

        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode).addAmount(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), (Integer.parseInt(str[0]) * Integer.parseInt(str[1])), curCode));
    }
}
