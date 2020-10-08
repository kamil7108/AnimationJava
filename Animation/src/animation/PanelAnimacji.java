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
    
    private volatile boolean zatrzymany=false;
    private Object lock=new Object();
      public void startAnimation() 
        {
            if(zatrzymany)
            {
                zatrzymany = false;
                synchronized(lock)
                {
                   
                    lock.notifyAll();
                }
            }
        }  
    public void addKropelka()
        {   
            listaKropelek.add(new Kropelka()); 
            watek = new Thread(grupaWatkow,new KropelkaRunnable((Kropelka)listaKropelek.get(listaKropelek.size()-1)));
            watek.start();
            grupaWatkow.list();
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

        public void stop() {
        zatrzymany=true;
        }
        
        public class KropelkaRunnable implements Runnable{
        Kropelka kropelka;
        public KropelkaRunnable(Kropelka k) {
        kropelka=k;
        }

        
        
        public void run() {
           while(true){
           synchronized(lock){
                    while(zatrzymany){
                        try {
                            lock.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }}
                    kropelka.move(ten);
                    repaint();
                    try 
                    { 
                      Thread.sleep(10);
                    } 
                    catch (InterruptedException ex) 
                    {
                        ex.printStackTrace();
                    }
                
            }
           }
         }
   
        JPanel ten =this;
        ArrayList listaKropelek = new ArrayList();
        ThreadGroup grupaWatkow=new ThreadGroup("Grupa watkow");
        Thread watek;
    }

