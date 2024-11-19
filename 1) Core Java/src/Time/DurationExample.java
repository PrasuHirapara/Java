package Time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationExample {
    public static void main(String[] args) {

        Instant start = Instant.now();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Instant end = Instant.now();

        Duration d1 = Duration.between(start, end);
        System.out.println(d1);

        Duration d2 = Duration.of(1, ChronoUnit.SECONDS);
        System.out.println(d2);

        if(d1.compareTo(d2) > 0){
            System.out.println("d1 > d2");
        }else{
            System.out.println("d1 < d2");
        }
    }
}
