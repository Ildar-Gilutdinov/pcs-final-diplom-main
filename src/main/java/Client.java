import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    private static final int PORT = 8989;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, PORT); PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
// TODO: 13.12.2022 Вариант 1

//            Scanner scanner = new Scanner(System.in);
//            String questionServer = in.readLine();
//            System.out.println(questionServer);
//            String answerServer = scanner.nextLine();
//            out.println(answerServer);
//            String reportServer = in.readLine();
//            System.out.println(reportServer);
//            scanner.close();

// TODO: 13.12.2022 Вариант 2
            while (true) {
                System.out.println("Соединение с сервером");
                String wordClient = in.readLine();
                out.println(wordClient);
                System.out.println("Ответ от клиента серверу , ваше слово принято " + wordClient);
                wordClient = in.readLine();
                System.out.println(wordClient);
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
