import java.io.BufferedReader;
import java.io.IOException;

class Trade {
    protected double price;

    public Trade(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "price=" + price +
                '}';
    }
}

class FX_SPOT extends Trade {

    public FX_SPOT(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "FX_SPOT " + super.toString();
    }
}

class BOND extends Trade {

    public BOND(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "BOND " + super.toString();
    }
}

class COMMODITY_SPOT extends Trade {

    public COMMODITY_SPOT(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "COMMODITY_SPOT " + super.toString();
    }
}

class IR_SWAP extends Trade {

    public IR_SWAP(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "IR_SWAP " + super.toString();
    }
}

public class TradeInfo {
    String type;
    double price;

    public TradeInfo(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public TradeInfo(BufferedReader stream) throws IOException {
        try {
            String line = stream.readLine();

            line = stream.readLine();
            int firstBracket = line.indexOf("{");
            int lastBracket = line.indexOf("}");
            type = line.substring(firstBracket + 1, lastBracket);

            line = stream.readLine();
            firstBracket = line.indexOf("{");
            lastBracket = line.indexOf("}");
            price = Double.parseDouble(line.substring(firstBracket + 1, lastBracket));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stream.close();
        }
    }
}
