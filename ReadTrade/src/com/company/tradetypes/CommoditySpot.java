package com.company.tradetypes;

import com.company.Trade;

public class CommoditySpot extends Trade {

    public CommoditySpot(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "com.company.tradetypes.COMMODITY_SPOT " + super.toString();
    }
}

