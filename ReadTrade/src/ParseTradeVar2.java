import java.io.IOException;

class Trade{
    TradeType type;
    double price;

    public Trade(TradeType type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }
}

enum TradeType {
    FX_SPOT {
        @Override
        public Trade createTrade(double price) {
            return new Trade(this, price);
        }
    }, BOND {
        @Override
        public Trade createTrade(double price) {
            return new Trade(this, price);
        }
    }, COMMODITY_SPOT {
        @Override
        public Trade createTrade(double price) {
            return new Trade(this, price);
        }
    }, IR_SWAP {
        @Override
        public Trade createTrade(double price) {
            return new Trade(this, price);
        }
    };
    public abstract Trade createTrade(double price);
}


public class ParseTradeVar2 {
    static void createTrade(String fname) throws IOException {
        ReadTradeInfo info = ReadTradeInfo.readTrade(fname);
        Trade tr = new Trade(TradeType.valueOf(info.type), info.price);
        System.out.println(tr.toString());
    }
}
