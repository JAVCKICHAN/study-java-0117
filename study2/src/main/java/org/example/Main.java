package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Main {
    public static void main(String[] args)throws Exception {

        //[외부 이미지를 복사해보기]

        String path = "https://image.coupangcdn.com/image/vendor_inventory/image_audit/stage/manual/25b112daf919aff8f577533c4d1083b9382b78a0ae2d7d4893ac1c6858cf_1762234162994.jpg";
        URL url = new URL(path);

        //in 빨대 만들기(읽기)
        InputStream in = url.openStream();
        //out 빨대 만들기(쓰기)
        OutputStream out = new FileOutputStream("/Users/kimda/study-java/image/copy.jpg");

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