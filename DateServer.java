import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class DateServer {

  static ServerSocket listener;

  public static void main(String[] args) throws IOException {
    runServer();
    try {
      while (true) {
        sendMessage(readFile("message.txt"));
      }
    } finally {
      stopServer();
    }
  }

  public static void runServer() throws IOException {
    listener = new ServerSocket(9090);
  }

  public static String readFile(String path) throws FileNotFoundException {
    FileReader fileReader = new FileReader(path);
    Scanner scanner = new Scanner(fileReader);

    String fileContent = "";
    while (scanner.hasNextLine())
      fileContent += scanner.nextLine() + "\n";

    scanner.close();
    return fileContent;
  }

  public static void sendMessage(String message) throws IOException {
    Socket socket = listener.accept();
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    out.println(message);
    socket.close();
  }

  public static void stopServer() throws IOException {
    listener.close();
  }
}