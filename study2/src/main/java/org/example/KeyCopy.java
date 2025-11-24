package org.example;

import lombok.Cleanup;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class KeyCopy {
    //Bad code
    public static void main(String[] args)throws Exception {
        InputStream in = System.in; //키보드라 System.in이 됨

        @Cleanup
        OutputStream fos = new FileOutputStream("/Users/kimda/study-java/image/input.txt");

        System.out.println("한글을 입력해 주세요");

        for(int i=0; i<=10; i++){
            int data = in.read(); //1 byte의 내용물
            fos.write(data);
        }
    }
}
