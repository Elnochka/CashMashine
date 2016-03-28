package big26;

/**
 * Created by Елена on 27.02.16.
 */
//import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import big26.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;

    }

    public String getCurrencyCode()
    {

        return currencyCode;
    }
    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }
    public int getTotalAmount()
    {
        int result=0;
        for(Map.Entry<Integer,Integer> pair : denominations.entrySet()){

            result = result + (pair.getKey() * pair.getValue());
        }
        return result;

    }
    public boolean hasMoney(){
        if (denominations.isEmpty()) return false;
        else {
            for (Map.Entry<Integer,Integer> pair : denominations.entrySet()){
                if (pair.getValue()!=0) return true;
            }
            return false;
        }
    }
    public boolean isAmountAvailable(int expectedAmount)
    {

        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(denominations);

        HashMap<Integer, Integer> resMap = new HashMap<>();


        for (Integer i : sortedMap.descendingKeySet())
        {
            int denom = i;

            if (denom <= expectedAmount)
            {
                int count = expectedAmount / denom;
                expectedAmount -= denom * count;
                resMap.put(denom, count);
                if (expectedAmount == 0)
                {
                    break;
                }
                if (expectedAmount < 0)
                    throw new  NotEnoughMoneyException();
            }
        }
        if (expectedAmount > 0)
            throw new NotEnoughMoneyException();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (resMap.containsKey(key))
            {
                if (value - resMap.get(key) != 0)
                    map.put(key, value - resMap.get(key));

//
//// if (value - resMap.getOrDefault(key, 0) != 0)
////                    map.put(key, value - resMap.getOrDefault(key, 0));
            }
            else
                map.put(key, value);

        }
        denominations = map;
        return resMap;
    }
}
//    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
//    {
//        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
//        sortedMap.putAll(denominations);
//
//        HashMap<Integer, Integer> resMap = new HashMap<>();
//
//
//        for (Integer i : sortedMap.descendingKeySet())
//        {
//            int denom = i;
//
//            if (denom <= expectedAmount)
//            {
//                int count = expectedAmount / denom;
//                expectedAmount -= denom * count;
//                resMap.put(denom, count);
//                if (expectedAmount == 0)
//                {
//                    break;
//                }
//                if (expectedAmount < 0)
//                    throw new  NotEnoughMoneyException();
//            }
//        }
//        if (expectedAmount > 0)
//            throw new NotEnoughMoneyException();
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
//        {
//            Integer key = entry.getKey();
//            Integer value = entry.getValue();
//            if (resMap.containsKey(key))
//            {
//                if (value - resMap.getOrDefault(key, 0) != 0)
//                    map.put(key, value - resMap.getOrDefault(key, 0));
//            }
//            else
//                map.put(key, value);
//        }
//        denominations = map;
//        return resMap;
//    }
//}


