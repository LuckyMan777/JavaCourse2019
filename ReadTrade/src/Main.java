import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("\nUsing first parsing method: ");
        ParseTradeVar1.createTrade(args[0]);

        System.out.println("\nUsing second parsing method: ");
        ParseTradeVar2.createTrade(args[0]);
    }
}
