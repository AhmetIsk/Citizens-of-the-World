package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import mainCode.Game;
import mainCode.Route;
import java.util.Observer;
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Creating YouLose page
 * @author Ahmet Kaan Uguralp
 * @version 12.05.2019
 */
public class YouLosePage extends javax.swing.JPanel implements Observer
{
    //properties
    Game game;
   
    //constructors
    public YouLosePage( Game game ) 
    {
       this.game = game;       
       game.addObserver( this );
       
       initComponents();
       handleActionListeners();       
    }

    //methods
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // create the components of YouLosePage
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        moneyField = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 0, 0));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 0, 0));
        jTextField1.setFont(new java.awt.Font("Traditional Arabic", 1, 50)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("YOU LOST");
        jTextField1.setBorder(null);

        moneyField.setEditable( false );
        moneyField.setFont(new java.awt.Font("Gisha", 0, 24)); // NOI18N
        moneyField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        moneyField.setText("lostMoney");
        moneyField.setBorder(null);

        exitButton.setFont(new java.awt.Font("Gisha", 0, 12)); // NOI18N
        exitButton.setText("Exit");
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(moneyField, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moneyField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>     
    
    // adding action listeners
    public void handleActionListeners()
   {
      exitButton.addActionListener( new ActionListener() { 
         @Override
         public void actionPerformed( ActionEvent evt )
         {
            game.lastStage();
         }
      } );
   }
   
   // update method
   public void update( Observable obs, Object obj )
   {
      if ( game.getStage().equals( "you lose" ) )
      {
         moneyField.setText( "- " + game.getQuiz().getQuestionNumber() * Route.COUNTRY_NUMBER );    
      }
      
      setVisible( game.getStage().equals( "you lose" ) );
   }


    // Variables declaration - do not modify                     
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField moneyField;
    // End of variables declaration                   
}
