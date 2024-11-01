package com.example.task01;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static final List<Logger> loggers = new ArrayList<>();
    private final String name;
    private Levels level;

    Logger (String name){
        this.name = name;
        loggers.add(this);
    }

    public static Logger getLogger(String name){
        //Logger logger = loggers.stream().filter(l -> l.name == name).findFirst().get();
        for (Logger logger : loggers){
            if (logger.name.equals(name))
                return logger;
        }
        return  new Logger(name);
    }

    public String getName(){
        return this.name;
    }

    public void setLevel(Levels level){
        this.level = level;
    }
    public Levels getLevel(){
        return this.level;
    }


    private String makeLog(Levels level){
        java.time.LocalDate localDate = java.time.LocalDate.now();
        String localTime = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return  String.format("[%s] %s %s %s - ", level, localDate, localTime, this.name);
    }

    public void error(String message){
        Levels level = Levels.ERROR;
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + message);
   }
    public void error(String format, Object... args){
        Levels level = Levels.ERROR;
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + String.format(format, args));
    }

    public void warning(String message){
        Levels level = Levels.WARNING;
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + message);
    }
    public void warning(String format, Object... args){
        Levels level = Levels.WARNING;
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + String.format(format, args));
    }

    public void info(String message){
        Levels level = Levels.INFO;
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + message);
    }
    public void info(String format, Object... args){
        Levels level = Levels.INFO;
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + String.format(format, args));
    }

    public void debug(String message){
        Levels level = Levels.DEBUG;
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + message);
    }
    public void debug(String format, Object... args){
        Levels level = Levels.DEBUG;
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + String.format(format, args));
    }


    public void log(Levels level, String message){
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + message);
    }
    public void log(Levels level, String format, Object... args){
        if (level.ordinal() >= this.level.ordinal() )
            System.out.println(makeLog(level) + String.format(format, args));
    }

}
enum Levels{
    DEBUG,
    INFO,
    WARNING,
    ERROR
}
