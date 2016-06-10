/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.ejb;

import com.inter.remote.HelloRemoteInterface;
import com.learn.ejb.dbejb.H2DBSessionBean;
import com.learn.ejb.dbejb.OracleSessionBean;
import com.shared.classes.ExecClass;
import com.shared.classes.SharedClass;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.transaction.TransactionSynchronizationRegistry;

/**
 *
 * @author martin
 */
@Stateless(mappedName = "adp:mt:comp/Hello")
//@Stateless()
@Remote(HelloRemoteInterface.class)
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)

public class HelloBusinessImpl implements HelloRemoteInterface {

    @Resource
    private EJBContext ejbCtx;

    @Resource
    TransactionSynchronizationRegistry txReg;

    //private XADataSource dataSource;
    
    private DataSource dataSource;

    private Connection connection;
    
    @Resource
    private SessionContext sessionContext;
    
    
    public SharedClass s = new SharedClass();

    public void businessMethod() {
        System.out.println("Business method not exposed ");
    }

    @Override
    public String sayHello(String name) {
        return "Hello Sir/Madam " + name;
    }

    @Override
    public SharedClass getSharedClass() {
        System.out.println("The shared class hashcode in impl "+s.hashCode());
        return this.s;
    }

    @Override
    public void updateSharedI(int i) {
        System.err.println("The transaction obj in update shared  " + txReg.getTransactionStatus());
        s.i = i;
    }

    public ExecClass getExecClass(){
        return new ExecClass();
    }
    @PostConstruct
    public void createH2Datasource() {
        try {
//            JdbcDataSource ds = new JdbcDataSource();
//            ds.setUrl("jdbc:h2:tcp://localhost//C:/Softwares/H2Database/DB/jpa");
            
            //Deploying on weblogic
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/h2");
            System.out.println("Context look up for datasource done ");
            //ctx.bind("jdbc/h2", ds);
            this.dataSource = ds;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void closeConnections() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void insertRecordDB() {
        try {
            //System.out.println("The transaction value "+sessionContext.getUserTransaction().getStatus());
            System.err.println("The transaction obj " + txReg.getTransactionKey());
            System.err.println("The transaction received from client is "
                    + txReg.getTransactionStatus());
            //CREATE TABLE EJB_TABLE( TESTSTRING VARCHAR2(1000));

            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO JPA_TABLE VALUES ('HI 123 FROM EJB STATELESS BEAN')");
            System.out.println("After executing update statement");
            //connection.commit();
            //st.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void createConnections() {
        try {
            //Connection connection = dataSource.getXAConnection().getConnection();
            Connection connection = dataSource.getConnection();
            this.connection = connection;
            connection.setAutoCommit(false);
            System.out.println("The autocommit values is "+connection.getAutoCommit());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
    
    //Accessing other beans
    @EJB(beanName = "h2hdbBean")
    private H2DBSessionBean h2bean;
    
    @EJB(beanName = "oraDBBean")
    private OracleSessionBean oraBean;
    
    
    public void insertIntoMultipleDBs() throws RuntimeException{
        try{
            h2bean.insertRecordsDB();
            oraBean.insertRecordsDB();
            
            //ejbCtx.setRollbackOnly();
        }catch(Exception e){
            System.err.println("Exception occured while inserting into multiple DBs ");
            throw new RuntimeException(e);
        }finally{
            try {
               h2bean.closeConnections();
               oraBean.closeConnections();
            } catch (Exception e) {
                System.err.println("Exception occured while closing connections ");
                throw new RuntimeException(e);
            }
        }
        
    }
    
    
}
