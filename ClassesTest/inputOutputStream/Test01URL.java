package inputOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Test01URL {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.com");
        InputStream stream = url.openStream();
        byte[] arr = stream.readAllBytes();
        String str = new String(arr);
        System.out.println(str);


    }
}
