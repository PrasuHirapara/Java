package Time;

import java.time.LocalDateTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // T is just separator
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getHour());

        if(now.isAfter(now.plusDays(1))){
            System.out.println("True");
        }

        LocalDateTime custom = LocalDateTime.of(2024, 12, 31, 23, 59, 59);
        System.out.println(custom);

        LocalDateTime parsed = LocalDateTime.parse("2024-12-31T23:59:59");
        System.out.println(parsed);
    }
}
