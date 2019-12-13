package com.company.tradetypes;

import com.company.Trade;

public class IrSwap extends Trade {

    public IrSwap(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "com.company.tradetypes.IR_SWAP " + super.toString();
    }
}

