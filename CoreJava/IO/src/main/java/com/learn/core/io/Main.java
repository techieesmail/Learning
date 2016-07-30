/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.io;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author sanghvir
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get("C:\\Users\\sanghvir\\Desktop");
        
        Files.list(path).filter(p -> Files.isDirectory(p)).forEach(System.out::println);
        
        //creating a new file
        Path p = FileSystems.getDefault().
                getPath("C:/Users/sanghvir/Desktop").resolve("testNIO.txt");
        Files.deleteIfExists(p);
        Path newFile = Files.createFile(p);
        Files.newBufferedWriter(newFile, StandardOpenOption.WRITE).
                append("Rahul is good boy").append("\t\t\t Apeksha is her wife").close();
        
        
    }
}
