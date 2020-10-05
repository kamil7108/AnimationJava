/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author kamil
 */
public class Animation extends JFrame{
Animation(){
    this.setTitle("Zipper");
    this.setBounds(275, 300, 250, 250);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    panelPrzycisku.add(stop);
    panelPrzycisku.add(start);
    panelAnimacji.setBackground(Color.GRAY);
    this.getContentPane().add(panelPrzycisku,BorderLayout.SOUTH);
    this.getContentPane().add(panelAnimacji);
    stop.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            panelAnimacji.stop();
        }
    });
    start.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            panelAnimacji.addKropelka();
            
        
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
}
    public static void main(String[] args) {
        new Animation();
       
        
    }
private JPanel panelPrzycisku=new JPanel();
private PanelAnimacji panelAnimacji=new PanelAnimacji();
private JButton start=new JButton("Start");
private JButton stop=new JButton("Stop");
}

class A {}


