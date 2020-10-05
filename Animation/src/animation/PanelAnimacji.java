/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author kamil
 */
public class PanelAnimacji extends JPanel{
    
    public void addKropelka()
        {   
            listaKropelek.add(new Kropelka()); 
            
            Thread watek = new Thread(grupaWatkow,new KropelkaRunnable((Kropelka)listaKropelek.get(listaKropelek.size()-1)));
            watek.start();
           
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            
            for (int i = 0; i < listaKropelek.size(); i++)
            {
                g.drawImage(Kropelka.getImage(), ((Kropelka)listaKropelek.get(i)).getX(), ((Kropelka)listaKropelek.get(i)).getY(), null);
            }
        }

    void stop() {
        grupaWatkow.interrupt();
    }
        
        public class KropelkaRunnable implements Runnable{
        private final Kropelka kropelka;
        
        
        public KropelkaRunnable(Kropelka k) {
        kropelka=k;
        }

        
        @Override
        public void run() {
           
               
                   
                    try 
                    { while(!Thread.currentThread().isInterrupted()){
                        kropelka.move(ten);
                        repaint();
                        Thread.sleep(10);}
                    } 
                    catch (InterruptedException ex) 
                    {
                        listaKropelek.clear();
                        repaint();
                    }
                
                
            }
        }
   
        JPanel ten =this;
        ArrayList listaKropelek = new ArrayList();
        ThreadGroup grupaWatkow=new ThreadGroup("Grupa watkow");
      
       
    }

