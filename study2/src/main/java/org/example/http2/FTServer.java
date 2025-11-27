package org.example.http2;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Server가 파일 데이터를 읽고 쓰기
public class FTServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("FTServer Ready ........ ");

        byte[] buffer = new byte[1024 * 8];

        //서버를 계속 돌리기 위해서 while
        while (true) {

            System.out.println("----------------------");

            int num = (int)(Math.random() * 4)+1; //1~4
            String fileName = "/Users/kimda/study-java/image/"+num+".png";

            @Cleanup
            Socket socket = serverSocket.accept();
            @Cleanup
            OutputStream outputStream = socket.getOutputStream();

            //파일데이터를 읽어들이기
            @Cleanup
            InputStream fin = new FileInputStream(fileName);
            while(true) {
                int count = fin.read(buffer);
                if(count == -1) {break;}
                outputStream.write(buffer, 0, count);
            }//end while

            System.out.println("---------------");

        }//end while

    }
}
