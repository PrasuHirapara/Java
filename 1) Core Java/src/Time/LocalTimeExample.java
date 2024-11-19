package Time;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());
        System.out.println(now.plusHours(23));

        if(now.isAfter(now.plusHours(23))){
            System.out.println("True");
        }

        LocalTime custom = LocalTime.of(14, 23, 32);
        System.out.println(custom);

        LocalTime parsed = LocalTime.parse("11:32:12");
        System.out.println(parsed);
    }
}
