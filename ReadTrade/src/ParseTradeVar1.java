import java.io.IOException;


public class ParseTradeVar1 {

    static void createTrade(TradeInfo info) throws IOException, IllegalStateException {
        switch (info.type) {
            case ("FX_SPOT"):
                FX_SPOT trade1 = new FX_SPOT(info.price);
                System.out.println(trade1);
                break;
            case ("BOND"):
                BOND trade2 = new BOND(info.price);
                System.out.println(trade2);
                break;
            case ("COMMODITY_SPOT"):
                COMMODITY_SPOT trade3 = new COMMODITY_SPOT(info.price);
                System.out.println(trade3);
                break;
            case ("IR_SWAP"):
                IR_SWAP trade4 = new IR_SWAP(info.price);
                System.out.println(trade4);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + info.type);
        }
    }
}
