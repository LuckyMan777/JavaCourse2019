import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        TradeInfo info = TradeInfo.readTrade(br);

        System.out.println("\nUsing first parsing method: ");
        ParseTradeVar1.createTrade(info);

        System.out.println("\nUsing second parsing method: ");
        ParseTradeVar2.createTrade(info);
    }
}
