package org.example;

public class Laptop implements Computer {

    public Laptop() {
        System.out.println("Inside Laptop");
    }

    public void compile() {
        System.out.println("Compiling the project in laptop");
    }
}
