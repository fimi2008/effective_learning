package top.lionxxw.java8.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Package top.lionxxw.java8.base64
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/25 16:05
 * version 1.0.0
 */
public class Base64Example {
    public static void main(String[] args) {
        String text = "Base64 finally in Java 8";
        String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        System.out.println(decoded);

        String url = "http://www.lionxxw.top";
        String encode = Base64.getUrlEncoder().encodeToString(url.getBytes(StandardCharsets.UTF_8));
        System.out.println(encode);
        String decode = new String(Base64.getUrlDecoder().decode(encode),StandardCharsets.UTF_8);
        System.out.println(decode);
    }
}