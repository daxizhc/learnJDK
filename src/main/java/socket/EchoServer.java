package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    // 只能连接1个客户端，其他客户端会等待
    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(8200)){
            try(Socket socket = s.accept()){
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                try(Scanner in = new Scanner(inputStream)){
                    PrintWriter out = new PrintWriter(outputStream, true);
                    out.println("Hello, print BYE to exit");

                    boolean done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("Echo:" + line);
                        if(line.trim().equals("BYE"))done = true;
                    }

                }

            }
        }


    }

}
