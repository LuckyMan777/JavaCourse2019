package com.company;

import java.io.BufferedReader;
import java.io.IOException;


public class TradeInfo {
    String type;
    double price;

    public TradeInfo(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public TradeInfo(BufferedReader stream) throws IOException {
        try (stream) {
            stream.readLine();
            String line;

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
        }
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
