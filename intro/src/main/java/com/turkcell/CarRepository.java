package com.turkcell;

public interface CarRepository {

    //sistem araba veritabanı olarak çalışmak isteyen her nesne bu interface i implement etmek zorunda.
    public interface CarRepository{
        void add(Car car);
    }
}
