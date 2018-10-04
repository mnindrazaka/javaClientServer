import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
  static Socket socket;

  public static void main(String[] args) throws IOException {
    while (true) {
      readMessage();
      sendMessage(inputMessage());
    }
  }

  public static void readMessage() throws IOException, UnknownHostException {
    socket = new Socket("localhost", 9090);
    Scanner scan = new Scanner(new InputStreamReader(socket.getInputStream()));
    System.out.println("Server : " + scan.nextLine());
    socket.close();
  }

  public static String inputMessage() {
    Scanner scan = new Scanner(System.in);
    System.out.print("Client : ");
    return scan.nextLine();
  }

  public static void sendMessage(String message) throws IOException {
    socket = new Socket("localhost", 9090);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    out.println(message);
  }

  public static void closeSocket() throws IOException {
    System.exit(0);
  }
}