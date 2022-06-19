package chap10;
// Listing 10-5: HashMap Entry test

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest2 {

    public static void main(String[] args) throws IOException {
        File file = new File("src/Movie100.txt");
        HashMap<String, Integer> map = new HashMap<>();
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        // ファイルから読み込み
        try (br) {
            String line = br.readLine();
            while (line != null) {
                String[] column = line.split("\t");
                String year = column[1].trim();
                if (map.containsKey(year)) // 既出年ならばカウントアップ
                    map.replace(year, map.get(year) + 1);
                else // 新出年ならばカウントを1に初期設定
                    map.put(year, 1);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        }

        // 年の昇順にソート
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String, Integer>> cmpr = new Comparator<>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getKey().compareTo(e2.getKey());
            }
        };
        Collections.sort(entries, cmpr);

        // 件数が3件以上を表示
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() >= 3)
                System.out.println(entry);
        }
    }
}
