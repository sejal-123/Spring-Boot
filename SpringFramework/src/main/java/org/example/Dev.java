package org.example;

public class Dev {

//    private Laptop laptop;
    private Computer comp;
    private int age;

    public Dev() {
        System.out.println("Inside Dev default constructor");
    }

//    public Dev(int age) {
//        this.age = age;
//        System.out.println("Inside parameterized constructor");
//    }


//    public Dev(Laptop laptop) {
//        this.laptop = laptop;
//    }
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }


    public Dev(Computer comp) {
        this.comp = comp;
    }

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void build() {
        System.out.println("Building the project");
//        laptop.compile();
        comp.compile();
    }
}
