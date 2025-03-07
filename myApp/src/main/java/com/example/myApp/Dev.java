package com.example.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

//    Field injection
//    @Autowired
//    private Laptop laptop;

//    Constructor injection
//    public Dev(Laptop laptop) {
//        this.laptop = laptop;
//    }

//    Setter injection
//    @Autowired
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

//    Setter injection and constructor injection is good to use
//    Setter injection requires Autowired annotation but constructor doesn't as it is default injector

//    When we have the reference of an interface and 2 classes are implementing that interface
//    - There is an ambiguity in which class's object should be created
//    - For that we can either use @Primary annotation on implementing class or
//    - We can add Qualifier("name of class with first letter small")
//    - Note ===== Always Qualifier takes priority on Primary annotation

    @Autowired
    @Qualifier("laptop")
    private Computer comp;

    public void build()  {
        System.out.println("Building project...");
        this.comp.compile();
    }
}
