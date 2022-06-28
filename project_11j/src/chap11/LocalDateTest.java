package chap11;
// Listing 11-6: LocalDate test

import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTest {

    public static void main(String[] args) {
        // LocalDateクラスの確認
        LocalDate today = LocalDate.now();
        System.out.println("本日は、" + today);
        System.out.println("エポック日は、" + today.toEpochDay());
        System.out.printf("%d年%d月%d日 %s(%d)\n", today.getYear(),
                today.getMonthValue(), today.getDayOfMonth(),
                today.getDayOfWeek(), today.getDayOfWeek().getValue());
        System.out.println();

        System.out.println("昨日は、" + today.plusDays(-1));
        System.out.println("明日は、" + today.plusDays(1));
        System.out.println();

        // DateTimeFormatterクラスの確認
        DateTimeFormatter df0 = DateTimeFormatter.ofPattern("Gy年M月d日 E(e)");
        System.out.println(df0.format(today));

        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("Gy年M月d日 E(e)",
                Locale.US);
        System.out.println(df1.format(today));

        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("Gy年M月d日 E(e)").
                withChronology(JapaneseChronology.INSTANCE);
        System.out.println(df2.format(today));
        System.out.println();

        // JapaneseChronologyの確認
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("Gy年M月d日 (EEEE)")
                .withChronology(JapaneseChronology.INSTANCE);

        LocalDate reiwa01 = LocalDate.of(2019, 5, 1);
        System.out.println(df3.format(reiwa01));
        System.out.println(df3.format(reiwa01.minusDays(1)));

        LocalDate heisei01 = LocalDate.of(1989, 1, 8);
        System.out.println(df3.format(heisei01));
        System.out.println(df3.format(heisei01.minusDays(1)));
    }
}
