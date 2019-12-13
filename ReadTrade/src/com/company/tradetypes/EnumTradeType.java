package com.company.tradetypes;

import com.company.Trade;

public enum EnumTradeType {
    FX_SPOT {
        @Override
        public Trade createTrade(double price) {
            return new FxSpot(price);
        }
    }, BOND {
        @Override
        public Trade createTrade(double price) {
            return new Bond(price);
        }
    }, COMMODITY_SPOT {
        @Override
        public Trade createTrade(double price) {
            return new CommoditySpot(price);
        }
    }, IR_SWAP {
        @Override
        public Trade createTrade(double price) {
            return new IrSwap(price);
        }
    };

    public abstract Trade createTrade(double price);
}
