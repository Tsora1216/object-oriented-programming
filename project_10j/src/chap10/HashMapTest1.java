package chap10;
// Listing 10-4: HashMap test

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest1 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/Station.csv");
        HashMap<String, String> map = new HashMap<>();
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "Shift_JIS");
        BufferedReader br = new BufferedReader(isr);

        try (br) {
            System.out.print("ファイルから読み込み中 ...");
            String line = br.readLine();
            while (line != null) {
                String[] column = line.split(",");
                map.put(column[0].trim(), column[1].trim());
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        }
        System.out.println("完了");

        Scanner stdIn = new Scanner(System.in);
        while (true) {
            System.out.print("駅番号: ");
            String key = stdIn.nextLine().trim().toUpperCase();
            if (key.isEmpty()) {
                break;
            } else {
                System.out.println(map.get(key));
            }
        }
    }
}
