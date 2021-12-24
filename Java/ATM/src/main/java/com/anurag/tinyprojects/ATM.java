package com.anurag.tinyprojects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM extends User {
    Scanner input = new Scanner(System.in);
    private final String[] options = {
            "Deposit Funds",
            "Withdraw Funds",
            "Check Balance",
            "Account Info"
//            "Exit"
    };

    public ATM(String usrName, String phoneNo, String gender, int age, String PIN) {
        super(usrName, phoneNo, gender, age, PIN);
    }

    public String[] getOptions() {
        return options;
    }

    public void selectTransaction(String pin) {
//        System.out.print("\tPlease re-enter your PIN for transactions\n\t>>> ");

//        String pin = input.next();
        System.out.println("\n\tWhat would you like to do?\n");

        String[] options = getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println("\t" + (i + 1) + ") " + options[i]);
        }
        System.out.print("\t>>> ");

        // TODO: Check it byte or int
        int transaction = input.nextByte();

        switch (transaction) {
            case 1 -> {
                System.out.print("\tEnter amount\n\t>>> ");
                int amount;
                try {
                    amount = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\tInvalid Amount!");
                    return;
                }
                deposit(amount, pin);
            }
            case 2 -> {
                System.out.print("\tEnter amount\n\t>>> ");
                int amount;
                try {
                    amount = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\tInvalid Amount!");
                    return;
                }
                withdraw(amount, pin);
            }
            case 3 -> System.out.println("\n\tYour current balance is: $" + getCrrBal());
            case 4 -> getAccInfo();

            default -> System.out.println("\n\tInvalid Option!");
        }
    }
}
