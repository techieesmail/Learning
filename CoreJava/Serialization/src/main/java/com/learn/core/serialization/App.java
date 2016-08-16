/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author SanghviR
 */
//Serialization stores data in binary format.
public class App {

    //private static StaticInnerClass staticInnerClass;
    private int i = 10;

    public static void main(String[] args) throws Exception {

        File f = new File("C:\\Users\\sanghvir\\Desktop\\test.ser");

        //App.StaticInnerClass s = new App.StaticInnerClass();
        //serialize(f);
        //deserialze(f);
        
        
        ChildClass c = new ChildClass();
        System.out.println("The hashcode of child is "+c.hashCode());
        //System.out.println(c.method1(10, 20));
        c.method1(10, 20);
        
//        ChildClass.InnerClass inner = c.new InnerClass();
//        
//        inner.testMethod();
        c.parent = 100;
        c.m.put(1, "Rahul");
        c.rc.sayHelloFromRegularClass();
        Path path = Paths.get("C:\\Users\\sanghvir\\Desktop\\test.ser");
        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE));
        System.out.println("Writing object using standard write method ");
        out.writeObject(c);
        System.out.println("After standard method ");
        out.close();
        
        System.out.println("Serialization done ");
        
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path, StandardOpenOption.READ));
        ChildClass cc  = (ChildClass)in.readObject();
        System.out.println("The hashcode of child after deserialization  "+cc.hashCode());
        System.out.println("I am done and the value of i is "+cc.parent);
        System.out.println("The value from map is "+cc.m.get(1));
        
        //Deleting the file
        
        Files.delete(path);

    }

    static void serialize(File f) throws Exception {
        Test t = new Test();
        t.setId(10);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));

        out.writeObject(t);
        out.close();
    }

    static void deserialze(File f) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Test tt = (Test) in.readObject();

        System.out.println(tt.getId());
    }

//    static class StaticInnerClass{
//
//        public StaticInnerClass() {
//        }
//            
//            
//        static void innerClassMeth(String s){
//            
//            System.out.println(s);
//        }
//        
//        void nonStaticMethod(){
//            System.out.println("Inside non static method ");
//        }
//    }
//    
//
//    
//    private class InnerClass{
//        void innerClassMeth(){
//            System.out.println(i);
//        }
//    }
//     public void method(){
//       InnerClass c = new InnerClass();
//        
//    }
}

class Test implements Serializable {

    Test() {
        System.out.println("Constructor called ");
    }
    private static final long serialVersionUID = 1L;
    private int id;

    public static int delVar = 100;
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
