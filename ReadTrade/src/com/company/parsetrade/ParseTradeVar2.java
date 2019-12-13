package com.company.parsetrade;

import com.company.Trade;
import com.company.TradeInfo;
import com.company.tradetypes.EnumTradeType;

import java.io.IOException;


public class ParseTradeVar2 {
    public static void createTrade(TradeInfo info) throws IOException {
        Trade tr = EnumTradeType.valueOf(info.getType()).createTrade(info.getPrice());
        System.out.println(tr.toString());
    }
}
