package com.anurag.tinyprojects;

public class User extends Account {
    private String usrName;
    private String phoneNo;
    private String gender;
    private int age;


    public User(String usrName, String phoneNo, String gender, int age, String PIN) {
        super(PIN);
        this.usrName = usrName;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.age = age;
    }

    public String getUsrName() {
        return usrName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void getAccInfo() {
        System.out.println("--------------------------==========================================--------------------------");
        System.out.println();
        System.out.println("Account Holder's name:      " + getUsrName());
        System.out.println("Your contact no is:         " + getPhoneNo());
        System.out.println("Your age is:                " + getAge());
        System.out.println("Your gender is:             " + getGender());
        System.out.println("Your available balance is:  $" + getCrrBal());
        System.out.println();
        System.out.println("--------------------------==========================================--------------------------");
    }


}
