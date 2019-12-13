package com.company.parsetrade;

import com.company.TradeInfo;
import com.company.tradetypes.Bond;
import com.company.tradetypes.CommoditySpot;
import com.company.tradetypes.FxSpot;
import com.company.tradetypes.IrSwap;


public class ParseTradeVar1 {
    public static void createTrade(TradeInfo info) throws IllegalStateException {
        switch (info.getType()) {
            case ("FX_SPOT"):
                FxSpot trade1 = new FxSpot(info.getPrice());
                System.out.println(trade1);
                break;
            case ("BOND"):
                Bond trade2 = new Bond(info.getPrice());
                System.out.println(trade2);
                break;
            case ("COMMODITY_SPOT"):
                CommoditySpot trade3 = new CommoditySpot(info.getPrice());
                System.out.println(trade3);
                break;
            case ("IR_SWAP"):
                IrSwap trade4 = new IrSwap(info.getPrice());
                System.out.println(trade4);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + info.getType());
        }
    }
}
