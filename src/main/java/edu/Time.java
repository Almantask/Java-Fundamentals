package edu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Time {
    public static void demo() throws InterruptedException {//throws IOException {
        //Instant nowInstant = printInstantTime();
        //LocalDateTime nowDateTime = printLocaDateTimeFormattedToUSA();
        //ZonedDateTime nowZoned = printZonedDateTime();
        //checkDifference(nowInstant, nowDateTime, nowZoned);
        //serializeDates(nowInstant, nowDateTime, nowZoned);
        demoDateFormats();
    }

    private static void demoDateFormats() {
        DateTimeFormatter formatter;
        LocalDateTime time = LocalDateTime.now();
        System.out.println("----Playing with formats-----");
        /*
   G       era                         text              AD; Anno Domini; A
   u       year                        year              2004; 04
   y       year-of-era                 year              2004; 04
   D       day-of-year                 number            189
   M/L     month-of-year               number/text       7; 07; Jul; July; J
   d       day-of-month                number            10

   Q/q     quarter-of-year             number/text       3; 03; Q3; 3rd quarter
   Y       week-based-year             year              1996; 96
   w       week-of-week-based-year     number            27
   W       week-of-month               number            4
   E       day-of-week                 text              Tue; Tuesday; T
   e/c     localized day-of-week       number/text       2; 02; Tue; Tuesday; T
   F       week-of-month               number            3

   a       am-pm-of-day                text              PM
   h       clock-hour-of-am-pm (1-12)  number            12
   K       hour-of-am-pm (0-11)        number            0
   k       clock-hour-of-am-pm (1-24)  number            0

   H       hour-of-day (0-23)          number            0
   m       minute-of-hour              number            30
   s       second-of-minute            number            55
   S       fraction-of-second          fraction          978
   A       milli-of-day                number            1234
   n       nano-of-second              number            987654321
   N       nano-of-day                 number            1234000000

   V       time-zone ID                zone-id           America/Los_Angeles; Z; -08:30
   z       time-zone name              zone-name         Pacific Standard Time; PST
   O       localized zone-offset       offset-O          GMT+8; GMT+08:00; UTC-08:00;
   X       zone-offset 'Z' for zero    offset-X          Z; -08; -0830; -08:30; -083015; -08:30:15;
   x       zone-offset                 offset-x          +0000; -08; -0830; -08:30; -083015; -08:30:15;
   Z       zone-offset                 offset-Z          +0000; -0800; -08:00;

   p       pad next                    pad modifier      1

   '       escape for text             delimiter
   ''      single quote                literal           '
   [       optional section start
   ]       optional section end
   #       reserved for future use
   {       reserved for future use
   }       reserved for future use
        * */
        formatter = DateTimeFormatter.ofPattern("GG yyyy MMM d, EEE ha");
        System.out.println(time.format(formatter)+  " to " + time.plusYears(1).format(formatter));
        System.out.println("----End of playing with formats-----");

        // 2020-10-11T08:55:47.7839284
        formatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(time.format(formatter));

        // 2020 Oct Sun
        formatter = DateTimeFormatter.ofPattern("YYYY LLL E");
        System.out.println(time.format(formatter));

        // 2020-10-11
        formatter = DateTimeFormatter.ofPattern("YYYY-MM-d");
        System.out.println(time.format(formatter));

        // 10/11/2020
        formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");
        System.out.println(time.format(formatter));
    }

    private static ZonedDateTime printZonedDateTime() {
        // Same as above, but with timezone info
        System.out.println("ZonedDateTime");
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
        return time;
    }

    private static LocalDateTime printLocaDateTimeFormattedToUSA() {
        // Current time in current timezone
        System.out.println("LocalDateTime");
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(nowDateTime.format(formatter));
        return nowDateTime;
    }

    private static Instant printInstantTime() {
        // Utc time
        System.out.println("Instant");
        Instant nowInstant = Instant.now();
        System.out.println(nowInstant);
        return nowInstant;
    }

    private static void checkDifference(Instant nowInstant, LocalDateTime nowLocalDateTime, ZonedDateTime nowZoned) throws InterruptedException {
        LocalDateTime dateTime1 = LocalDateTime.now();
        Thread.sleep(5);
        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println("dateTime1.equals(dateTime2)=" + dateTime1.equals(dateTime2));

        LocalDate date1 = LocalDate.now();
        Thread.sleep(5);
        LocalDate date2 = LocalDate.now();
        System.out.println("date1.equals(date2)=" + date1.equals(date2));

        // https://garygregory.wordpress.com/2013/06/18/what-are-the-java-timezone-ids/
        // We need to make sure we are using the same timezone
        LocalDateTime instantLocalDateTime = nowInstant.atZone(ZoneId.of("Europe/Vilnius")).toLocalDateTime();
        Duration duration1 = Duration.between(instantLocalDateTime, nowLocalDateTime);
        System.out.println("Duration1: " + duration1.getNano());

        Duration duration2 = Duration.between(nowInstant, nowZoned);
        System.out.println("Duration2: " + duration2.getNano());

        Duration duration3 = Duration.between(nowLocalDateTime, nowZoned);
        System.out.println("Duration3: " + duration3.getNano());

        Period period = Period.between(instantLocalDateTime.toLocalDate(), nowLocalDateTime.toLocalDate());
        System.out.println("Period: " + period.getDays());
    }

    // Refer to this later, after covering maven.
    private static void serializeDates(Instant nowInstant, LocalDateTime nowDateTime, ZonedDateTime nowZoned) throws IOException {
        // Converting to json using jackson. Refer to pom.xml for dependencies
        ObjectMapper objectMapper = new ObjectMapper()
                // indented
                .enable(SerializationFeature.INDENT_OUTPUT)
                // iso datetime format instead of object
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule());

        objectMapper.writeValue(new File("target/times-instant.json"), nowInstant);
        objectMapper.writeValue(new File("target/times-local.json"), nowDateTime);
        objectMapper.writeValue(new File("target/times-zoned.json"), nowZoned);
    }
}
