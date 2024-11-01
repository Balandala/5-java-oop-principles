package com.example.task04;



import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static final List<Logger> loggers = new ArrayList<>();
    private final List<MessageHandler> handlers = new ArrayList<>();
    private final String name;
    private Levels level = Levels.DEBUG;

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

    public void addHandler(MessageHandler handler){
        handlers.add(handler);
    }
    public void removeHandler(MessageHandler handler){
        handlers.remove(handler);
    }

    private String makeLog(Levels level){
        java.time.LocalDate localDate = java.time.LocalDate.now();
        String localTime = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return  String.format("[%s] %s %s %s - ", level, localDate, localTime, this.name);
    }


    public void log(Levels level, String message){
        if (level.ordinal() >= this.level.ordinal() ) {
            String log = makeLog(level) + message;
            for (MessageHandler handler : handlers){
                handler.handleMessage(log);
            }
        }
    }
    public void log(Levels level, String format, Object... args){
        if (level.ordinal() >= this.level.ordinal() ) {
            String log = makeLog(level) + String.format(format, args);
            for (MessageHandler handler : handlers){
                handler.handleMessage(log);
            }
        }
    }


    public void error(String message){
        log(Levels.ERROR, message);
   }
    public void error(String format, Object... args){
        log(Levels.ERROR, format, args);
    }

    public void warning(String message){
        log(Levels.WARNING, message);
    }
    public void warning(String format, Object... args){
        log(Levels.WARNING, format, args);
    }

    public void info(String message){
        log(Levels.INFO, message);
    }
    public void info(String format, Object... args){
        log(Levels.INFO, format, args);
    }

    public void debug(String message){
        log(Levels.DEBUG, message);
    }
    public void debug(String format, Object... args){
        log(Levels.DEBUG, format, args);
    }

}
enum Levels{
    DEBUG,
    INFO,
    WARNING,
    ERROR
}
