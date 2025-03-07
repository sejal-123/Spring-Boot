package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        Dev dev = new Dev();
//        dev.build();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Dev dev = (Dev)context.getBean("dev");
        dev.build();
//        dev.setAge(12);
//        System.out.println(dev.getAge());

//        Setter injection is better when we are having optional variables
//        Constructor injection is better when we have compulsory variables
    }
}
