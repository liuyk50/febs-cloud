package com.liuyk.test;

import com.liuyk.bean.Man;
import com.liuyk.bean.ParseMan;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Optional;

public class TestStream {
    @Test
    public void test1(){

        Integer[] list = new Integer[]{1,2,3,4};

        Arrays.stream(list).map((x)->x*x).forEach(System.out::println);
    }
    @Test
    public void test2(){
        Optional<Man> optionalMan = Optional.ofNullable(null);
        System.out.println(optionalMan);
        Optional<Man> optionalMan1 = Optional.of(new Man("aaa",50,"aaa"));
        System.out.println(optionalMan1);

        Man man = optionalMan.orElse(new Man("sss", 18, "sss"));
        System.out.println(man);

        Optional<Man> optionalMan2 = optionalMan1.map((x) -> {
            if (x.getAge() == 50) {
                x.setAge(20);
                return x;
            }
            return x;
        });
        System.out.println(optionalMan2);
    }
    @Test
    public void test3(){
        ParseMan man = new ParseMan();
        man.hhh();
    }

    @Test
    public void test4(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime3 = localDateTime.plusYears(2);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusHours(3);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime2 =  localDateTime.of(2021,6,30,16,14,55);
        System.out.println(localDateTime2);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }
    @Test
    public void test6(){

        Instant instant = Instant.now();

        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }
    @Test
    public void test7()  {
        Instant instant = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();

        Duration duration =  Duration.between(instant,instant2);
        System.out.println(duration.getSeconds());
    }
    @Test
    public void test8(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(localDateTime2);

    }
    @Test
    public void test9(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;

        LocalDateTime localDateTime = LocalDateTime.now();

        String str1 = dateTimeFormatter.format(localDateTime);
        System.out.println(str1);

        String str = localDateTime.format(dateTimeFormatter);
        System.out.println(str);

    }

}
