package org.example.socket;

import lombok.Cleanup;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//네트워크로 데이터 연결하기
public class Server1 {

    //Bad code
    public static void main(String[] args) throws Exception {

        //5555번으로 가게열기
        @Cleanup //close
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server started on port 5555....");

        //손님 연결
        @Cleanup //손님도 socket이기 때문에 close
        Socket clientSocket = serverSocket.accept(); //연결 들어올 떄 까지 멈춤
        System.out.println(clientSocket);

        //브라우저로 연결(client만들기 전)
        //http://localhost:5555

        //간단한 데이터 보내기 - ping
        @Cleanup
        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write(97); //a


    }
}





