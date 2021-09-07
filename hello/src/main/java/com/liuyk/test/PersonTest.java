package com.liuyk.test;

import com.liuyk.bean.Persion;

public class PersonTest {

    public static void main(String[] args){

        Persion person = new Persion();
        Persion person1 = new Persion("张三","篮球",18);
        person.setName("李四");
        person.setHost("足球");
        person.setAge(20);

        System.out.println(person);
        System.out.println(person1);
    }

}
