/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

public class ProgressiveRate implements RateStrategy {

    @Override
    public int calculateTime(int moneyInserted) {
        int time=0;
        /* greater than 2 hours so amount >= 350 */
        if (moneyInserted >= 350){ 
        moneyInserted -=350;
        time= 120 + moneyInserted/5;
        /* between 1st hour and 2nd hour so 350>amount >=150 */
        } else if (moneyInserted >= 150) {
            moneyInserted -= 150;
            time = 60 + moneyInserted * 3 /10;
        /* less than an hour (60 Min) so amount <150 */
        } else {
            time = moneyInserted * 2/5 ;
        }
        
        return time;
        
 
    }

}
