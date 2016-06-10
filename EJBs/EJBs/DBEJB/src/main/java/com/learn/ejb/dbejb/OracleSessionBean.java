/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.ejb.dbejb;

import java.sql.Connection;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author sanghvir
 */
@Stateless(name = "oraDBBean")
@LocalBean
public class OracleSessionBean {

    @Resource(lookup = "jdbc/ora")
    private DataSource datasource;

    private Connection connection;

    public void insertRecordsDB() throws Exception {
        System.err.println("    Hey            ");
        connection = datasource.getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO TEST VALUES ('VALUE COMMING FROM ORACLE Bean') ");
        System.err.println("    Hey    BBBBBBBBBBBBBBBBBB       ");
        throw new Exception("MyException");
    }

    public void closeConnections() throws Exception{
        connection.close();
    }
}
