package com.company.tradetypes;

import com.company.Trade;

public class FxSpot extends Trade {

    public FxSpot(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "com.company.FX_SPOT " + super.toString();
    }
}
