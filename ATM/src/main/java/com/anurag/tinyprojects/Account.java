package com.anurag.tinyprojects;

public class Account extends Card {
    private int crrBal; // Current Balance user have

    public Account(String PIN) {
        super(PIN);
    }
//    private int accBal=3422191;

    public int getCrrBal() {
        return crrBal;
    }

    public void deposit(int amount, String PIN) {
        if (authenticatePIN(PIN)) {
            if (amount < 0) {
                System.out.println("\tInvalid Amount! " + amount);
                return;
            }
            System.out.println("\tTransaction Successful!");
            this.crrBal += amount;
        } else {
            System.out.println("\tIncorrect PIN!");
        }
    }

    public void withdraw(int amount, String PIN) {
        if (authenticatePIN(PIN)) {
            if (amount < 0) {
                System.out.println("\tInvalid Amount! " + amount);
                return;
            } else if (amount > this.crrBal) {
                System.out.println("\tNot enough balance available!");
                return;
            }
            System.out.println("\tTransaction Successful!");
            this.crrBal -= amount;
        } else {
            System.out.println("\tIncorrect PIN!");
        }
    }

}
