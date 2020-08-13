/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import mainCode.pictureClasses.Avatar;

/**
 * PlayerInfo GUI
 * @author Ahmet Isik
 * @version 12.05.2019
 */
public class PlayerInfo extends JPanel implements Observer
{
   //properties
   public static final Dimension SIZE = new Dimension( 295, 400 );
   Player p;
   Game game;
   ArrayList<JPanel> countries;
   Avatar avatar;
   
   /**
    * Creates new form PlayerInfoJ
    */
   
   public PlayerInfo( Game game, int playerNo ) {
      
      this.game = game;
      p = game.getPlayer( playerNo );
      
      p.addObserver( this );
      countries = new ArrayList<JPanel>();

      initComponents();
      countriesPanel.setLayout( new BoxLayout( countriesPanel, BoxLayout.Y_AXIS  ) );
      setVisible( false );
   }
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents() {
      avatarLabel = new javax.swing.JLabel();
      avatar = p.getAvatar();
      avatarLabel.add(avatar);
      playerName = new javax.swing.JLabel();
      currentMoney = new javax.swing.JLabel();
      revenue = new javax.swing.JLabel();
      nationality = new javax.swing.JLabel();
      citizenshipsTitle = new javax.swing.JLabel();
      countriesPanel = new javax.swing.JPanel();
      currentMoneyTitle = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      
      
      setBackground(new java.awt.Color(102, 255, 255));
      
      playerName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
      playerName.setForeground(new java.awt.Color(0, 0, 102));
      playerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      playerName.setText(p.getName());
      
      currentMoney.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
      currentMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      currentMoney.setText("currentMoney");
      
      revenue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      revenue.setText("revenue");
      
      nationality.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      nationality.setText("Nationality: " + game.getLocationOfPlayer( p ).getName());
      
      citizenshipsTitle.setBackground(new java.awt.Color(204, 255, 255));
      citizenshipsTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      citizenshipsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      citizenshipsTitle.setText("CITIZENSHIPS");
      citizenshipsTitle.setBorder(javax.swing.BorderFactory.createCompoundBorder());
      citizenshipsTitle.setOpaque(true);
      
      javax.swing.GroupLayout countriesPanelLayout = new javax.swing.GroupLayout(countriesPanel);
      countriesPanel.setLayout(countriesPanelLayout);
      countriesPanelLayout.setHorizontalGroup(
                                              countriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGap(0, 0, Short.MAX_VALUE)
                                             );
      countriesPanelLayout.setVerticalGroup(
                                            countriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                               .addGap(0, 327, Short.MAX_VALUE)
                                           );
      
      currentMoneyTitle.setBackground(new java.awt.Color(204, 255, 255));
      currentMoneyTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      currentMoneyTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      currentMoneyTitle.setText("CURRENT MONEY");
      currentMoneyTitle.setOpaque(true);
      
      jLabel1.setBackground(new java.awt.Color(102, 102, 255));
      jLabel1.setOpaque(true);
      
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                             .addGroup(layout.createSequentialGroup()
                                                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                       .addComponent(currentMoneyTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                                                                       .addComponent(citizenshipsTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                       .addComponent(countriesPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                       .addComponent(revenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                          .addGap(0, 0, Short.MAX_VALUE))
                                                             .addGroup(layout.createSequentialGroup()
                                                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                       .addComponent(nationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                       .addGroup(layout.createSequentialGroup()
                                                                                                    .addComponent(avatarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addGap(28, 28, 28)
                                                                                                    .addComponent(playerName, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                                                                       .addComponent(currentMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                          .addContainerGap())))
                               );
      layout.setVerticalGroup(
                              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGroup(layout.createSequentialGroup()
                                              .addGap(12, 12, 12)
                                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                           .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                           .addComponent(avatarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                              .addGap(17, 17, 17)
                                              .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(revenue)
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                              .addComponent(citizenshipsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(countriesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                              .addGap(11, 11, 11)
                                              .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                              .addComponent(currentMoneyTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                              .addGap(2, 2, 2)
                                              .addComponent(currentMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                              .addContainerGap())
                             );
   }// </editor-fold>  
   
   /*
    * creating a panel for player info
    */
   public void createCountryPanel( Country c )
   {
      JPanel panel = new JPanel();
      
      panel.add( new JLabel( c.getName() ) );
      panel.add( new JLabel( c.getTax() + "" ) );
      
      countries.add( panel );
      countriesPanel.add( panel );
   }
   
   /*
    * updating the information of player
    */
   public void update( Observable obs, Object obj )
   {
      currentMoney.setText( "Money: " + p.getMoney()  );
      revenue.setText( "Revenue: " + p.getRevenue() );
      
      if ( countries.size() < p.getNumberOfCitizenships() )
      {
         createCountryPanel( p.getLastCountry() );
      }
   }
   
   // Variables declaration - do not modify                     
   private javax.swing.JLabel avatarLabel;
   private javax.swing.JPanel countriesPanel;
   private javax.swing.JLabel citizenshipsTitle;
   private javax.swing.JLabel currentMoney;
   private javax.swing.JLabel currentMoneyTitle;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel nationality;
   private javax.swing.JLabel playerName;
   private javax.swing.JLabel revenue;
   // End of variables declaration              
}