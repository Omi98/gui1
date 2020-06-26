/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myatm;


import java.sql.*;

/**
 *
 * @author omamakhan
 */

public class DbHelper 
{
    private static final String FILE = ".\\assets\\bc160400533.accdb";
    
       
    private static int id;
    private static String userName;
    private static String cardNum;
    private static String pin;
    private static long balance;
    
    // var to check login success
    private static int loginSuccess;
    
    // getter of login success
    public int getLoginSuccess()
    {
        return loginSuccess;
    }
    
       
    // rest of the getters of member vars
    public int getId()
    {
        return id;
    }
    public String getUserName()
    {
        return userName;
    }
    public String getcardNum()
    {
        return cardNum;
    }
    public String getPin()
    {
        return pin;
    }
    public long getBalance()
    {
        return balance;
    }

    
    // setters of member vars
    public void setCardNum(String cN)
    {
        cardNum = cN;
    }
    
    public void setPin(String p)
    {
        pin = p;
    }
    
    public void setBalance(long b)
    {
        balance = b;
    }
    
    public DbHelper(String cN, String p) 
    {
        try
        {
            // load driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // define connection URL
            String url = "jdbc:ucanaccess://" + FILE;
            
            // establish the connection
            Connection con = DriverManager.getConnection(url);
            
            // create statement
            Statement st = con.createStatement();
            
            // prepare and execute the query
            String sql = "SELECT * FROM Users";
            ResultSet rs = st.executeQuery(sql);
            
            
            // process the results
            while(rs.next())
            {
                /*
                if cardNum from the main class and pin code from the main class
                matches the data in the database
                
                set loginSuccess = 1
                */
                if((cN.equals(rs.getString("CardNo"))) && 
                (p.equals(rs.getString("PinCode"))))
               {
                   id = Integer.parseInt(rs.getString("ID"));
                   userName = rs.getString("UserName");
                   cardNum = rs.getString("CardNo");
                   pin = rs.getString("PinCode");
                   balance = Long.parseLong(rs.getString("Balance"));

                   loginSuccess = 1;

                   break;
                
               }
            }
            
            // close the connection
            con.close();

        }
        catch (Exception sqlEx)
        {
            System.out.println(sqlEx);
        }
    }
    
    public void saveData()
    {
        try
        {
            // load driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // define connection URL
            String url = "jdbc:ucanaccess://" + FILE;
            
            // establish the connection
            Connection con = DriverManager.getConnection(url);
            
            // create statement
            Statement st = con.createStatement();
            
            // prepare and execute the query
            String sql = "UPDATE Users SET Balance = '" + balance + "' WHERE CardNo = '" + cardNum + "'";
            
            st.executeUpdate(sql);         
                       
            
            // close the connection
            con.close();

        }
        catch (Exception sqlEx)
        {
            System.out.println(sqlEx);
        }
    }

}
