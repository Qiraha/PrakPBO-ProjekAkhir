/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import JBDC.Connector;
import appBook.buyBook;
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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class editBook {
    public int gaji;
    int jmlData;
    String data[][] = new String[500][6];
   
    Connector connector = new Connector();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Edit Book - Nugraha Bookstore");
   
    JLabel lNo = new JLabel("ID  ");
        JTextField tfNo = new JTextField();
    JLabel lJudul = new JLabel("JUDUL  ");
        JTextField tfJudul = new JTextField();
    JLabel lPengarang= new JLabel("PENGARANG ");
        JTextField tfPengarang = new JTextField();
    JLabel lPenerbit = new JLabel("PENERBIT ");
        JTextField tfPenerbit = new JTextField();
    JLabel lTahun = new JLabel("TAHUN TERBIT ");
        JTextField tfTahun = new JTextField();
    JLabel lHarga = new JLabel("HARGA ");
       JTextField tfHarga = new JTextField();
    JLabel lJumlah = new JLabel("JUMLAH ");
        JTextField tfJumlah = new JTextField();
        
    JButton btnEdit = new JButton("Edit Buku");
    JButton btnLihat = new JButton("Hapus Buku");
    JButton BtnBack = new JButton("Kembali");
    JButton btnReset = new JButton("Reset");
    
    public editBook(String num){
         int x = Integer.parseInt(num);
        
        window.setLayout(null);
        window.setSize(550,270);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(lJudul);
        window.add(tfNo);
        window.add(tfJudul);
        window.add(tfPengarang);
        window.add(tfPenerbit);
        window.add(tfTahun);
        window.add(lNo);
        window.add(lPenerbit);
        window.add(lPengarang);
        window.add(lTahun);
        window.add(lHarga);
        window.add(tfHarga);
        window.add(lJumlah);
        window.add(tfJumlah);
        window.add(btnEdit);
        window.add(btnLihat);
        window.add(BtnBack);
        window.add(btnReset);



//LABEL
        lNo.setBounds(5, 35, 120, 20);
        lJudul.setBounds(5, 60, 120, 20);
        lPengarang.setBounds(5,85,120,20);
        lPenerbit.setBounds(5,105,120,20);
        lTahun.setBounds(5, 130, 120, 20);
        lHarga.setBounds(5, 155, 120, 20);
 //       lJumlah.setBounds(350, 35, 90, 20);

//TEXTFIELD
        tfNo.setBounds(110, 35, 220, 20);
        tfJudul.setBounds(110, 60, 220, 20);
        tfPengarang.setBounds(110, 85, 220, 20);
        tfPenerbit.setBounds(110, 105, 220, 20);
        tfTahun.setBounds(110, 130, 220, 20);
        tfHarga.setBounds(110, 155, 220, 20);
  //      tfJumlah.setBounds(350, 60, 120, 20);


//BUTTON PANEL
        btnEdit.setBounds(350, 35, 120, 20);
        btnLihat.setBounds(350,85,120,20);
        BtnBack.setBounds(1,200,549,40);
       btnReset.setBounds(350, 60, 120, 20);
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
           String query = "UPDATE `buku` SET `id_buku` = "+getId()+", `judul_buku` = '"+getJudul()+"', `pengarang` = '"+getPengarang()+""
                   + "', `penerbit` = '"+getPenerbit()+"' , `tahun_terbit` = '"+getTahun()+"', `harga` = '"+getHarga()+"' WHERE `buku`.`id_buku` = "+x+"";
          
           connector.statement = connector.koneksi.createStatement();
           connector.statement.executeUpdate(query);

           System.out.println("Edit Berhasil");
            JOptionPane.showMessageDialog(null,"Edit Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        btnLihat.addActionListener(new ActionListener() {
          
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                   String query = "DELETE from buku WHERE `buku`.`id_buku` = "+x+"";
          
                connector.statement = connector.koneksi.createStatement();
                connector.statement.executeUpdate(query);

                System.out.println("Hapus Berhasil");
                JOptionPane.showMessageDialog(null,"Hapus Berhasil !!");
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Masukkan Angka!!!");
                } catch (SQLException ex) {
                    Logger.getLogger(editBook.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        BtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                window.dispose();
                buyBook show = new buyBook();
            }
        });
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String res="";
                tfNo.setText(res);
                tfJudul.setText(res);
                tfPengarang.setText(res);
                tfPenerbit.setText(res);
            }
        });
       
        String query = "SELECT * from buku WHERE id_buku = "+x+"";
            
        try {
            int jmlData = 0; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("id_buku"); 
                data[jmlData][1] = resultSet.getString("judul_buku"); 
                data[jmlData][2] = resultSet.getString("pengarang");
                data[jmlData][3] = resultSet.getString("penerbit");
                data[jmlData][4] = resultSet.getString("tahun_terbit");
                data[jmlData][5] = resultSet.getString("harga");
                jmlData++; 
            }
            connector.statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
        }
        tfNo.setText(data[0][0]);
        tfJudul.setText(data[0][1]);
        tfPengarang.setText(data[0][2]);
        tfPenerbit.setText(data[0][3]);
        tfTahun.setText(data[0][4]);
        tfHarga.setText(data[0][5]);        

    }
    
   public String getJudul(){
        return tfJudul.getText();
    }

    public String getId() {
        return tfNo.getText();
    }

    public String getPengarang() {
        return tfPengarang.getText();
    }

    public String getPenerbit() {
        return tfPenerbit.getText();
    }
    
    public String getTahun() {
        return tfTahun.getText();
    }
    
    public String getHarga() {
        return tfHarga.getText();
    }
    
    public String getJumlah() {
        return tfJumlah.getText();
    }
    
    public void inputDB(){
        
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

