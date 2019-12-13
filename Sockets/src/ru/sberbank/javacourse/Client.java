package ru.sberbank.javacourse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8999);

        Order order = new Order("blabla", 228.69);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(order);


        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Result result = (Result) objectInputStream.readObject();
        System.out.println(result);
    }
}
