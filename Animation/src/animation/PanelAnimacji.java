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
            for (int i = 0; i < 25; i++)
            {
                for(int j = 0; j < listaKropelek.size(); j++)
                {
                    ((Kropelka)listaKropelek.get(j)).move(this);
                    this.paint(this.getGraphics());
                    try 
                    {
                        Thread.sleep(10);
                    } 
                    catch (InterruptedException ex) 
                    {
                        System.out.println(ex.getMessage());
                    }
                }
                
            }
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
        ArrayList listaKropelek = new ArrayList();
    }

