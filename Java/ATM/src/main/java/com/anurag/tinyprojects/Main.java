package com.anurag.tinyprojects;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO: Write Tests
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------===========================================================================================-----------------------");
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\tWelcome to India's No 1 ATM!\n");

        String name, phoneNo, gender;
        int age = 0;
        String pin = "1234";

        System.out.print("\tWhat's your name?\n\t>>> ");
        name = input.nextLine();
        if (!isValidName(name)) {
            System.out.print("\n\tInvalid Name!\n");
            return;
        }

        System.out.print("\n\tWhat's your Contact no?\n\t>>> ");
        phoneNo = input.next();
        if (!isValidPhoneNo(phoneNo)) {
            System.out.print("\n\tInvalid Phone no!\n");
            return;
        }

        System.out.print("\n\tWhat's your Gender? (Male/Female)\n\t>>> ");
        gender = input.next();
        if (!isValidGender(gender)) {
            System.out.print("\n\tInvalid Gender!\n");
            return;
        }

        try {
            System.out.print("\n\tWhat's your Age?\n\t>>> ");
            age = input.nextInt();

            if (age < 16 || age > 90) {
                System.out.println("\n\tYou're not eligible!");
                return;
            }

            System.out.print("\n\tPlease create your PIN\n\tPIN: ");
            pin = input.next();
            if (!isValidPIN(pin)) {
                System.out.println("\n\tPIN must contain digits (0-9)\n\tIt must be 4-8 characters long!");
                return;
            }

        } catch (InputMismatchException e) {
            System.out.println("\tInvalid details!\n\tPlease try again!");
            return;
        }

        ATM usr = new ATM(name, phoneNo, gender, age, pin);
        System.out.println("\n\tYour account has been created successfully!\n");
        System.out.println("-----------------------===========================================================================================-----------------------\n");

        String choice;
        System.out.print("\tWould you like to continue? (Y/N)\n\t>>> ");
        choice = input.next().toUpperCase();
//
//        if (choice.equalsIgnoreCase("N")) {
//            System.out.println("\n\tThanks " + usr.getUsrName() + "! Have a great day.");
//        }

        do {
            if (!(choice.equalsIgnoreCase("Y"))) {
                System.out.println("\n\tThanks " + usr.getUsrName() + "! Have a great day.");
                break;
            }

            System.out.print("\tPlease re-enter your PIN for transactions\n\t>>> ");
            pin = input.next();

            if (usr.authenticatePIN(pin)) {
                usr.selectTransaction(pin);
                System.out.print("\n\tWould you like to continue? (Y/N)\n\t>>>");
                choice = input.next().toUpperCase();
            } else {
                System.out.println("\n\tIncorrect PIN! " + pin);
                return;
            }
//            if (choice.equals("N")) {
//                System.out.println("\n\tThanks " + usr.getUsrName() + "! Have a great day.");
//            }
        } while ((choice.equalsIgnoreCase("Y")));
        input.close();
    }

    //    TODO: Implement all in the card class and verify from their
    public static boolean isValidPIN(String PIN) {
        if (PIN == null || PIN.isBlank() || PIN.length() < 4 || PIN.length() > 8) {
            return false;
        }
        // Just checking Pin is numeric or not
        for (int i = 0; i < PIN.length(); i++) {
            if (!(PIN.charAt(i) >= '0' && PIN.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidName(String name) {
        if (name == null || name.isBlank() || name.length() > 60 || name.length() < 2) return false;
        for (int i = 0; i < name.length(); i++) {
            if (!(name.charAt(i) >= 'A' || name.charAt(i) <= 'Z' || name.charAt(i) >= 'a' || name.charAt(i) <= 'z'))
                return false;
        }
        return true;
    }

    public static boolean isValidPhoneNo(String phoneNo) {
        if (phoneNo == null || phoneNo.isBlank()) return false;
        for (int i = 0; i < phoneNo.length(); i++) {
            if ((phoneNo.startsWith("0")) || phoneNo.length() < 10 || phoneNo.length() > 12) {
                return false;
            } else if (!(phoneNo.charAt(i) >= '0' && phoneNo.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidGender(String gender) {
        if (gender == null || gender.isBlank()) return false;
        for (int i = 0; i < gender.length(); i++) {
            if (!(gender.toUpperCase().startsWith("MALE") || gender.toUpperCase().startsWith("FEMALE"))) return false;
        }
        return true;
    }
}
