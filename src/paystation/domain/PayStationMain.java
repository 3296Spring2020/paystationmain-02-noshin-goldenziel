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
            //each method corresponds to the option number, if the options isn't 1-5 then it does not do anything
            switch (option) {
                case 1:
                    //Deposit coins
                    while (true) {
                        // Program throws IllegalCoinException when a coin other than 5, 10, or 25 is entered
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
                    } else { // No money desposited
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

                            if (coinMap.containsKey(1)) { // Count number of nickels
                                sum += 5 * (int) coinMap.get(1);
                            }
                            if (coinMap.containsKey(2)) { // Count number of dimes
                                sum += 10 * (int) coinMap.get(2);
                            }
                            if (coinMap.containsKey(3)) { // Count number of quarters
                                sum += 25 * (int) coinMap.get(3);
                            }

                            System.out.println("\nPurchase cancelled. Returning " + sum + "¢\n");

                            if (coinMap.containsKey(1)) { // Return number of nickels
                                System.out.println(coinMap.get(1) + " nickel(s)");
                            }
                            if (coinMap.containsKey(2)) { // Return number of dimes
                                System.out.println(coinMap.get(2) + " dime(s)");
                            }
                            if (coinMap.containsKey(3)) { // Return number of quarters
                                System.out.println(coinMap.get(3) + " quarter(s)");
                            }
                        }
                    } else { // No money deposited
                        System.out.println("\nYou have not purchased any parking time. There is nothing to cancel.");
                    }
                    break;
                case 5:
                    //Change Rate Strategy
                    if (ps.readDisplay() == 0) {
                        System.out.println("\nSelect a rate strategy:\n1. Linear Rate\n2. Progressive Rate\n3. Alternating Rate");
                        option = scan.nextInt();
                        if (option > 0 && option < 4) { // option is 1, 2, or 3
                            ps.changeRate(option); // Change rate strategy to match the option value
                            if (option == 1) {
                                System.out.println("\nYou successfully changed to Linear Rate");
                            } else if (option == 2) {
                                System.out.println("\nYou successfully changed to Progressive Rate");
                            } else { // option is 3
                                System.out.println("\nYou successfully changed to Alternating Rate");
                            }
                        } else { // option is not 1, 2, or 3
                            System.out.println("\nNot a valid option");
                        }
                    } else { // Don't allow rate strategy to change while there is money in the machine
                        System.out.println("\nYou are currently in the middle of a purchase. Please complete or cancel your purchase before changing the rate.");
                    }

                    break;
                default:
                    // option is not between 1-5
                    System.out.println("\nNot a valid option.");

            }
        }
    }
}
