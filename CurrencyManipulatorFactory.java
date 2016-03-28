package big26;

/**
 * Created by Елена on 27.02.16.
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CurrencyManipulatorFactory
{
    private static Map<String, CurrencyManipulator> manipulatorMap = new HashMap<String, CurrencyManipulator>();

    public static CurrencyManipulator  getManipulatorByCurrencyCode(String currencyCode)
    {

        if (manipulatorMap.containsKey(currencyCode)) {
            return manipulatorMap.get(currencyCode);
        } else {
            CurrencyManipulator cur = new CurrencyManipulator(currencyCode);
            manipulatorMap.put(currencyCode, cur);
            return cur;
        }

    }

    private CurrencyManipulatorFactory()
    {
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulatorMap.values();
    }




}
