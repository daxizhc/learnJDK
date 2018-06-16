package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketTest {

    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13)){
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuffer sb = new StringBuffer();
            while ((len = in.read(bytes)) != -1){
                sb.append(new String(bytes, 0, len));
            }
            System.out.println(sb.toString());
        }
    }


}
