package com.example.task04;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationHandler implements MessageHandler {
    private final FileHandler handler;
    private final ChronoUnit rotation;
    private LocalDateTime previosRotation;

    public RotationHandler(String path, ChronoUnit rotation){
        this.handler = new FileHandler(path);
        this.rotation = rotation;
        this.previosRotation = LocalDateTime.now();
    }

    public void handleMessage(String message){
        if (LocalDateTime.now().isAfter(previosRotation.plus(1, rotation))){
            handler.handleMessage(message);
            previosRotation = LocalDateTime.now();
        }
    }

}
