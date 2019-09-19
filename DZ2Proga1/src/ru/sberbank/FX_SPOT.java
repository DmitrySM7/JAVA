package ru.sberbank;

public class FX_SPOT {
    private int price;

    public FX_SPOT (int price) {
        this.price = price;
    }
    public void start() {
        System.out.println(price);
    }
}
