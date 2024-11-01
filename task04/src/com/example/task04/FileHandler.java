package com.example.task04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;

public class FileHandler implements MessageHandler {
    private File file;

    FileHandler(String path){
        setFile(path);
    }
    FileHandler(){
        setFile( "D:\\Dev\\Labs\\5-java-oop-principles\\task04\\logs\\");
    }

    private void setFile(String path){
        path += java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu.MM.dd")) + "Log.txt";
        File file = new File(path);
        try {file.createNewFile();}
        catch (Exception e){;}
        this.file = file;
    }

    @Override
    public void handleMessage(String message){
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(message + "\n");
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
