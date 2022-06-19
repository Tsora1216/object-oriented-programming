package chap10;
// Listing 10-3: HashSet test

import java.util.Arrays;
import java.util.HashSet;

public class HashSetTest {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // 九九の計算
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                set.add(i * j);
            }
        }

        // 結果の出力
        System.out.println("ユニークな積の数は " + set.size());
        Integer[] array = (Integer[]) set.toArray(new Integer[0]);
        System.out.println("ユニークな積は " + Arrays.toString(array));
    }
}
