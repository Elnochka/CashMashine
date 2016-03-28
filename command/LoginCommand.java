package big26.command;

//import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import big26.ConsoleHelper;
import big26.exception.InterruptOperationException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Елена on 06.03.16.
 */
public class LoginCommand implements Command
{
   // private static final String cardNumber = "123456789012";
   // private static final String cardPin = "1234";
   private ResourceBundle res = ResourceBundle.getBundle("big26.resources.login_en");

    private ResourceBundle validCreditCards = ResourceBundle.getBundle("big26.resources.verifiedCards");;
    public void execute() throws InterruptOperationException
    {

        Matcher m1;
        Matcher m2;
        String cardNumberToCheck;
        boolean login = false;
        do {
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));

            cardNumberToCheck = ConsoleHelper.readString();
            String cardPinToCheck = ConsoleHelper.readString();
            Pattern p1 = Pattern.compile("^\\d{12}$");
            m1 = p1.matcher(cardNumberToCheck);
            Pattern p2 = Pattern.compile("^\\d{4}$");
            m2 = p2.matcher(cardPinToCheck);
            if (!m1.matches() || !m2.matches()) {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
            try {
                login = validCreditCards.getString(cardNumberToCheck).equals(cardPinToCheck);

            } catch (MissingResourceException e) {}
            if (!login) {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumberToCheck));
                continue;
            }
        } while (!login);
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumberToCheck));
//        while (true){
//            ConsoleHelper.writeMessage("Enter card number (12 numbers) and pin (4 numbers)");
//            String userCreditCardNumber = ConsoleHelper.readString();
//            if (userCreditCardNumber == null || userCreditCardNumber.length() != 12){
//                ConsoleHelper.writeMessage("Wrong car number or pin");
//                continue;
//            }
//            String userPin = ConsoleHelper.readString();
//            if (userPin == null || userPin.length() != 4){
//                ConsoleHelper.writeMessage("Wrong car number or pin");
//                continue;
//            }
//            if (userCreditCardNumber.equals(cardNumber) && userPin.equals(cardPin)){
//                ConsoleHelper.writeMessage("Access granted");
//                break;
//            }
//            try {
//                login = validCreditCards.getString(cardNumberToCheck).equals(cardPinToCheck);
//
//            } catch (MissingResourceException e) {}
//            ConsoleHelper.writeMessage("Wrong pair: credit card number - pin");
//        }
    }
}
