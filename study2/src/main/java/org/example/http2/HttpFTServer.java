package org.example.http2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//png파일을 http로 브라우저에 전송하기
public class HttpFTServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5555);

        System.out.println("HttpFTServer run ..............");

        while (true) {

            //브라우저와 연결해서 Socket을 생성해야 한다 - accept
            Socket socket = serverSocket.accept();

            //보내고 싶으니 OutputStream을 생성한다.
            OutputStream outputStream = socket.getOutputStream();

            //읽고 싶은 파일에 InputStream을 꽂는다.
            InputStream inputStream = new FileInputStream("/Users/kimda/study-java/image/1.png");

            //90%비슷한데 [변경]처럼 다른 부분 있으면, 추상클래스/추상메서드로 빼준다!!
            //남들이 만들어 놓은 거 -> Servlet/JSP 스펙

            //[변경] http에 맞는 맞는 image/png 헤더 메세지를 OutputStream에 기록한다.
            //한 줄 한 줄 쓸 수 있다. \r\n 붙이기
            outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
            outputStream.write("Content-Type: image/png;\r\n".getBytes());
            outputStream.write("Content-Length: 84907\r\n".getBytes());
            outputStream.write("\r\n".getBytes());

            //[변경] 파일 데이터를 읽어서 OutputStream에 write()한다.
            //byte[]를 이용하면 매우매우 빨라진다.
            byte[] buffer = new byte[1024 * 8];
            while(true){

                int count = inputStream.read(buffer);//내용물은 buffer에 담겨있고, 숫자는 count에 찬다.
                if(count == -1){break;}
                outputStream.write(buffer, 0, count);
            }

        }//end while
    }
}

