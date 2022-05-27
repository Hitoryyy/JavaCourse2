package HomeWork6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler {

    private static int clientCounter = 0;
    private int clientNumber;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread hanlerThread;
    private TCPServer tcpServer;

    public Handler(Socket socket, TCPServer tcpServer) {
        try {
            this.tcpServer = tcpServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Обработчик создан");
            this.clientNumber = ++clientCounter;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle() {
        hanlerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted() && socket.isConnected()) {
                try {
                    String message = in.readUTF();
                    message = "клиент #" + this.clientNumber + ": " + message;
                    tcpServer.broadcast(message);
                    System.out.printf("Клиент #%d: %s\n", this.clientNumber, message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        hanlerThread.start();
    }

    public void send(String m) {
        try {
            out.writeUTF(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


