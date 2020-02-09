package paystation.domain;

public class LinearRate implements RateStrategy {

    @Override
    public int calculateTime(int moneyInserted) {
    
    int time = (moneyInserted * 2) / 5;
    return time;
    
}
   
    
    
}
