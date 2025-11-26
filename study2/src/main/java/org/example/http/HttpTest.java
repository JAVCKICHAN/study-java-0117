package org.example.http;

import lombok.Cleanup;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//[http] 브라우저가 보낸 Request 정보를 읽기
//[http] client에게 HTTP 응답 으로 데이터 보내기
public class HttpTest {

    public static void main(String[] args) throws Exception {

        @Cleanup //close
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server started on port 5555....");

        //Request로 어떤 정보가 오는지 파악하기
        for(int i =0; i<=10; i++) {

            byte[] arr =  new byte[100 * 8]; //800byte

            @Cleanup Socket client = serverSocket.accept();
            @Cleanup InputStream in = client.getInputStream();
            @Cleanup OutputStream out = client.getOutputStream();

            //브라우저가 보낸 정보를 arr에 저장
            int count = in.read(arr);//몇 개나 새로운 데이터가 차는지

            String str = new String(arr, 0, count);//byte의 배열로 문자열로 만들기

            System.out.println(str);
            System.out.println("-----------------------");

            //HTTP 응답 작성
            //java의 트리플쿼테이션: 여러 개 라인을 작성할 때 줄바꿈 하지 않아도 됨
            String response = """
                            HTTP/1.1 200 OK
                            Content-Type: text/html; charset=UTF-8

                            """;

            //HTTP 본문을 서비스를 통해 랜덤하게 보내기
            response += "<h1>"+WiseSayingService.INSTANCE.getOne()+"<h1>";

            //response를 byte의 배열로 바꾸기
            byte[] msgArr = response.getBytes();
            //브라우저와 연결된 out으로 내보내기
            out.write(msgArr);


        }

    }
}
