package com.anurag.tinyprojects;

public class Card {
    private String PIN;

    public Card(String PIN) {
        this.PIN = PIN;
    }

    public String getPIN() {
        return PIN;
    }


//    public boolean isValidPIN(String PIN) {
//        if (PIN == null || PIN.isBlank() || PIN.length() < 4 || PIN.length() > 8) {
//            System.out.println("Invalid PIN! " + this.PIN);
//            return false;
//        }
//        // Just checking Pin is numeric or not
//        for (int i = 0; i < PIN.length(); i++) {
//            if (!(PIN.charAt(i) >= '0' && PIN.charAt(i) <= '9')) {
//                System.out.println("PIN must contain digits (0-9)");
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean authenticatePIN(String PIN) {
        return PIN.equals(getPIN());
    }
}
