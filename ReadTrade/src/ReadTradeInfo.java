import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTradeInfo {
    String type;
    double price;

    public ReadTradeInfo(String type, double price) {
        this.type = type;
        this.price = price;
    }

    static ReadTradeInfo readTrade(String fname) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fname));
        String type = "FX_SPOT";
        String price = "0.0";
        try {
            String line = br.readLine();

            line = br.readLine();
            int firstBracket = line.indexOf("{");
            int lastBracket = line.indexOf("}");
            type = line.substring(firstBracket + 1, lastBracket);

            line = br.readLine();
            firstBracket = line.indexOf("{");
            lastBracket = line.indexOf("}");
            price = line.substring(firstBracket + 1, lastBracket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return new ReadTradeInfo(type, Double.parseDouble(price));
    }
}
