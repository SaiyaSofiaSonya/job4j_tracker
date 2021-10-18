package ru.job4j.poly;

public class Bus implements Transport{

    @Override
    public void go() {
      System.out.println("Go");
    }

    @Override
    public void passengers(int number) {
       System.out.println("Number of passenger is " + number);
    }

    @Override
    public int refuel(int quantity) {
        int price = quantity*50;
        return price;
    }
}
