package com.turkcell;

import java.util.ArrayList;

public class BankRepository {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    public BankAccount findAccount( String accountNum){
        for (BankAccount account :accounts){
            if (account.getAccountNum().equals(accountNum)){
                return account;
            }
        }
        return null;
    }

    //para yatırma
    public void deposit(String accountNum,double amount ){
        BankAccount account = findAccount(accountNum);
        if (account != null && amount>0){
            account.setBalance(account.getBalance()+amount);
            System.out.println("paranız yatırıldı.yeni bakiye: " + account.getBalance());
        } else {
            System.out.println("yetersiz bakiye veya hesabınız yok ");
        }
    }

    //para çekme
    public void withdraw( String accountNum,double amount){
        BankAccount account = findAccount(accountNum);

        if (account!= null && amount >0 && account.getBalance() >= amount){
            account.setBalance(account.getBalance()- amount);
            System.out.println("paraınız çekildi.yeni bakiye" + account.getBalance());
        
        } else {
            System.out.println("yetersiz bakiye veya hesabınız yok");
        }
    }

    //hesap bilgilerini gösterme
    public void displayAccountInfo(String accountNum){
        BankAccount account = findAccount(accountNum);

        if(account !=null){
            System.out.println("\n----- HESAP BİLGİLERİ-----");
            System.out.println("İsim:" + account.getName());
            System.out.println("Hesap no:" + account.getAccountNum());
            System.out.println("Bakiye:" + account.getBalance());
        
        } else {
            System.out.println("Hesabınız yok");
        }
    }



}
