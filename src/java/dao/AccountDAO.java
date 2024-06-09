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
public class AccountDAO implements Accessible<Account> {

    private ServletContext sc;
    private Connection con;

    PreparedStatement ps = null;
    ResultSet rs = null;

    private static final String SELECT_ACCOUNT_BY_ID = "select * from accounts where account =?";
    private static final String SELECT_ALL_ACCOUNT = "select * from accounts";
    
    private static final String ACCOUNT = "account";
    private static final String PASS = "pass";
    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String BIRTH_DAY = "birthday";
    private static final String GENDER = "gender";
    private static final String PHONE = "phone";
    private static final String IS_USE = "isUse";
    private static final String ROLE_IN_SYSTEM = "roleInSystem";
    

    public AccountDAO() throws ClassNotFoundException, SQLException {
        DBContext dBContext = new DBContext();
        con = dBContext.getConnection();
    }

    public AccountDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        this.sc = sc;
        con = getConnect(sc);
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
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }

    @Override
    public List<Account> listAll() {
        List<Account> accList = new ArrayList<>();
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accList;
    }

}
