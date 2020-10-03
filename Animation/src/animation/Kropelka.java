/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author kamil
 */
public class Kropelka {
    public Kropelka(){}
    public Kropelka(int x,int y,int dx, int dy){
    this.x=x;
    this.y=y;
    this.dx=dx;
    this.dy=dy;
    }
    public static Image  getImage(){return image;}
    public int getX(){return x;}
    public int getY(){return y;}
    
    public void move(JPanel pojemnik){
    int maxX=pojemnik.getBounds().width;
    int maxY=pojemnik.getBounds().height;
    
    x +=dx;
    y +=dy;
    
    if(x>=maxX){
    x=maxX;
    dx=-dx;
    }
    else if(x<=0){
    x=0;
    dx=-dx;
    }
    if(y>=maxY){
    y=maxY;
    dy=-dy;
    }
    else if(y<=0){
    y=0;
    dy=-dy;
    }
    }
    
    private static final Image image= new ImageIcon("kropelka.gif").getImage();
    private int x=0;
    private int y=0;
    private int dx=1;
    private int dy=1;
    private int imageW=6;
    private int imageH=6;
}

