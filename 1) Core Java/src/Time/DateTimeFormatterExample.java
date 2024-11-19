package Time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM-yyyy");

//        date to string
        String formattedDate = formatter.format(today);
        System.out.println(formattedDate);

        String formattedDate2 = formatter2.format(today);
        System.out.println(formattedDate2);

//        string to date
//        LocalDate error = LocalDate.parse(formattedDate); // thous error
        LocalDate today2 = LocalDate.parse(formattedDate, formatter);
        System.out.println(today2);
    }
}
