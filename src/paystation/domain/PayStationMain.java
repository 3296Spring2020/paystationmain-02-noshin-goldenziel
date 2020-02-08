/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author tuh00941
 */
public class PayStationMain {

    /**
     *
     * @param args
     * @throws paystation.domain.IllegalCoinException
     */
    public static void main(String[] args) throws IllegalCoinException {
        Scanner scan = new Scanner(System.in);
        PayStationImpl ps = new PayStationImpl();

        System.out.println("Welcome to PayStation!");
        while (true) {
            System.out.println("\nSelect an option:\n1. Deposit Coins\n2. Display\n3. Buy Ticket\n4. Cancel\n5. Change Rate Strategy");

            int option = scan.nextInt();
            switch (option) {
                case 1:
                    //Deposit coins
                    while (true) {
                        System.out.println("\nInsert a coin or press '0' to finish. Only nickels, dimes, and quarters are accepted. ");
                        int coinValue = scan.nextInt();
                        if (coinValue != 0) {
                            ps.addPayment(coinValue);
                        } else {
                            break;
                        }
                    }
                    break;
                case 2:
                    //Display time
                    System.out.println("\n" + ps.readDisplay() + " minute(s)");
                    break;
                case 3:
                    //Buy ticket
                    if (ps.readDisplay() > 0) {
                        System.out.println("\nYou are purchasing " + ps.readDisplay() + " minute(s) of parking time. Press '1' to confirm your purchase. ");
                        option = scan.nextInt();

                        if (option == 1) {
                            System.out.println("\nPrinting receipt...");
                            Receipt r = ps.buy();
                            System.out.println("\nThis receipt is good for " + r.value() + " minute(s)");
                        }
                    } else {
                        System.out.println("\nYou have not purchased any parking time. Please make a deposit and try again.");
                    }
                    break;
                case 4:
                    //Cancel 
                    if (ps.readDisplay() > 0) {
                        System.out.println("\nPress '1' to confirm your cancellation. ");
                        option = scan.nextInt();

                        if (option == 1) {
                            Map coinMap = ps.cancel();
                            int sum = 0;
                           
                            if(coinMap.containsKey(1)) {
                                sum += 5 * (int)coinMap.get(1);
                            }
                            if(coinMap.containsKey(2)) {
                                sum += 10 * (int)coinMap.get(2);
                            }
                            if(coinMap.containsKey(3)) {
                                sum += 25 * (int)coinMap.get(3);
                            }

                            System.out.println("\nPurchase cancelled. Returning " + sum + "¢\n");
                           
                            if(coinMap.containsKey(1)) {
                                System.out.println(coinMap.get(1) + " nickel(s)");
                            }
                            if(coinMap.containsKey(2)) {
                                System.out.println(coinMap.get(2) + " dime(s)");
                            }
                            if(coinMap.containsKey(3)) {
                                System.out.println(coinMap.get(3) + " quarter(s)");
                            }
                        }
                    } else {
                        System.out.println("\nYou have not purchased any parking time. There is nothing to cancel.");
                    }
                    break;
                case 5:
                    //Change Rate Strategy
                    System.out.println("\nYou selected: 'Change Rate Strategy'");
                    break;
                default:
                    System.out.println("\nNot a valid option.");
            }
        }

    }
}
