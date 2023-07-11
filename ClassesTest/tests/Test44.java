package tests;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test44 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        while (true) {
            char x = (char) reader.read();
            System.out.println(x);
        }
    }
}
