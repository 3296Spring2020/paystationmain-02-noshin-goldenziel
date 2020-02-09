/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sarah
 */
package paystation.domain;

public class LinearRate implements RateStrategy {

    @Override
    public int calculateTime(int moneyInserted) {
    
    int time = (moneyInserted * 2) / 5;
    return time;
    
}
   
    
    
}
