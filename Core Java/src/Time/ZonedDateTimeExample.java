package Time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        System.out.println(now.getZone());

        ZonedDateTime parsed = ZonedDateTime.parse("2024-10-27T21:23:40.696789500+05:30[Asia/Calcutta]");

        ZonedDateTime newYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(newYork);

        ZonedDateTime custom = ZonedDateTime.of(2024, 12, 1, 14, 30, 30, 0, ZoneId.of("America/New_York"));
        System.out.println(custom);

        Set<String> availableTimeZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableTimeZoneIds); // time zone in World
    }
}
