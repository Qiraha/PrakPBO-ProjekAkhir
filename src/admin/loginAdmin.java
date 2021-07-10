/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import JBDC.Connector;
import appBook.buyBook;
import appHome.Home;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class loginAdmin{
    JFrame window = new JFrame("Login Admin - Nugraha Bookstore");
   
    JLabel lNo = new JLabel("Username  ");
        JTextField tfNo = new JTextField();
    JLabel lJudul = new JLabel("Password  ");
        JTextField tfJudul = new JTextField();
    JButton BtnBack = new JButton("Kembali");    
        
        
    JButton btnLihat = new JButton("Login");

    public loginAdmin(String log){
        window.setLayout(null);
        window.setSize(350,270);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        
        window.add(lJudul);
        window.add(tfNo);
        window.add(tfJudul);
        window.add(lNo);
        window.add(btnLihat);
        window.add(BtnBack);
        
        lNo.setBounds(105, 35, 120, 20);
        lJudul.setBounds(105, 85, 120, 20);
        
        tfNo.setBounds(105, 60, 120, 20);
        tfJudul.setBounds(105, 110, 120, 20);
        
         btnLihat.setBounds(105,150,120,20);
         BtnBack.setBounds(1,200,349,40);
         
         
         
         
         btnLihat.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent arg0) {
             String user = "admin";
             String pass = "admin";
             String temp_user=getId();
             String temp_pass=getJudul();
                if(temp_user.equals(user) && temp_pass.equals(pass))
                {
                    window.dispose();
                    if( log.equals(""))
                        new addBook().setVisible(true);
                    else
                        new editBook(log).setVisible(true);
                }
                    
                else
                    JOptionPane.showMessageDialog(null,"Username atau Password Salah!!!");
            }
        });
        BtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                window.dispose();
                new Home().setVisible(true);
            }
        });
    }

    
    public String getJudul(){
        return tfJudul.getText();
    }

    public String getId() {
        return tfNo.getText();
    }
    
    
    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     

    
    
}
