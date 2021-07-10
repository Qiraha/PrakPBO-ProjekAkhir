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
import javax.swing.JTextField;
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
public class addBook {
    Connector connector = new Connector();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Add Book - Nugraha Bookstore");
   
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
        
   // JButton btnEdit = new JButton("Beli Buku");
    JButton btnLihat = new JButton("Tambah");
    JButton BtnBack = new JButton("Kembali");
    JButton btnReset = new JButton("Reset");
    
    public addBook(){
        
        
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
//        window.add(lJumlah);
//        window.add(tfJumlah);
     //   window.add(btnEdit);
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
      //  lJumlah.setBounds(350, 35, 90, 20);

//TEXTFIELD
        tfNo.setBounds(110, 35, 220, 20);
        tfJudul.setBounds(110, 60, 220, 20);
        tfPengarang.setBounds(110, 85, 220, 20);
        tfPenerbit.setBounds(110, 105, 220, 20);
        tfTahun.setBounds(110, 130, 220, 20);
        tfHarga.setBounds(110, 155, 220, 20);
      //  tfJumlah.setBounds(350, 60, 120, 20);


//BUTTON PANEL
        //btnEdit.setBounds(350, 35, 90, 20);
        btnLihat.setBounds(350,35,120,20);
        BtnBack.setBounds(1,200,549,40);
        //btnReset.setBounds(350,85,90,20);
       
        
        btnLihat.addActionListener(new ActionListener() {
          
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    String query = "INSERT into `buku` VALUES ('"+getId()+"','"+getJudul()+"','"+getPengarang()+"','"+getPenerbit()+"','"+getTahun()+"','"+getHarga()+"')";
                    connector.statement = connector.koneksi.createStatement();
                    connector.statement.executeUpdate(query);

                    System.out.println("Tambah Berhasil");
                    JOptionPane.showMessageDialog(null,"Tambah Berhasil !!");
                    
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Masukkan Angka!!!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Input gagal coba ganti nomor ID!!!");
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
