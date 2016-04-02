/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package com.examples.javaee.cdi.cdistandalone;


//@Dependent

public class Greeting implements IGreeting{

    public Greeting() {
            System.out.println("The value is "+this);
    }
    
    @Override
    public String greet(String name) {
        return "Hello, " + name + ".";
    }
}
