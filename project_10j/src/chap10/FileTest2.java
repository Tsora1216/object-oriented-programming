package chap10;
// Listing 10-2: InputStreamReader test

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTest2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/TDU.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        try (br) {
            System.out.println("ファイルから読み込みます\n");
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            System.out.println();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
