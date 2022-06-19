package chap10;
// Listing 10-1: File Reader/Writer test

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest1 {

    public static void main(String[] args) {
        File file = new File("newfile.txt");
        System.out.println(file.getAbsolutePath());

        try (FileWriter writer = new FileWriter(file)) {
            String str = "Test data in newfile.txt\nここからは日本語文字列\n";
            writer.write(str);
            System.out.println("ファイルを作成しました。");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (FileReader reader = new FileReader(file)) {
            System.out.println("ファイルから読み込みます。");
            int c = reader.read();
            while (c >= 0) {
                System.out.print((char) c);
                c = reader.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
