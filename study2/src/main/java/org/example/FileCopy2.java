package org.example;

import lombok.Cleanup;

import java.io.*;

public class FileCopy2 {

    public static void main(String[] args)throws Exception{

        //1. try - catch - finally
        //2. try with resource (auto close)
        //3. lombok

        @Cleanup //try-catch자동으로 만들어줌
        InputStream in = new FileInputStream("/Users/kimda/study-java/image/aaa.png");
        @Cleanup
        OutputStream out = new FileOutputStream("/Users/kimda/study-java/image/copy-aaa.png");

        while(true){
            int data = in.read();
            if(data == -1){
                break;
            }
            out.write(data);
        }

        //마지막에 close하는 부분이 없어짐
    }
}
