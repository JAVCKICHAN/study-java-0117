package org.example;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class MovieCopy {
    public static void main(String[] args)throws Exception {

        //[외부 이미지를 복사해보기]

        String path = "https://cdn.cgv.co.kr/cgvpomsfilm/vodCGVa/30000178/30000178_402904_1200_128_960_540.mp4#t=0.5";
        URL url = new URL(path);

        //in 빨대 만들기(읽기)
        InputStream in = url.openStream();
        //out 빨대 만들기(쓰기)
        OutputStream out = new FileOutputStream("/Users/kimda/study-java/image/movie-copy.mp4");

        //빨아들이기 - read
        while(true){ //많은 byte를 읽어야 하기 때문에? while

            int data = in.read();// 1byte를 읽음.
            //read가 추상 메서드임. 함수형으로 설계되 int값으로 뭔가를 줘야함.
            //내부적으로 + 255를 함 -> 음수가 나올 수 없게 설계

            //System.out.println(data);

            //더 이상 읽을게 없을 경우 -1을 반환.(=함수형)
            if(data == -1){
                break;
            }
            out.write(data);
        }

        in.close(); //빨때를 뽑는다.
        out.close();

    }
}
