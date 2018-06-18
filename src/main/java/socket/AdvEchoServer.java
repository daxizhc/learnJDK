package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdvEchoServer {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(5, Executors.privilegedThreadFactory());

    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(8200)){
            int i = 1;
            while (true){
                Socket socket = s.accept();
                System.out.println("connected: "+ i++);
                threadPool.submit(new ThreadedEchoHandler(socket));
            }
        }
    }

}

class ThreadedEchoHandler implements Runnable {

    private Socket socket;

    ThreadedEchoHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Scanner in = new Scanner(inputStream);
            PrintWriter out = new PrintWriter(outputStream, true);
            out.println("Hello, print BYE to exit");
            boolean done = false;
            while (!done && in.hasNextLine()){
                String line = in.nextLine();
                out.println("Echo:" + line);
                if(line.trim().equals("BYE"))done = true;
            }
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

