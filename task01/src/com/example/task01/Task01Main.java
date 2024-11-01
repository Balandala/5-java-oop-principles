package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger boba = new Logger("Boba");
        Logger test = new Logger("test");
        test.setLevel(Levels.ERROR);
        test.warning("aaa");
        Logger.getLogger("test");
    }
}
