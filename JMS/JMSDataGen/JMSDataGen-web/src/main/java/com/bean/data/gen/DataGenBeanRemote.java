/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bean.data.gen;


import javax.ejb.Remote;

/**
 *
 * @author Family
 */
@Remote
public interface DataGenBeanRemote {

    public String insertData(String name, Double amount,String destination);
    
}
