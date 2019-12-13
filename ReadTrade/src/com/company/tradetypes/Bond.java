package com.company.tradetypes;

import com.company.Trade;

public class Bond extends Trade {

    public Bond(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "com.company.BOND " + super.toString();
    }
}
