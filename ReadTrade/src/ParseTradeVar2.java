import java.io.BufferedReader;
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
    static void createTrade(TradeInfo info) throws IOException {
        TradeType tr = TradeType.valueOf(info.type).createTrade(info.price);
        TradeType tr2 = TradeType.valueOf(info.type).createTrade(9888);
        //Trade tr = new Trade(TradeType.valueOf(info.type), info.price);
        System.out.println(tr.toString());
        System.out.println(tr2.toString());
    }
}
