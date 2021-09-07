package com.liuyk.test;

import com.liuyk.bean.Persion;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Comsumer<t> :消费式接口
 *  void accept(T t);
 *
 *  Supplier<T> :供给式接口
 *  T get();
 *
 *  Function<T,R> : 函数式接口
 *  R apply(T t);
 *
 * Predicate<T> : 断言式接口
 * boolean test(T t)
 */
public class TestSamo {



    public static void main(String[] args) {
        List<Persion> list = Arrays.asList(new Persion("liu", "window", 18),
                new Persion("yi", "window", 20),
                new Persion("kun", "window", 50),
                new Persion("kun2", "window", 48),
                new Persion("wang", "window", 90));

        Collections.sort(list,(x,y)-> Integer.compare(x.getAge(), y.getAge()));

        for (Persion persion: list) {
            System.out.println(persion);
        }
        System.out.println("=============================");

        String str = add("abcdef",(x)->x.toUpperCase());
        System.out.println(str);

        System.out.println("=============================");
        happy("liuyikunzaiganma",System.out::println);

        List<Integer> list1 = happyEnd(5,()->(int)(Math.random()*100));
        System.out.println(list1);


    }

    public static String add(String str, Function<String,String> function){
        return function.apply(str);
    }
    public static void happy(String str, Consumer<String> function){
         function.accept(str);

    }
    public static List<Integer> happyEnd(int str, Supplier<Integer> function){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str; i++){
            list.add(function.get());
        }
        return list;
    }
}
