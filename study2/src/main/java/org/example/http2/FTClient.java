package org.example.http2;

import lombok.Cleanup;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

//클라이언트에서 서버가 보내준 이미지를 읽어들이기
public class FTClient {

    public static void main(String[] args) throws Exception {

        //소켓연결
        @Cleanup
        Socket socket = new Socket("127.0.0.1", 5555);

        @Cleanup
        FileOutputStream fos = new FileOutputStream("today.png");

        //보내준 이미지를 읽어들이기
        @Cleanup
        InputStream in = socket.getInputStream();

        byte[] buffer = new byte[1024];

        System.out.println("전송된 데이터 읽기 시작");

        while (true) {
            int count = in.read(buffer);
            System.out.println(count);
            if (count == -1) {break;}

            fos.write(buffer, 0, count);
        }//end while
    }
}
