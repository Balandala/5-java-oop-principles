package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{
    private final ArrayList<String> buffer = new ArrayList<>();
    private final int maxSize;
    private final MessageHandler handler;

    MemoryHandler(MessageHandler handler, int maxSize){
        this.maxSize = maxSize;
        this.handler = handler;
    }

    @Override
    public void handleMessage(String message) {
        if (buffer.stream().count() < maxSize){
            buffer.add(message);
        }
        else {
            for(String msg : buffer){
                handler.handleMessage(msg);
            }
            handler.handleMessage(message);
            buffer.clear();
        }
    }
}
