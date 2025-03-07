package org.example;

public class Desktop implements Computer {

    public Desktop() {
        System.out.println("Inside Desktop");
    }

    public void compile() {
        System.out.println("Compiling the project in desktop");
    }
}
