import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
  static ServerSocket listener;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    runServer();

    try {
      while (true) {
        sendMessage(inputMessage());
        readMessage();
      }
    } finally {
      stopServer();
    }
  }

  public static void runServer() throws IOException {
    listener = new ServerSocket(9090);
  }

  public static String inputMessage() {
    System.out.print("Server : ");
    return scan.nextLine();
  }

  public static void sendMessage(String message) throws IOException {
    Socket socket = listener.accept();
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    out.println(message);
    socket.close();
  }

  public static void readMessage() throws IOException {
    Socket socket = listener.accept();
    Scanner scan = new Scanner(new InputStreamReader(socket.getInputStream()));
    System.out.println("Client : " + scan.nextLine());
    socket.close();
  }

  public static void stopServer() throws IOException {
    listener.close();
  }
}