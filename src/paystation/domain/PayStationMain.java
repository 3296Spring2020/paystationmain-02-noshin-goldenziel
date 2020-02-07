/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

import java.util.Scanner;

/**
 *
 * @author tuh00941
 */
public class PayStationMain {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PayStationImpl ps = new PayStationImpl();

        System.out.println("Welcome to PayStation!");
        while (true) {
            System.out.println("\nSelect an option:\n1. Deposit Coins\n2. Display\n3. Buy Ticket\n4. Cancel\n5. Change Rate Strategy");

            int option = scan.nextInt();
            switch (option) {
                case 1:
                    //Deposit coins
                    System.out.println("\nYou selected: 'Deposit Coins'");
                    break;
                case 2:
                    //Display time
                    System.out.println("\nYou selected: 'Display'");
                    break;
                case 3:
                    //Buy ticket
                    System.out.println("\nYou selected: 'Buy Ticket'");
                    break;
                case 4:
                    //Cancel
                    System.out.println("\nYou selected: 'Cancel'");
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
