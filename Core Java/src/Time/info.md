# Java `Time` Classes

- The `java.time` package offers a variety of classes for handling dates, times, and time zones. Each method description below includes how it returns data and a sample output format.
- All classes are immutable.
---

## 1. `LocalTime`
Represents a time without a date or time zone, typically used to model times of day.

### Methods:
- **`now()`**: Obtains the current time from the system clock.  
  *Pattern:* `HH:mm:ss`  
  *Example:* `LocalTime.now()` → `14:30:25`

- **`of(int hour, int minute)`**: Creates an instance from the given hour and minute.  
  *Pattern:* `HH:mm`  
  *Example:* `LocalTime.of(10, 15)` → `10:15`

- **`plusHours(long hours)`**, **`plusMinutes(long minutes)`**: Adds specified units to the current time.  
  *Pattern:* `HH:mm:ss`  
  *Example:* `LocalTime.now().plusHours(2)` → `16:30:25`

- **`minusHours(long hours)`**, **`minusMinutes(long minutes)`**: Subtracts specified units from the current time.  
  *Pattern:* `HH:mm:ss`  
  *Example:* `LocalTime.now().minusMinutes(30)` → `14:00:25`

- **`getHour()`**, **`getMinute()`**, **`getSecond()`**: Retrieves the hour, minute, and second components.  
  *Pattern:* Individual time component as an integer.  
  *Example:* `LocalTime.now().getHour()` → `14`

- **`isBefore(LocalTime other)`**, **`isAfter(LocalTime other)`**: Checks if the time is before or after another specified time.  
  *Pattern:* `true` or `false`  
  *Example:* `LocalTime.of(10, 15).isBefore(LocalTime.now())` → `true`

- **`toString()`**: Returns a string representation of the time.  
  *Pattern:* `HH:mm:ss`  
  *Example:* `LocalTime.now().toString()` → `14:30:25`

- Ex: 
```java
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

```
---

## 2. `LocalDate`
Represents a date without a time zone, useful for modeling calendar dates.

### Methods:
- **`now()`**: Obtains the current date from the system clock.  
  *Pattern:* `yyyy-MM-dd`  
  *Example:* `LocalDate.now()` → `2024-10-27`

- **`of(int year, int month, int dayOfMonth)`**: Creates an instance from the specified date.  
  *Pattern:* `yyyy-MM-dd`  
  *Example:* `LocalDate.of(2024, 10, 27)` → `2024-10-27`

- **`plusDays(long days)`**, **`plusMonths(long months)`**, **`plusYears(long years)`**: Adds specified units to the date.  
  *Pattern:* `yyyy-MM-dd`  
  *Example:* `LocalDate.now().plusDays(5)` → `2024-11-01`

- **`minusDays(long days)`**, **`minusMonths(long months)`**: Subtracts specified units from the date.  
  *Pattern:* `yyyy-MM-dd`  
  *Example:* `LocalDate.now().minusMonths(1)` → `2024-09-27`

- **`getYear()`**, **`getMonth()`**, **`getDayOfMonth()`**: Retrieves the year, month, and day components.  
  *Pattern:* Individual date component as an integer or enum.  
  *Example:* `LocalDate.now().getYear()` → `2024`

- **`isLeapYear()`**: Checks if the current year is a leap year.  
  *Pattern:* `true` or `false`  
  *Example:* `LocalDate.now().isLeapYear()` → `false`

- **`isBefore(LocalDate other)`**, **`isAfter(LocalDate other)`**: Checks if the date is before or after another specified date.  
  *Pattern:* `true` or `false`  
  *Example:* `LocalDate.of(2023, 10, 21).isBefore(LocalDate.now())` → `true`

- **`toEpochDay()`**: Converts the date to the number of days since the epoch (1970-01-01).  
  *Pattern:* `long`  
  *Example:* `LocalDate.of(2024, 10, 27).toEpochDay()` → `19651`

```java
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
```
---

## 3. `LocalDateTime`
Represents a date-time without a time zone, combining `LocalDate` and `LocalTime`.

### Methods:
- **`now()`**: Obtains the current date and time from the system clock.  
  *Pattern:* `yyyy-MM-ddTHH:mm:ss`  
  *Example:* `LocalDateTime.now()` → `2024-10-27T14:30:25`

