/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thejavageek.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author SanghviR
 */
//@Entity
public abstract class GeneratorClass {
    
    //@SequenceGenerator(name = "seq_gen" ,sequenceName = "ID_SEQ" ,allocationSize = 1)
    private long sequenceGenerator;
}
