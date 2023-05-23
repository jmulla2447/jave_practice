package core.java.practice.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DataAndTime {

//    How do you create a LocalDate object representing the current date?
//    How do you format a LocalDate object as a String using the ISO date format?
//    How do you calculate the difference between two LocalDate objects?

    public LocalDate todayDate(){
        return LocalDate.now();
    }

    public void findDiff(LocalDate date1, LocalDate date2){
        LocalDate todayDate =  todayDate();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        String formatedDate  = todayDate.format(formatter);
        System.out.println(formatedDate);
    }

    public void findDiffBetween(LocalDate date,  LocalDate date2){
        ChronoUnit.DAYS.between(date, date2);
    }
//    How do you create a LocalDateTime object representing a specific date and time?
//    How do you convert a LocalDateTime object to a ZonedDateTime object in a specific time zone?
//    How do you parse a String into a LocalDate object using a custom date format?
//    How do you calculate the difference between two ZonedDateTime objects in different time zones?
//    How do you find the first Monday of a given month using LocalDate?
//    How do you determine whether a given year is a leap year using the Year class?
//    How do you create a Duration object representing a time interval of one day?

    public void findDuration(LocalDateTime time, LocalDateTime time2){
        ChronoUnit.SECONDS.between(time, time2);
        Duration.between(time,time2).get(ChronoUnit.DAYS);
        TimeZone.getDefault();
    }

    public void createCurrentDateTime(){
        LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    public void convertLocalDateToZone(){
        LocalDateTime today =  LocalDateTime.now();
        //ZoneId.of("UTC");
       ZonedDateTime  currentZone  =  today.atZone(ZoneId.of("UTC"));
       System.out.println(currentZone);
    }


}