- **`of(int year, int month, int dayOfMonth, int hour, int minute)`**: Creates an instance with the specified date and time.  
  *Pattern:* `yyyy-MM-ddTHH:mm`  
  *Example:* `LocalDateTime.of(2024, 10, 27, 10, 15)` → `2024-10-27T10:15`

- **`plusDays(long days)`**, **`plusHours(long hours)`**: Adds specified units to the date-time.  
  *Pattern:* `yyyy-MM-ddTHH:mm:ss`  
  *Example:* `LocalDateTime.now().plusDays(5)` → `2024-11-01T14:30:25`

- **`getYear()`**, **`getMonth()`**, **`getDayOfMonth()`**, **`getHour()`**, **`getMinute()`**: Retrieves the date and time components.  
  *Pattern:* Individual date or time component as an integer.  
  *Example:* `LocalDateTime.now().getHour()` → `14`

- **`toLocalDate()`**: Extracts the `LocalDate` part of this date-time.  
  *Pattern:* `yyyy-MM-dd`  
  *Example:* `LocalDateTime.now().toLocalDate()` → `2024-10-27`

- **`toLocalTime()`**: Extracts the `LocalTime` part of this date-time.  
  *Pattern:* `HH:mm:ss`  
  *Example:* `LocalDateTime.now().toLocalTime()` → `14:30:25`

```java
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
```
---

## 4. `Instant`
- Represents a timestamp as a point in time, typically used for machine-readable timestamps.
- Same as `LocalDateTime` but instead of milliSeconds it returns nanoSeconds.
### Methods:
- **`now()`**: Obtains the current timestamp from the system clock.  
  *Pattern:* `yyyy-MM-ddTHH:mm:ssZ`  
  *Example:* `Instant.now()` → `2024-10-27T14:30:25Z`

```java
package Time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantExample {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
        
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);
    }
}
```
---
## 5. `Duration`
- Represents a time-based amount of time, such as '5 seconds'.

### Methods:
- **`between(Temporal start, Temporal end)`**: Creates a `Duration` between two time points.  
  *Pattern:* `PTnHnMnS`  
  *Example:* `Duration.between(LocalTime.NOON, LocalTime.MIDNIGHT)` → `PT12H`
```java
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
```
---

## 6. `Period`
- Represents a date-based amount of time, such as '2 years, 3 months, and 4 days'.
- 
### Methods:
- **`between(LocalDate startDate, LocalDate endDate)`**: Creates a `Period` between two dates.  
  *Pattern:* `PnYnMnD`  
  *Example:* `Period.between(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 1, 1))` → `P4Y`
```java
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
```
---

## 7. `ZonedDateTime`
Represents a date-time with a time zone including UTC (global time) zone, useful for global applications.

### Methods:
- **`now()`**: Obtains the current date-time with the system’s default time zone.  
  *Pattern:* `yyyy-MM-ddTHH:mm:ssZ[ZoneId]`  
  *Example:* `ZonedDateTime.now()` → `2024-10-27T14:30:25+01:00[Europe/Paris]`

```java
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

```
---

## 8. `DateTimeFormatter`
Provides a way to format and parse date-time objects.

### Methods:
- **`ofPattern(String pattern)`**: Creates a formatter using the specified pattern.  
  *Pattern:* Custom based on input  
  *Example:* `DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now())` → `2024-10-27`

### Symbols: 
- **`y`**: Year (`yyyy` - 4-digit, `yy` - 2-digit)
- **`M`**: Month (`MM` - 2-digit, `MMM` - short name, `MMMM` - full name)
- **`d`**: Day of Month (`dd` - 2-digit, `d` - single-digit)
- **`E` or `e`**: Day of Week (`EEE` - short name, `EEEE` - full name)
- **`a`**: AM/PM marker
- **`H`**: Hour (0-23, `HH` - 2-digit)
- **`h`**: Hour (1-12, `hh` - 2-digit)
- **`m`**: Minute (`mm` - 2-digit)
- **`s`**: Second (`ss` - 2-digit)
- **`S`**: Fraction of Second (milliseconds)
- **`z`**: Time Zone
- **`Z`**: Offset from UTC (e.g., `+0000`)
- **`X`**: ISO 8601 Time Zone (`X` - basic, `XX` - extended, `XXX` - full extended)

```java
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
```