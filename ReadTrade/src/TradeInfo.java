import java.io.BufferedReader;
import java.io.IOException;

public class TradeInfo {
    String type;
    double price;

    public TradeInfo(String type, double price) {
        this.type = type;
        this.price = price;
    }

    static TradeInfo readTrade(BufferedReader stream) throws IOException {
        String type = "FX_SPOT";
        String price = "0.0";
        try {
            String line = stream.readLine();

            line = stream.readLine();
            int firstBracket = line.indexOf("{");
            int lastBracket = line.indexOf("}");
            type = line.substring(firstBracket + 1, lastBracket);

            line = stream.readLine();
            firstBracket = line.indexOf("{");
            lastBracket = line.indexOf("}");
            price = line.substring(firstBracket + 1, lastBracket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stream.close();
        }
        return new TradeInfo(type, Double.parseDouble(price));
    }
}
