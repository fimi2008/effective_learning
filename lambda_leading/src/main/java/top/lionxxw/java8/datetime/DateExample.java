package top.lionxxw.java8.datetime;

import java.time.*;

/**
 * Package top.lionxxw.java8.datetime
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/25 15:19
 * version 1.0.0
 */
public class DateExample {

    public static void main(String[] args) {

        /**
         * Clock类，它通过指定一个时区，然后就可以获取到当前的时刻，日期与时间。
         * Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()。
         */
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        /**
         * LocaleDate只持有ISO-8601格式且无时区信息的日期部分
         */
        LocalDate date = LocalDate.now();
        LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);

        /**
         * LocaleTime只持有ISO-8601格式且无时区信息的时间部分
         */
        LocalTime time = LocalTime.now();
        LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock);

        /**
         * LocaleDateTime把LocaleDate与LocaleTime的功能合并起来，它持有的是ISO-8601格式无时区信息的日期与时间
         */
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime dateTimeFromClock = LocalDateTime.now(clock);
        System.out.println(dateTime);
        System.out.println(dateTimeFromClock);

        /**
         * 需要特定时区的日期/时间，那么ZonedDateTime是你的选择。它持有ISO-8601格式具具有时区信息的日期与时间
         */
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClock);
        System.out.println(zonedDateTimeFromZone);

        LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);

        /**
         * Duration类：在秒与纳秒级别上的一段时间。Duration使计算两个日期间的不同变的十分简单。
         */
        Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
    }
}
