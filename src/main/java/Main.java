import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int PORT = 8989;

    public static void main(String[] args) throws Exception {
        BooleanSearchEngine engine = new BooleanSearchEngine(new File("pdfs"));
//        System.out.println(engine.search("бизнес"));
        // здесь создайте сервер, который отвечал бы на нужные запросы
        // слушать он должен порт 8989
        // отвечать на запросы /{word} -> возвращённое значение метода search(word) в JSON-формате
        try (ServerSocket serverSocket = new ServerSocket(PORT);) {
            System.out.println("Сервер запущен!");
            Gson gson = new Gson();
            // TODO: 19.12.2022 Корректировка замечаний
            while (true) { // в цикле(!) принимаем подключения
                try (Socket socket = serverSocket.accept(); // ждем подключения
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream(), true);) {
// TODO: 13.12.2022 Вариант 1
                    // TODO: 19.12.2022 Корректировка замечаний
                    //  Ничего кроме ответа на запрос писаться в подключение не должно
                    out.println();
                    String word = in.readLine();
                    List<PageEntry> searchResult = engine.search(word);
                    out.println(gson.toJson(searchResult));
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}