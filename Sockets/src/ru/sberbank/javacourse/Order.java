package ru.sberbank.javacourse;

import java.io.Serializable;

public class Order implements Serializable {
    private final String name;
    private final double price;

    public Order(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
