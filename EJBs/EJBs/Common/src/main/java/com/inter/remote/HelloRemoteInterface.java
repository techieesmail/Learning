/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inter.remote;

import com.shared.classes.SharedClass;
import javax.ejb.Remote;

/**
 *
 * @author SanghviR
 */
@Remote
public interface HelloRemoteInterface {
    public String sayHello(String name);
    public SharedClass getSharedClass();
    public void updateSharedI(int i);
}
