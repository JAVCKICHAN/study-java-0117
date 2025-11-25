package org.example.socket;

import lombok.Cleanup;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//[I/O] 네트워크로 데이터 연결하기
public class Server1 {

    //Bad code
    public static void main(String[] args) throws Exception {

        //5555번으로 가게열기
        @Cleanup //close
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server started on port 5555....");

        //한 번의 서버 실행으로, 여러 요청 받기
        for(int i =0; i<=100; i++) {
            //손님 연결
            @Cleanup //손님도 socket이기 때문에 close
            Socket clientSocket = serverSocket.accept(); //연결 들어올 떄 까지 멈춤
            System.out.println(clientSocket);

            //브라우저로 연결(client만들기 전)
            //http://localhost:5555

            //간단한 데이터 보내기 - ping
            //@Cleanup
            //OutputStream outputStream = clientSocket.getOutputStream();
            //outputStream.write(97); //a

            //클라이언트의 데이터를 읽어들이기
            @Cleanup
            InputStream inputStream = clientSocket.getInputStream();

            //클라이언트가 보내는 데이터 뒤에 \n 신호가 있기 떄문에,
            //Scanner를 선언한다
            @Cleanup
            Scanner inScanner = new Scanner(inputStream);

            //\n이 있을 때 까지 읽어들인다 = 한 문장
            String line = inScanner.nextLine();

            System.out.println(line);

        }//end for


    }
}





