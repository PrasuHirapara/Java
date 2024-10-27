package Time;

import java.time.LocalDate;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getDayOfMonth());
        System.out.println(today.getDayOfWeek());
        System.out.println(today.getDayOfYear());
        System.out.println(today.getMonth());
        System.out.println(today.getYear());
        System.out.println(today.getMonthValue());

        if(today.isAfter(today.minusDays(1))) {
            System.out.println("Today is after yesterday");
        }

        today = today.minusMonths(14);
        System.out.println(today);

        LocalDate myDate = LocalDate.of(2025, 1, 1);
        System.out.println(myDate);
    }
}
