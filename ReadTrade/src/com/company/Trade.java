package com.company;

public class Trade {
    protected double price;

    public Trade(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "price=" + price +
                '}';
    }
}

