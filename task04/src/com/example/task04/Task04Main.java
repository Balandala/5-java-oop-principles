package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger test = new Logger("test");
        Logger kto = new Logger("kto");
        test.addHandler(new ConsoleHandler());
        test.addHandler(new FileHandler());
        test.addHandler(new RotationHandler("D:\\Dev\\Labs\\5-java-oop-principles\\task04\\logs\\R", ChronoUnit.MILLIS));
        kto.addHandler(new MemoryHandler( new FileHandler(), 5));
        for (int i = 0; i < 50; i++){
        test.error("Aboba");}
    }
}
