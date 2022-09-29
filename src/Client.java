import java.io.*;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            out.write("Проверка связи\n");
            out.flush(); // Для принятия сообщения на стороне сервака
            String serverMessage = in.readLine();
            System.out.println(serverMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}