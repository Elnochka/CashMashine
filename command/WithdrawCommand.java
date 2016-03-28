package big26.command;

/**
 * Created by Елена on 01.03.16.
 */

//import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
//import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
//import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
//import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import big26.ConsoleHelper;
import big26.CurrencyManipulator;
import big26.CurrencyManipulatorFactory;
import big26.exception.InterruptOperationException;
import big26.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand  implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("big26.resources.withdraw_en");
    public void execute() throws InterruptOperationException {
        String curCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode);
        int amount;
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));

            String s = ConsoleHelper.readString();
            if (s.matches("\\d+")) {
                amount = Integer.parseInt(s);

                //----------------------------------------------
                if (manipulator.isAmountAvailable(amount)) {
                    try {
                        Map<Integer, Integer> result = manipulator.withdrawAmount(amount);

                        for (Map.Entry<Integer, Integer> entry : result.entrySet())
                        //    ConsoleHelper.writeMessage("\t" + entry.getKey() + " " + entry.getValue());
                     //   ConsoleHelper.writeMessage(String.format("\t%d - %d", entry.getKey(), entry.getValue()));
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), entry.getKey(), entry.getValue()));
                        // ConsoleHelper.writeMessage(res.getString(""));
                        break;
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    }
                } else {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                }
            } else
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
        }
    }

}
//    public void execute() throws InterruptOperationException {
//        String curCode = ConsoleHelper.askCurrencyCode();
//        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode);
//        int amount;
//        while (true)
//        {
//            ConsoleHelper.writeMessage("Enter sum");
//            String s = ConsoleHelper.readString();
//            if (s.matches("\\d+"))
//            {
//                amount = Integer.parseInt(s);
//
//                //----------------------------------------------
//                if (manipulator.isAmountAvailable(amount))
//                {
//                    try
//                    {
//                        Map<Integer, Integer> result = manipulator.withdrawAmount(amount);
//
//                        for (Map.Entry<Integer, Integer> entry : result.entrySet())
//                            ConsoleHelper.writeMessage("\t" + entry.getKey() + " " + entry.getValue());
//                        ConsoleHelper.writeMessage("Transaction has completed successfully");
//                        break;
//                    }
//                    catch (NotEnoughMoneyException e)
//                    {
//                        ConsoleHelper.writeMessage("There is not enough denominations");
//                    }
//                } else
//                {
//                    ConsoleHelper.writeMessage("There is not enough money");
//                }
//            } else
//                ConsoleHelper.writeMessage("Your sum is invalid. Please, enter correct sum");
//        }
//    }
//}




