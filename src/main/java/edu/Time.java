package edu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Time {
    public static void demo() {//throws IOException {
        //Instant nowInstant = printInstantTime();
        //LocalDateTime nowDateTime = printLocaDateTimeFormattedToUSA();
        //ZonedDateTime nowZoned = printZonedDateTime();
        //checkDifference(nowInstant, nowDateTime, nowZoned);
        //serializeDates(nowInstant, nowDateTime, nowZoned);
        demoDateFormats();
    }

    private static void demoDateFormats() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter;

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
        formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
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

    private static void checkDifference(Instant nowInstant, LocalDateTime nowLocalDateTime, ZonedDateTime nowZoned){
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
