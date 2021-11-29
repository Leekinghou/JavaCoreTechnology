import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class SocketClient {
    public static void sendData() throws Exception {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 0, 2000);
    }

    static class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            // 要连接的服务端IP地址和端口
            String host = "81.71.68.105";
            int port = 55533;
            // 与服务端建立连接
            Socket socket = null;
            try {
                socket = new Socket(host, port);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String message = "你好  lijinhao\n";
            try {
                socket.getOutputStream().write(message.getBytes("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
            try {
                socket.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
