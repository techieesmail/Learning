/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.ejb;

import com.inter.remote.HelloRemoteInterface;
import com.shared.classes.SharedClass;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Remote;

/**
 *
 * @author martin
 */
@Stateless(mappedName = "adp:mt:comp/Hello")
//@Stateless()
@Remote(HelloRemoteInterface.class)
@LocalBean
public class HelloBusinessImpl implements HelloRemoteInterface{

    public SharedClass s = new SharedClass();
    public void businessMethod() {
        System.out.println("Business method not exposed ");
    }

    @Override
    public String sayHello(String name) {
        return "Hello Sir/Madam "+name;
    }

    @Override
    public SharedClass getSharedClass() {
        return this.s;
    }

    @Override
    public void updateSharedI(int i) {
        s.i = i;
    }

    

}
