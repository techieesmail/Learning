/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.ejb.dbejb;

import java.sql.Connection;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.sql.DataSource;

/**
 *
 * @author martin
 */
@Stateless(name = "h2hdbBean")
@LocalBean
public class H2DBSessionBean {

    @Resource(lookup = "jdbc/h2")
    private DataSource datasource;
    
    private Connection connection;
    
    public void insertRecordsDB()throws Exception{
        connection = datasource.getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO JPA_TABLE VALUES ('VALUE COMMING FROM H2Session Bean') ");
        //connection.commit();
    }
    
    public void closeConnections()throws Exception{
        connection.close();
    }

}
