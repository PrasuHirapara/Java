package Time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = LocalDate.of(2026, 3, 12);

        Period p1 = Period.between(today, yesterday);
        System.out.println(p1);
        System.out.println(p1.getYears());
        System.out.println(p1.getMonths());

        Period p2 = Period.of(2024, 3, 13);

        if(p1.equals(p2)){
            System.out.println("Equals");
        } else {
            System.out.println("Not Equals");
        }

    }
}

