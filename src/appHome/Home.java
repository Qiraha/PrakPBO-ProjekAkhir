/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appHome;

import admin.loginAdmin;
import appBook.buyBook;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author hp
 */
public class Home extends JFrame implements ActionListener{

    JFrame window = new JFrame("Home - Nugraha Bookstore");
   
     JButton buyBook = new JButton("Beli buku");
     JButton addBook = new JButton("Tambah Buku");
     
     
     public Home(){
        window.setLayout(null);
        window.setSize(350,240);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
      
        buyBook.addActionListener(this);
        addBook.addActionListener(this);
         window.add(buyBook);
         window.add(addBook);
         
         buyBook.setBounds(1,1,349,100);
         addBook.setBounds(1,100,349,100);
         
         
         window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buyBook){
            window.dispose();
            window.setVisible(false);
            new buyBook().setVisible(true);
        }
        if(e.getSource()==addBook){
            window.dispose();
            String x = "";
           new loginAdmin(x).setVisible(true);
        }
    }
}
