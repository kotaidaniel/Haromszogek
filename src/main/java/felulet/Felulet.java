package felulet;

import haromszogek.logika.DHaromszog;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Felulet extends JFrame{
    
    private JButton bttnFajlValaszto;
    private JPanel pnlHibak, pnlHaromszog, pnlAdat;
    private Container ablak;
    private List<DHaromszog> haromszogLista;
    private JFileChooser flchsr;
    
    public Felulet(){
        super();
        initComponents();
    }
    
    private void initComponents(){
        this.setTitle("Háromszög");
        
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        this.ablak = this.getContentPane();
        this.ablak.setLayout(null);
        
        /*BEGIN Adatok betöltése gomb*/
        this.bttnFajlValaszto = new JButton();
        this.bttnFajlValaszto.setText("Adatok betöltése");
        this.bttnFajlValaszto.setSize(200, 25);
        this.bttnFajlValaszto.setLocation(20,20);
        
        this.bttnFajlValaszto.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    adatokBetoltese(e);
                }
            }
        );
        
        this.ablak.add(this.bttnFajlValaszto);
        /*END Adatok betöltése gomb*/
        
        
        
        /*BEGIN Hibak Panel*/
        this.pnlHibak = new JPanel();
        this.pnlHibak.setLayout(null);
        this.pnlHibak.setLocation(20, 70);
        this.pnlHibak.setSize(500, 150);
        this.pnlHibak.setBorder(new TitledBorder("Hibák a kiválasztott állományban"));
        this.ablak.add(this.pnlHibak);
        
        /*END Hibak Panel*/
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void adatokBetoltese(ActionEvent ae){
        this.flchsr = new JFileChooser();
        if (flchsr.showDialog(this, "Fájl megnyitása") != -1){
            System.out.println(flchsr.getSelectedFile().toString());
        }
    }
    
    private void fajlBeolvas(String fajlnev){
        this.haromszogLista = new ArrayList<>();
        try{
        FileReader fr = new FileReader(fajlnev);
        BufferedReader br = new BufferedReader(fr);
        
        String sor = br.readLine();
        int i = 0;
        while(sor != null){
            try{
                DHaromszog dh = new DHaromszog(sor, ++i);
                haromszogLista.add(dh);
                sor = br.readLine();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        
        br.close();
        fr.close();
        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }catch(IOException ioe){
            System.err.println(ioe.getMessage());
        }
    }
}
