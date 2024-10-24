
# Java `Time` Class
In Java, working with time typically involves classes from the `java.time` package, introduced in Java 8. This package provides comprehensive classes to deal with time, date, time zones, durations, and periods.

Commonly used classes include:
- `LocalTime`: Represents time without a date.
- `LocalDateTime`: Represents both date and time.
- `Instant`: Represents a point in time (timestamp).
- `Duration`: Represents a time-based amount of time between two instances.
- `Period`: Represents a date-based amount of time between two dates.

---

## 2. `LocalTime` Class

The `LocalTime` class represents a time without a date, such as 10:15:30.

### Methods in `LocalTime` Class:
- **`now()`**: Obtains the current time from the system clock.
- **`of(int hour, int minute)`**: Obtains an instance of `LocalTime` from given hour and minute.
- **`plusHours(long hours)`**: Returns a copy of this time with the specified number of hours added.
- **`minusMinutes(long minutes)`**: Returns a copy of this time with the specified number of minutes subtracted.
- **`getHour()`**: Gets the hour-of-day field.
- **`getMinute()`**: Gets the minute-of-hour field.
- **`isBefore(LocalTime other)`**: Checks if this time is before the specified time.
- **`isAfter(LocalTime other)`**: Checks if this time is after the specified time.
- **`toString()`**: Returns a string representation of the time.

### Example of `LocalTime` class:
```java
import java.time.LocalTime;

public class TimeExample {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        LocalTime customTime = LocalTime.of(10, 30);
        System.out.println("Custom Time: " + customTime);

        LocalTime timePlus = currentTime.plusHours(2);
        System.out.println("Time after 2 hours: " + timePlus);

        boolean isBefore = customTime.isBefore(currentTime);
        System.out.println("Is custom time before current time? " + isBefore);
    }
}
```
---

## 3. `LocalDateTime` Class

The `LocalDateTime` class represents a date and time without a time-zone.

### Methods in `LocalDateTime` Class:
- **`now()`**: Obtains the current date-time from the system clock.
- **`of(int year, int month, int dayOfMonth, int hour, int minute)`**: Obtains an instance of `LocalDateTime`.
- **`plusDays(long days)`**: Returns a copy of this date-time with the specified number of days added.
- **`minusMonths(long months)`**: Returns a copy of this date-time with the specified number of months subtracted.
- **`getDayOfMonth()`**: Gets the day-of-month field.
- **`getMonth()`**: Gets the month-of-year field.
- **`isBefore(LocalDateTime other)`**: Checks if this date-time is before the specified date-time.
- **`isAfter(LocalDateTime other)`**: Checks if this date-time is after the specified date-time.
- **`toLocalTime()`**: Extracts the `LocalTime` part of this date-time.

### Example of `LocalDateTime` class:
```java
import java.time.LocalDateTime;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        LocalDateTime customDateTime = LocalDateTime.of(2023, 10, 21, 10, 45);
        System.out.println("Custom Date and Time: " + customDateTime);

        LocalDateTime dateTimePlus = currentDateTime.plusDays(5);
        System.out.println("Date and Time after 5 days: " + dateTimePlus);

        boolean isAfter = customDateTime.isAfter(currentDateTime);
        System.out.println("Is custom date-time after current date-time? " + isAfter);
    }
}
```

---

## 4. `Duration` and `Period` Classes

The `Duration` class represents a time-based amount of time, such as '34.5 seconds', while `Period` represents a date-based amount, such as '2 years, 3 months, and 4 days'.

### Methods in `Duration` Class:
- **`between(Temporal start, Temporal end)`**: Obtains a `Duration` representing the time between two temporals.
- **`ofHours(long hours)`**: Obtains a `Duration` representing a number of hours.
- **`plusMinutes(long minutes)`**: Returns a copy of this duration with the specified number of minutes added.
- **`toMinutes()`**: Converts this duration to total minutes.

### Methods in `Period` Class:
- **`between(LocalDate startDate, LocalDate endDate)`**: Obtains a `Period` representing the period between two dates.
- **`ofYears(int years)`**: Obtains a period representing a number of years.
- **`plusMonths(long months)`**: Adds the specified number of months to this period.
- **`getYears()`**: Gets the amount of years in this period.

### Example of `Duration` and `Period`:
```java
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class DurationPeriodExample {
    public static void main(String[] args) {
        Duration duration = Duration.between(LocalTime.NOON, LocalTime.MIDNIGHT);
        System.out.println("Duration between noon and midnight: " + duration.toHours() + " hours");

        Period period = Period.between(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 1, 1));
        System.out.println("Period between two dates: " + period.getYears() + " years");
    }
}
```
---

## 5. Key Differences Between `LocalTime` and `LocalDateTime`

| Feature           | `LocalTime`                           | `LocalDateTime`                      |
|-------------------|---------------------------------------|--------------------------------------|
| Representation    | Represents only time (hours, minutes).| Represents both date and time.       |
| Example           | `LocalTime.now()`                     | `LocalDateTime.now()`                |
| Manipulation      | Methods like `plusHours`, `minusMinutes`.| Methods like `plusDays`, `minusMonths`. |

---

## 6. Conclusion
The `java.time` package provides a comprehensive set of classes to handle date and time effectively. `LocalTime` and `LocalDateTime` are the most commonly used classes for handling time and date, while `Duration` and `Period` are useful for measuring the amount of time or periods between dates.
