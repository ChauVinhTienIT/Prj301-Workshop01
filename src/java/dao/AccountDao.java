/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import model.Account;

/**
 *
 * @author Lenovo
 */
public class AccountDao implements Accessible<Account> {

    private ServletContext sc;
    private Connection con;

    PreparedStatement ps = null;
    ResultSet rs = null;

    private static final String SELECT_ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE account =?";
    private static final String SELECT_ALL_ACCOUNT = "SELECT * FROM accounts";
    private static final String CHECK_LOGIN = "SELECT * FROM accounts WHERE account=? AND pass=?";
    
    private static final String ACCOUNT = "account";
    private static final String PASS = "pass";
    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String BIRTH_DAY = "birthday";
    private static final String GENDER = "gender";
    private static final String PHONE = "phone";
    private static final String IS_USE = "isUse";
    private static final String ROLE_IN_SYSTEM = "roleInSystem";
    

    public AccountDao(){
    }

    public AccountDao(ServletContext sc){
        this.sc = sc;
    }
    
    private Connection getConnect() throws ClassNotFoundException, SQLException {
        DBContext dBContext = new DBContext();
        Connection conn = dBContext.getConnection();
        return conn;
    }
          

    private Connection getConnect(ServletContext sc) throws ClassNotFoundException, SQLException {
        DBContext dBContext = new DBContext(sc);
        Connection conn = dBContext.getConnection();
        return conn;
    }

    @Override
    public int insertRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getObjectById(String id) {
        Account acc = null;
        try {
            makeConnection();
            ps = con.prepareStatement(SELECT_ACCOUNT_BY_ID);
            ps.setString(1, id);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                String account = rs.getString(ACCOUNT);
                String pass = rs.getString(PASS);
                String lastName = rs.getNString(LAST_NAME);
                String firstName = rs.getNString(FIRST_NAME);
                Date birthDay = rs.getDate(BIRTH_DAY);
                boolean gender = rs.getBoolean(GENDER);
                String phone = rs.getNString(PHONE);
                boolean isUse = rs.getBoolean(IS_USE);
                int roleInSystem = rs.getInt(ROLE_IN_SYSTEM);
                
                acc = new Account(account, pass, lastName, firstName, birthDay, gender, phone, isUse, roleInSystem);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            closeConnect();
        }
        return acc;
    }

    @Override
    public List<Account> listAll() {
        List<Account> accList = new ArrayList<>();
        try {
            makeConnection();
            ps = con.prepareStatement(SELECT_ALL_ACCOUNT);
            rs = ps.executeQuery();

            while (rs.next()) {
                String account = rs.getString(ACCOUNT);
                String pass = rs.getString(PASS);
                String lastName = rs.getNString(LAST_NAME);
                String firstName = rs.getNString(FIRST_NAME);
                Date birthDay = rs.getDate(BIRTH_DAY);
                boolean gender = rs.getBoolean(GENDER);
                String phone = rs.getNString(PHONE);
                boolean isUse = rs.getBoolean(IS_USE);
                int roleInSystem = rs.getInt(ROLE_IN_SYSTEM);
                
                Account acc = new Account(account, pass, lastName, firstName, birthDay, gender, phone, isUse, roleInSystem);
                accList.add(acc);
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            closeConnect();
        }
        return accList;
    }

    
    public Account loginSuccess(String account, String password){
        Account acc = null;
        try {
            makeConnection();
            
            ps = con.prepareStatement(CHECK_LOGIN);
            ps.setString(1, account);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                String pass = rs.getString(PASS);
                String lastName = rs.getNString(LAST_NAME);
                String firstName = rs.getNString(FIRST_NAME);
                Date birthDay = rs.getDate(BIRTH_DAY);
                boolean gender = rs.getBoolean(GENDER);
                String phone = rs.getNString(PHONE);
                boolean isUse = rs.getBoolean(IS_USE);
                int roleInSystem = rs.getInt(ROLE_IN_SYSTEM);
                
                acc = new Account(account, pass, lastName, firstName, birthDay, gender, phone, isUse, roleInSystem);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            closeConnect();
        }
        
        return acc;
    }
    
    private void makeConnection() throws ClassNotFoundException, SQLException{
        if(con == null || con.isClosed()){
            con = getConnect();
        }
    }
    
    private void closeConnect(){
        try {
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
