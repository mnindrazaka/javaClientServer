import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class DateClient {
  public static void main(String[] args) throws IOException {
    String serverAddress = JOptionPane.showInputDialog("Input server");
    Socket socket = new Socket(serverAddress, 9090);

    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String answer = input.readLine();
    JOptionPane.showMessageDialog(null, answer);
    socket.close();
    System.exit(0);
  }
}