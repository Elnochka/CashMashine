package big26.command;

//import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
//import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import big26.ConsoleHelper;
import big26.CurrencyManipulator;
import big26.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;


/**
 * Created by Елена on 01.03.16.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("big26.resources.info_en");

    public void execute() {
        Collection<CurrencyManipulator> collectionList= CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (collectionList.isEmpty())
            ConsoleHelper.writeMessage(res.getString("before"));
//        for (CurrencyManipulator cm : collectionList) {
//            int totAmount = cm.getTotalAmount();
//            String line = cm.getCurrencyCode() + " - " + totAmount;
//            System.out.println(line);
        else
        {
            int count=0;
            for (CurrencyManipulator manipulator : collectionList)
            {
                if (manipulator.hasMoney() && manipulator.getTotalAmount() > 0)
                {
                    ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                    count++;
                }
            }
            if (count==0)
                ConsoleHelper.writeMessage(res.getString("no.money"));

        }
    }
}
