package com.turkcell;

public class BankAccount {

    private String accountNum;
    private String name;
    private double balance;

    public BankAccount(String accountNum, String name, double balance){
        this.accountNum = accountNum;
        this.name = name;
        this.balance = balance;

    }
    
    public String getAccountNum (){
        return accountNum;
    }
    public void setAccountNum(String accountNum){
        this.accountNum=accountNum;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

}
