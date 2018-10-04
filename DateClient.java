import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DateClient {
  static Socket socket;

  public static void main(String[] args) throws IOException {
    openSocket();
    readMessage();
    closeSocket();
  }

  public static void openSocket() throws UnknownHostException, IOException {
    socket = new Socket("localhost", 9090);
  }

  public static void readMessage() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String answer = input.readLine();
    System.out.println(answer);
  }

  public static void closeSocket() throws IOException {
    socket.close();
    System.exit(0);
  }
}