package org.example.socket;

import lombok.Cleanup;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//[I/O] 네트워크로 데이터 연결하기
public class Client1 {

    //Bad code
    public static void main(String[] args) throws Exception {

        //실행되자마자 서버에 연결
        @Cleanup
        Socket socket = new Socket("127.0.0.1", 5555);
        System.out.println(socket);

        //==== 여기까지 성공하면, 네트워크 연결 성공한 것

        //읽는 프로그램
        @Cleanup
        InputStream inputStream = socket.getInputStream();
        //int data = inputStream.read(); //1byte만 읽기
        //System.out.println(data);

        @Cleanup
        OutputStream outputStream = socket.getOutputStream();

        //마지막에 특별한 신호를 붙이기: \n
        String msg = "보내고 싶은 메세지입니다..\n";
        //byte의 배열로 변경
        byte[] arr = msg.getBytes();
        outputStream.write(arr);

    }


}
