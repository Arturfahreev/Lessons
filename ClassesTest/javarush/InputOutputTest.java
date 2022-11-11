package javarush;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Считывает путь к файлам чтения и записи. Записывает из файла1 в файл2 данные, при этом меняя местами 1 и 2 байт,
 * 3 и 4 байт и т.д. Если байтов нечетное количество, то последний нечетный байт просто записывается.
 */
public class InputOutputTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        String dest = sc.nextLine();

        try (FileInputStream inputStream = new FileInputStream(src);
             FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
            while (inputStream.available() > 0) {
                byte[] buffer = new byte[512];
                int real = inputStream.read(buffer);
                if (real % 2 == 0) {
                    for (int i = 0; i < real; i += 2) {
                        byte t = buffer[i];
                        buffer[i] = buffer[i + 1];
                        buffer[i + 1] = t;
                    }
                    fileOutputStream.write(buffer, 0, real);
                } else {
                    int j = 0;
                    for (int i = 0; j < real / 2; i += 2, j++ ) {
                        byte t = buffer[i];
                        buffer[i] = buffer[i + 1];
                        buffer[i + 1] = t;
                    }
                    fileOutputStream.write(buffer, 0, real);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //напишите тут ваш код
    }
}
