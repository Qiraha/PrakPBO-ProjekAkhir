/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBook;
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
import JBDC.Connector;
import admin.editBook;
import admin.loginAdmin;
import appHome.Home;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author hp
 */
public class buyBook extends JFrame implements ActionListener{
    int jmlData;
    String data[][] = new String[500][6];
    
    Connector connector = new Connector();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("List Book - Nugraha Bookstore");
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","Judul","Pengarang","Penerbit","Tahun Terbit","Harga"}; //membuat kolom dgn array tipe object;
    JButton BtnBack = new JButton("Kembali");
    
     JLabel lNo = new JLabel("ID  ");
        JTextField tfNo = new JTextField();
    JButton Beli = new JButton("Beli");
    JButton Edit = new JButton("Edit");
    
    public buyBook(){
        window.setLayout(null);
        window.setSize(550,600);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        try{
            int jmlData = 0; 
            String query = "Select * from `buku` ORDER by judul_buku";
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
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        
        tabel = new JTable(data,namaKolom); 
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        
        scrollPane.setBounds(20, 35, 500, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        BtnBack.addActionListener(this);
        window.add(BtnBack);
        window.add(tfNo);
        window.add(lNo);
        window.add(Beli);
        window.add(Edit);
        
        lNo.setBounds(50, 350, 120, 20);
        tfNo.setBounds(110, 350, 120, 20);
        Beli.setBounds(250, 350, 90, 20);
        Edit.setBounds(250, 380, 90, 20);
        BtnBack.setBounds(1,520,549,40);
        
        
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        BtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                window.dispose();
                Home home = new Home();
            }
        });
        
        Beli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int re = 0;
                try{
                    re=0;
                boughtBook edit = new boughtBook(getNo());
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Masukkan Angka!!!");
                    re=1;
                }
                if(re!=1)
                    window.dispose();
                
            }
        });
        Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int re = 0;
                try{
                    re=0;
                loginAdmin edit = new loginAdmin(getNo());
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Masukkan Angka!!!");
                    re=1;
                }
                if(re!=1)
                    window.dispose();
                
            }
        });
    }

    
    
    
    public String getNo() {
        return tfNo.getText();
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
