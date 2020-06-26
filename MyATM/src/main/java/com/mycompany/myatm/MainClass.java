/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myatm;

/**
 *
 * @author omamakhan
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainClass 
{

    private static JFrame frame;
    private static JPanel panel1, panel2;
    private static JLabel label1, label2;
    private static JTextField text1;

    private static JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;

    // data members declaration
    private static int id;
    private static String userName;
    private static String cardNum;
    private static String pin;
    private static long balance;
    private static String option; // select option of what user wants to do after logging in
    private static int da; // deposit amount
    private static int wa; // withdraw amount

    // var to check login success
    private static int loginSuccess;

    //  constructor of main class
    public MainClass() 
    {
        id = 0;
        userName = null;
        cardNum = null;
        pin = null;
        balance = 0;
        option = null;
        da = 0;
        wa = 0;
    }

    // getters of all data members of MainClass()
    public int getId() 
    {
        return id;
    }

    public String getUserName() 
    {
        return userName;
    }

    public String getCardNum() 
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

    

    
    // main function starts here
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub		

        // frame and panel
        frame = new JFrame("My ATM");
        panel1 = new JPanel(new GridLayout(4, 1));
        /*
        - making a grid ... 
          4 rows...1 col
        first row: label "My ATM"
        second row: label of instructions from ATM
        third row: text box that takes user input
        fourth row: a new grid of buttons (4 rows...3 cols)
        */

        // frame settings
        frame.setSize(600, 700);
        frame.add(panel1);
        
        /*
        on close... 
                   - show message dialog for developer info
        function => windowListener
        */
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "<HTML>Developer Information:<br>"
                        + "Omama Khan<br>" + "BC160400533<br></HTML>");
            }
        });
        
        /*
        --- if you dont want to show the message dialog... 
            remove the above addWindowListener block of code
            and add this line
            => frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
        

        // first row: label "My ATM"
        label1 = new JLabel("My ATM");
        panel1.add(label1);

        // second row: label of instructions from ATM
        label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.WHITE);
        label2.setText("Please enter your card number and press 'OK' to confirm.");
        panel1.add(label2);

        // third row: text box that takes user input
        text1 = new JTextField();
        text1.setOpaque(true);
        panel1.add(text1);

        // fourth row: a new grid of buttons (4 rows...3 cols)
        // numeric keypad buttons 
        panel2 = new JPanel(new GridLayout(4, 3)); // (new GridLayout(4, 3));

        // creating new buttons 
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b10 = new JButton("OK");
        b11 = new JButton("0");
        b12 = new JButton("Cancel");

        // adding buttons to panel2
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        panel2.add(b4);
        panel2.add(b5);
        panel2.add(b6);
        panel2.add(b7);
        panel2.add(b8);
        panel2.add(b9);
        panel2.add(b10);
        panel2.add(b11);
        panel2.add(b12);

        // adding panel2 to main panel1
        panel1.add(panel2);

        // setting cardNum and pin to null before any button is clicked
        cardNum = null;
        pin = null;

        // adding action methods to all buttons
        b1.addActionListener(new Action());
        b2.addActionListener(new Action());
        b3.addActionListener(new Action());
        b4.addActionListener(new Action());
        b5.addActionListener(new Action());
        b6.addActionListener(new Action());
        b7.addActionListener(new Action());
        b8.addActionListener(new Action());
        b9.addActionListener(new Action());
        b10.addActionListener(new Action());
        b11.addActionListener(new Action());
        b12.addActionListener(new Action());

        frame.setVisible(true);
    }

    /*
    method of setting second row text to default instructions
    every time the method is called
    */
    public static void mainScreen() 
    {
        label2.setText("<html>Welcome<br>"
                + "Please enter<br>"
                + " 1 for 'Deposit Amount'<br>"
                + " 2 for 'Cash Withdraw'<br>"
                + " 3 for 'Check Balance'<br>"
                + "and press 'OK' to confirm</html>");
    }

    
    /*
    the buttons clicked... 
    getting the source of which button is clicked
    */
    static class Action implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            // TODO Auto-generated method stub

            // adding button click entries to text field (all buttons one by one)
            /*
			 * to check which button is clicked 
			 * use "getSource()" method
             */
            if (e.getSource() == b1) 
            {
                text1.setText(text1.getText() + "1");
            }
            if (e.getSource() == b2) 
            {
                text1.setText(text1.getText() + "2");
            }
            if (e.getSource() == b3) 
            {
                text1.setText(text1.getText() + "3");
            }
            if (e.getSource() == b4) 
            {
                text1.setText(text1.getText() + "4");
            }
            if (e.getSource() == b5)
            {
                text1.setText(text1.getText() + "5");
            }
            if (e.getSource() == b6) 
            {
                text1.setText(text1.getText() + "6");
            }
            if (e.getSource() == b7) 
            {
                text1.setText(text1.getText() + "7");
            }
            if (e.getSource() == b8) 
            {
                text1.setText(text1.getText() + "8");
            }
            if (e.getSource() == b9) 
            {
                text1.setText(text1.getText() + "9");
            }
            if (e.getSource() == b11) 
            {
                text1.setText(text1.getText() + "0");
            }


            /*
		* if 'Cancel' is clicked
		* - set text field to null
		* - set card num to null
		* - set pin to null
		* - show default enter card num msg on label2
            NOTE: whenever calcel is clicked........ 
                  the program will automatically come back to the label
                  asking for cardNum
             */
            if (e.getSource() == b12) 
            {
                text1.setText(null);
                cardNum = null;
                pin = null;
                balance = 0;
                option = null;
                da = 0;
                wa = 0;
                label2.setText("Please enter your card number and press 'OK' to confirm.");
            }

            
            /* if 'OK' is clicked... (after entering text to text field)
			 * check
                            - if cardNum is empty
                            - else if cardNum is not empty but pin is empty
                            - else (cardNum and pin both are not empty
			 * if the var cardNum is empty
			 *  - store the text filed entry in cardNum
			 * else
			 *  - store it in pin
             */
            if (e.getSource() == b10) 
            {
                if (cardNum == null) 
                {
                    /*
                    if cardNum is empty
                        - the text entered by the user should be stored in cardNum var
                    AND - clear text box
                        - change label to new instruction
                    */
                    cardNum = text1.getText();
                    text1.setText(null);
                    label2.setText("Please enter your pin code and press 'OK' to confirm.");
                } 
                else if ((cardNum != null) && (pin == null)) 
                {
                    /*
                    if cardNum is not empty but pin is empty
                        - store the entered text in pin var
                    AND - clear text
                    
                    NEXT: * send cardNum and this pin to DbHelper class
                          * check if the data from database matches with the entry
                          * take that result ans as var loginSuccess
                    */
                    pin = text1.getText();
                    text1.setText(null);

                    // creating object of dbHelper class
                    DbHelper d1;

                    d1 = new DbHelper(cardNum, pin);

                    // accessing the login success var value from dpHelper
                    loginSuccess = d1.getLoginSuccess();
                    
                    /*
                    if the value of loginSuccess is 1
                        - successful login (show message)
                        - get the balance data of this person from database
                          through DbHelper class
                        - show default instructions on label field
                    */
                    if (loginSuccess == 1) 
                    {
                        // assign all the data vars the values from dbHelper
                        // userName = d1.getUserName();
                        JOptionPane.showMessageDialog(null, "Login Successful!");
                        balance = d1.getBalance();
                        
                        /*
                        NOTE: now both cardNum and pin are not null
                              so program flow will go to last else statement
                        */
                        mainScreen();
                    } 
                    else // if (loginSuccess == 0) 
                    {
                        /*
                        If login is not successful
                            . set text = null
                            . set card num = null
                            . set pin = null
                        - show message of invalid data
                        - set label to first instruction of asking for cardNum
                        NOTE: setting cardNum and pin equal to null will
                              automatically take the program flow back to first
                              if condition.
                         */
                        JOptionPane.showMessageDialog(null, "Invalid Card No or Wrong Pin Code");
                        text1.setText(null);
                        cardNum = null;
                        pin = null;
                        label2.setText("Please enter your card number and press 'OK' to confirm.");
                    }
                } 
                else // if(cardNum != null && pin != null)
                {
                    /*
                    running this loop?
                    means the user has successfully logged in
                    
                    and mainScreen() function has already shown him the options
                    of what he can do
                    
                    Please enter
                        1 for 'Deposit Amount'
                        2 for 'Cash Withdraw'
                        3 for 'Check Balance'
                        and press 'OK' to confirm
                    
                    da for deposit amount option var
                    wa for withdraw amount option var
                    
                    NOW - get the text of which option user selects
                    
                        - If the option var is null 
                            * get the text from user
                            * clear the text box
                        - else if the option var is not null but da is null
                            * the user might have selected the deposit option
                        - else if the option var is not null but wa is null
                            * the user might have selected the withdraw option
                    */
                    if (option == null) 
                    {
                        option = text1.getText();
                        text1.setText(null);
                    } 
                    else if (option != null && da == 0) 
                    {
                        da = Integer.parseInt(text1.getText());
                    } 
                    else 
                    {
                        if (option != null && wa == 0) 
                        {
                            wa = Integer.parseInt(text1.getText());
                        }
                    }

                    /*
                    if option is 1 => deposit amount
                        - ask user how much amount is to be deposited
                        --- make sure the amount is a multiple of 500
                        --- make sure the amount is less than or equal to 25000
                      * if above checks are satisfied... deposit the entered amount
                        - use DbHelper class to update the balance to new balance
                    */
                    if (option.equals("1")) 
                    {
                        label2.setText("<html>Please enter amount to deposit and press 'OK' to confrim.<br>"
                                + "(NOTE: Amount must be in multiples of 500 and upto a maximum of Rs. 25000/- per transaction.)<br></html>");

                        if (da != 0) 
                        {
                            if (da % 500 != 0) 
                            {
                                JOptionPane.showMessageDialog(null, "Amount must be multiple of 500");
                                da = 0;
                            } 
                            else if (da >= 25001) 
                            {
                                JOptionPane.showMessageDialog(null, "Amount must be less than 25000/-");
                                da = 0;
                            } 
                            else 
                            {
                                JOptionPane.showMessageDialog(null, "An amount of " + da + "/- has been deposited to your account.");
                                
                                /*
                                    - update balance var
                                    - set da var back to 0
                                    - clear text box
                                    - clear value for option var
                                    - show the default instructions
                                */
                                balance = balance + da;
                                da = 0;
                                option = null;
                                text1.setText(null);
                                mainScreen();
          
                                // creating object of dbHelper class
                                DbHelper d2;

                                d2 = new DbHelper(cardNum, pin);
                                d2.setBalance(balance);
                                d2.setCardNum(cardNum); 
                                // update the cardNum of DbHelper class 
                                //(in case the current user wants to confirm the updated balance)

                                d2.saveData(); // call to saveData() function of DbHelper class
                            }
                        }

                    } 
                    else if (option.equals("2")) 
                    {
                        /*
                        else if option is 2 => withdraw amount
                            - ask user how much amount is to be withdrawn
                            --- make sure the amount is a multiple of 500
                            --- make sure the amount is less than or equal to 25000
                          * if above checks are satisfied... withdraw the entered amount
                            - use DbHelper class to update the balance to new balance
                        */
                        
                        label2.setText("<html>Please enter amount to withdraw and press 'OK' to confrim.<br>"
                                + "(NOTE: Amount must be in multiples of 500 and upto a maximum of Rs. 25000/- per transaction.)<br></html>");

                        if (wa != 0) 
                        {
                            if (wa % 500 != 0) 
                            {
                                JOptionPane.showMessageDialog(null, "Amount must be multiple of 500");
                                wa = 0;
                            } 
                            else if (wa >= 25001) 
                            {
                                JOptionPane.showMessageDialog(null, "Amount must be less than 25000/-");
                                wa = 0;
                            } 
                            else 
                            {
                                JOptionPane.showMessageDialog(null, "An amount of " + wa + "/- has been waithdrawn from your account.");
                                balance = balance - wa;
                                wa = 0;
                                option = null;
                                text1.setText(null);
                                mainScreen();

                                // creating object of dbHelper class
                                DbHelper d2;

                                d2 = new DbHelper(cardNum, pin);
                                d2.setBalance(balance);
                                d2.setCardNum(cardNum);

                                d2.saveData();
                            }
                        }
                    } 
                    else if (option.equals("3")) 
                    {
                        /*
                        option 3 => check balance
                        since the balance var is already updated to the newest value
                        simple display it
                        */
                       
                        label2.setText("<html>Your current balance is " + balance + ".<br>" 
                                + "Would you like to carry out another transaction?<br>" 
                                + "Press 'OK' to confirm and 'Cancel' to discard.<br></html>");
                        
                        option = null;                               
                                

                    } 
                    else 
                    {
                        /*
                        if any other number is clicked ... 
                        show main screen of options ... 
                        and also show pop up message to choose from the given options
                        */
                        JOptionPane.showMessageDialog(null, "Please select one of the given options");
                        option = null;
                        mainScreen();
                    }
                }
            }
        }
    }
}
