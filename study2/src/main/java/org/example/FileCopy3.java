package org.example;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy3 {

    //Bad code
    public static void main(String[] args) throws Exception {

        @Cleanup
        InputStream fin = new FileInputStream("/Users/kimda/study-java/image/test.txt");

        //중요
        byte[] buffer = new byte[5];

        OutputStream fos = new FileOutputStream("copy.txt");

        while (true) {

            //새로운게 몇 개나 찼나를 알려주는 숫자
            //헷갈리지 않게 변수 명을 count로 잡아줌
            int count = fin.read(buffer);

            //더 이상 읽을 데이터가 없을 때
            if (count == -1) {break;};

            fos.write(buffer,0,count); //배열에 맨처음부터, 새롭게 쓰여진 슷자 만큼만 쓰게하기
        }//end while
    }
}
