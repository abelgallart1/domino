/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author abel
 */
public class Ficha extends JPanel implements Serializable {
   public int e1,e2;
   JButton b1;JButton b2;
   boolean visible=false;
   boolean horizontal=true;
   int x,y,fx,fy;
    ArrayList fichas;
    Random ramdon;
    
    boolean seleccionada;
    int punta;
    public static int tamaño=40;
   
   
   
    public Ficha(int e1,int e2,ArrayList fichas){
    
    ramdon=new Random();
     visible=false;
    seleccionada=false;
    this.e1=e1;this.e2=e2;
    this.fichas=fichas;
    b1=new JButton();
    b2=new JButton();
       
   setSize(new java.awt.Dimension(tamaño*2, tamaño));
   setLayout(new java.awt.GridLayout(1, 2));

   //b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e1+".png"))); // NOI18N
   b1.setBackground(Color.BLACK);
   b1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
   b1.setFocusPainted(false);
   b1.setFocusable(false);
   b1.setMaximumSize(new java.awt.Dimension(tamaño,tamaño));
   b1.setMinimumSize(new java.awt.Dimension(tamaño,tamaño));
   b1.setPreferredSize(new java.awt.Dimension(tamaño,tamaño));
   add(b1);

   //b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e2+".png"))); // NOI18N
   b2.setBackground(Color.BLACK);
   b2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
   b2.setFocusPainted(false);
   b2.setFocusable(false);
   b2.setMaximumSize(new java.awt.Dimension(tamaño,tamaño));
   b2.setMinimumSize(new java.awt.Dimension(tamaño,tamaño));
   b2.setPreferredSize(new java.awt.Dimension(tamaño,tamaño));
   add(b2);
   
   fx=1;fy=1;
   b1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {punta=e1;seleccionada=true;}
           public void mouseMoved(java.awt.event.MouseEvent evt) {}
            });
   b2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
           public void mouseDragged(java.awt.event.MouseEvent evt) {punta=e2;seleccionada=true;}
          public void mouseMoved(java.awt.event.MouseEvent evt) {}
            });
   
    
                                     
        // TODO add your handling co
    
    fichas.add(this);
    
   }
    
    public String toString(){return e1+","+e2;}
   
    public void seleccionada(boolean s){ seleccionada=s;}
    public boolean seleccionada(){return seleccionada;}
    
    public boolean equals(Object x){
    if (!(x instanceof Ficha))  return false;   
    Ficha f=(Ficha)x;
    if ((e1==f.e1&&e2==f.e2)
             ||
        (e1==f.e2&&e2==f.e1))   return true;
    return false;
     }
  
         
   // public void arrastre(java.awt.event.MouseEvent evt){ 
     
   public boolean esDoble(){return e1==e2;}
   
    public void invierte(){
    b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e2+".png")));
    b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e1+".png")));
    int temp=e1;
    e1=e2;
    e2=temp;
    validate();
    }
    
   public void gira(){
   if (horizontal)
   {
   setSize(new java.awt.Dimension(tamaño, tamaño*2));
   setLayout(new java.awt.GridLayout(2, 1));

   if (visible)
   b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e1+".png"))); // NOI18N
   b1.setBackground(Color.BLACK);
   
   b1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
   b1.setFocusPainted(false);
   b1.setFocusable(false);
   b1.setMaximumSize(new java.awt.Dimension(tamaño,tamaño));
   b1.setMinimumSize(new java.awt.Dimension(tamaño,tamaño));
   b1.setPreferredSize(new java.awt.Dimension(tamaño,tamaño));
   add(b1);
    
   if(visible)
   b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e2+".png"))); // NOI18N
   else b2.setBackground(Color.BLACK);
   b2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
   b2.setFocusPainted(false);
   b2.setFocusable(false);
   b2.setMaximumSize(new java.awt.Dimension(tamaño,tamaño));
   b2.setMinimumSize(new java.awt.Dimension(tamaño,tamaño));
   b2.setPreferredSize(new java.awt.Dimension(tamaño, tamaño));
   add(b2);
   horizontal=false;
   }
   else{setSize(new java.awt.Dimension(tamaño,tamaño));
   setLayout(new java.awt.GridLayout(1,2));

   if (visible)
   b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e1+".png"))); // NOI18N
   else b1.setBackground(Color.BLACK);
   b1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
   b1.setFocusPainted(false);
   b1.setFocusable(false);
   b1.setMaximumSize(new java.awt.Dimension(tamaño,tamaño));
   b1.setMinimumSize(new java.awt.Dimension(tamaño,tamaño));
   b1.setPreferredSize(new java.awt.Dimension(tamaño,tamaño));
   add(b1);
    
   if (visible)
   b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e2+".png"))); // NOI18N
   else b2.setBackground(Color.BLACK);
   b2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
   b2.setFocusPainted(false);
   b2.setFocusable(false);
   b2.setMaximumSize(new java.awt.Dimension(tamaño,tamaño));
   b2.setMinimumSize(new java.awt.Dimension(tamaño,tamaño));
   b2.setPreferredSize(new java.awt.Dimension(tamaño,tamaño));
   add(b2);
   horizontal=true;
   }
   validate();
   
   
   
   }
   
   
   public void vuelta(){
   if (visible)
   { 
     b1.setIcon(null);
     b2.setIcon(null);
     b1.setBackground(Color.BLACK);
     b2.setBackground(Color.BLACK);
     add(b1);
     add(b2);
     
     visible=false;   
   }
   else {
   b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e1+".png")));
   b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+e2+".png")));
   add(b1);
     add(b2);
   visible=true;
       }
   validate();
   }
   
   
   
   
}
