package com.turkcell;

public class Main {
    public static void main(String[] args) {
        BankRepository repo = new BankRepository();

        //hesap oluşturma
        BankAccount account1= new BankAccount("001","Kevser",100000);
        
        //listeye ekleme
        repo.addAccount(account1);


        repo.deposit("001",200 );
        repo.withdraw("001",500 );
        repo.displayAccountInfo("001");




    }
}