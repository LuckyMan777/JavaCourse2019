import java.io.IOException;

enum TradeType {
    FX_SPOT {
        @Override
        public Trade createTrade(double price) {
            return new FX_SPOT(price);
        }
    }, BOND {
        @Override
        public Trade createTrade(double price) {
            return new BOND(price);
        }
    }, COMMODITY_SPOT {
        @Override
        public Trade createTrade(double price) {
            return new COMMODITY_SPOT(price);
        }
    }, IR_SWAP {
        @Override
        public Trade createTrade(double price) {
            return new IR_SWAP(price);
        }
    };

    public abstract Trade createTrade(double price);
}


public class ParseTradeVar2 {
    static void createTrade(TradeInfo info) throws IOException {
        Trade tr = TradeType.valueOf(info.type).createTrade(info.price);
        //Trade tr = new Trade(TradeType.valueOf(info.type), info.price);
        System.out.println(tr.toString());
    }
}
