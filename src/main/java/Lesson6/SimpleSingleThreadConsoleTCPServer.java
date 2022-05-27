package Lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSingleThreadConsoleTCPServer {
    private static final int PORT = 8189;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread serverThred;

    public static void main(String[] args) {
        new SimpleSingleThreadConsoleTCPServer().start();
    }

    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            waitConnection(serverSocket);
            startConsoleInput();


            while (true) {
                String income = in.readUTF();
                if (income.startsWith("/end")) {
                    shutdown();
                    break;
                }
                System.out.println("Received: " + income);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void shutdown() throws IOException {
        if (serverThred != null && serverThred.isAlive()){
            serverThred.interrupt();
        }
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
        System.out.println("Server stopped");
    }

    private void startConsoleInput() {
        serverThred = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter your message >>>>> ");
                while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
                    if (br.ready()) {
                        String outcome = br.readLine();
                        out.writeUTF(outcome);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThred.start();
    }

    private void waitConnection(ServerSocket serverSocket) throws IOException {
        System.out.println("Wait for connection.....");
        socket = serverSocket.accept();
        System.out.println("Client connected");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }
}
