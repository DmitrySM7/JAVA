package ru.sberbank;

public class COMMODITY_SPOT {
    private int price;

    public COMMODITY_SPOT (int price) {
        this.price = price;
    }
    public void start() {
        System.out.println(price);
    }
}
