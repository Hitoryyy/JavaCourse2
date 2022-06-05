package HomeWork6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPServer {

    private static final int PORT = 8189;
    private List<Handler> handlers;

    public TCPServer() {
        this.handlers = new ArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Серевер запущен");
            while (true) {
                System.out.println("Ожидание подключения...");
                Socket socket = serverSocket.accept();
                System.out.println("Клиетн подключился");
                Handler handler = new Handler(socket, this);
                handlers.add(handler);
                handler.handle();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(String message) {
        for (Handler handler : handlers) {
            handler.send(message);
        }
    }
}
