import java.io.IOException;

class Trade {
    TradeType type;
    double price;

    Trade(TradeType type, double price) {
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
        public TradeType createTrade(double price) {
            this.price = price;
            return this;
        }
    }, BOND {
        @Override
        public TradeType createTrade(double price) {
            this.price = price;
            return this;
        }
    }, COMMODITY_SPOT {
        @Override
        public TradeType createTrade(double price) {
            this.price = price;
            return this;
        }
    }, IR_SWAP {
        @Override
        public TradeType createTrade(double price) {
            this.price = price;
            return this;
        }
    };

    public abstract TradeType createTrade(double price);

    @Override
    public String toString() {
        return "TradeType{" +
                "this.name=" + this.name() +
                ", price=" + price +
                '}';
    }

    double price;
}


public class ParseTradeVar2 {
    static void createTrade(String fname) throws IOException {
        ReadTradeInfo info = ReadTradeInfo.readTrade(fname);
        TradeType tr = TradeType.valueOf(info.type).createTrade(info.price);
        //Trade tr = new Trade(TradeType.valueOf(info.type), info.price);
        System.out.println(tr.toString());
    }
}
