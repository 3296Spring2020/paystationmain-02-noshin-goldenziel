package paystation.domain;
import java.util.*;
import java.time.DayOfWeek;

/**
 * Implementation of the pay station.
 *
 * Responsibilities:
 *
 * 1) Accept payment; 
 * 2) Calculate parking time based on payment; 
 * 3) Know earning, parking time bought; 
 * 4) Issue receipts; 
 * 5) Handle buy and cancel events.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class PayStationImpl implements PayStation {
    
    private int insertedSoFar;
    private int timeBought;
    private Map coinMap = new HashMap();
    private boolean nickleBool = false;
    private boolean dimeBool = false;
    private boolean quarterBool = false;
    
    private RateStrategy rs = new LinearRate(); // Rate Strategy defaults to linear rate
    
    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {

        switch (coinValue) {
            case 5:
                if(!nickleBool)
                {
                    coinMap.put(1, 1);
                    nickleBool = true;
                }
                else
                {
                    coinMap.put(1, (int)coinMap.get(1) + 1);
                    
                }
                break;
            case 10:
                if(!dimeBool)
                {
                    coinMap.put(2, 1);
                    dimeBool = true;
                }
                else
                {
                    coinMap.put(2, (int)coinMap.get(2) + 1);
                }
                break;
            case 25:
                if(!quarterBool)
                {
                    coinMap.put(3, 1);
                    quarterBool = true;
                }
                else
                {
                    coinMap.put(3, (int)coinMap.get(3) + 1);
                }
                break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }
        insertedSoFar += coinValue;
        timeBought = rs.calculateTime(insertedSoFar); // Time calculated depends on rate strategy
    }

    @Override
    public int readDisplay() {
        return timeBought;
    }

    @Override
    public Receipt buy() {
        Receipt r = new ReceiptImpl(timeBought);
        reset();
        return r;
    }

    @Override
    public Map<Integer, Integer> cancel() 
    {
        Map tempMap =  new HashMap();
        tempMap.putAll(coinMap);
        reset();
        return tempMap;
    }
    
    private void reset() {
        timeBought = insertedSoFar = 0;
        nickleBool = false;
        dimeBool = false;
        quarterBool = false;
        coinMap.clear();
    }
    
    @Override
    public int empty()
    {
        int total = insertedSoFar;
        insertedSoFar = 0;
        return total;
    }
    
    // Changes rate strategy depending on user input in main class
    public void changeRate(int option)
    {
        switch(option) {
            case 1:
                rs = new LinearRate();
                break;
            case 2:
                rs = new ProgressiveRate();
                break;
            case 3:
                rs = new AlternatingRate();
                break;
            default:
                
        }
    }
}
