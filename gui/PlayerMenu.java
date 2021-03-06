/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import mainCode.*;
import mainCode.pictureClasses.Avatar;
import util.GameFileReader;
import java.awt.*;
import javax.swing.*;

/**
 * PlayerMenu GUI
 * @author Ahmet Isik
 * @version 12.05.2019
 */
public class PlayerMenu extends javax.swing.JPanel {
   
   //properties
   int numberOfPlayers;
   ArrayList<String> listedCountries; // countries that are listed as in the game ( the usage explained above the method )
   String[] alphabeticalCountries; // we need alphabetical list of countries in scroll panes
   Avatar[] avatars;
   Application app; 
   
   //constructors
   public PlayerMenu( Application app ) {
      
      this.app = app;
      
      alphabeticalCountries = GameFileReader.getAlphabeticalCountriesArray(); // will be needed in country lists
      avatars = GameFileReader.getAvatarsArray(); // will be needed in avatar lists   
      listedCountries = GameFileReader.getListedCountries(); // will be needed when the game is starting
      
      initComponents();
      
      p1Panel.setVisible(false);
      p2Panel.setVisible(false);
      p3Panel.setVisible(false);
      p4Panel.setVisible(false);
      
      setSize( app.getSize() );   // "super" JFrame sets initial size
      setVisible( false );    // "super" JFrame shows
   }
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
      private void initComponents() {
      
      jLabel1 = new javax.swing.JLabel();
      p1Panel = new javax.swing.JPanel();
      p1Name = new javax.swing.JTextField();
      p1Country = new javax.swing.JScrollPane();
      countryList1 = new javax.swing.JList();
      p1Avatar = new javax.swing.JScrollPane();
      avatarList1 = new javax.swing.JList();
      p2Panel = new javax.swing.JPanel();
      p2Name = new javax.swing.JTextField();
      p2Country = new javax.swing.JScrollPane();
      countryList2 = new javax.swing.JList();
      p2Avatar = new javax.swing.JScrollPane();
      avatarList2 = new javax.swing.JList();
      p3Panel = new javax.swing.JPanel();
      p3Name = new javax.swing.JTextField();
      p3Country = new javax.swing.JScrollPane();
      countryList3 = new javax.swing.JList();
      p3Avatar = new javax.swing.JScrollPane();
      avatarList3 = new javax.swing.JList();
      p4Panel = new javax.swing.JPanel();
      p4Name = new javax.swing.JTextField();
      p4Country = new javax.swing.JScrollPane();
      countryList4 = new javax.swing.JList();
      p4Avatar = new javax.swing.JScrollPane();
      avatarList4 = new javax.swing.JList();
      oneCheck = new javax.swing.JRadioButton();
      twoCheck = new javax.swing.JRadioButton();
      threeCheck = new javax.swing.JRadioButton();
      fourCheck = new javax.swing.JRadioButton();
      back = new javax.swing.JButton();
      start = new javax.swing.JButton();
      southPanel = new JPanel();
      centerPanel = new JPanel();
      p1GrandPanel = new JPanel();
      p2GrandPanel = new JPanel();
      p3GrandPanel = new JPanel();
      p4GrandPanel = new JPanel();
      
      setBackground( Color.cyan );
      setLayout( new BorderLayout() );
      
      jLabel1.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
      jLabel1.setText("Choose Player Number");
      
      centerPanel.setLayout( new GridLayout( 4, 1 ) );
      
      FlowLayout layout1 = new FlowLayout();
      layout1.setHgap( 50 );
         
      p1Panel.setBackground(new java.awt.Color(153, 255, 153));
      p1Panel.setLayout( layout1 );
      
      oneCheck.setBackground(new java.awt.Color(0, 204, 51));
      oneCheck.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
      oneCheck.setText("P1");
      oneCheck.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            oneCheckActionPerformed(evt);
         }
      });
      
      p1Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      p1Name.setForeground(new java.awt.Color(0, 102, 0));
      p1Name.setText("Enter Nickname");
      
      p1Country.setBackground(new java.awt.Color(204, 255, 204));
      p1Country.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      p1Country.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      
      countryList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      countryList1.setModel(new javax.swing.AbstractListModel() {
         String[] strings = alphabeticalCountries;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p1Country.setViewportView(countryList1);
      
      p1Avatar.setBackground(new java.awt.Color(204, 255, 204));
      p1Avatar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      
      avatarList1.setModel(new javax.swing.AbstractListModel() {
         Avatar[] strings = avatars;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p1Avatar.setViewportView(avatarList1);
      avatarList1.setVisibleRowCount( 2 );
      avatarList1.setLayoutOrientation( javax.swing.JList.HORIZONTAL_WRAP );
      
      p1Panel.add( p1Name );
      p1Panel.add( p1Country );
      p1Panel.add( p1Avatar );
      
      p1GrandPanel.setLayout( new BorderLayout() );
      p1GrandPanel.setBackground( Color.cyan );
      p1GrandPanel.add( oneCheck, BorderLayout.WEST );
      p1GrandPanel.add( p1Panel, BorderLayout.CENTER );
      
      centerPanel.add( p1GrandPanel );
      
      p2Panel.setBackground(new java.awt.Color(255, 255, 153));
      p2Panel.setLayout( layout1 );
      
      twoCheck.setBackground(new java.awt.Color(255, 255, 51));
      twoCheck.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
      twoCheck.setText("P2");
      twoCheck.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            twoCheckActionPerformed(evt);
         }
      });
      
      p2Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      p2Name.setForeground(new java.awt.Color(102, 102, 0));
      p2Name.setText("Enter Nickname");
      
      p2Country.setBackground(new java.awt.Color(255, 255, 204));
      p2Country.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      p2Country.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      
      countryList2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      countryList2.setModel(new javax.swing.AbstractListModel() {
         String[] strings = alphabeticalCountries;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p2Country.setViewportView(countryList2);
      
      p2Avatar.setBackground(new java.awt.Color(255, 255, 204));
      p2Avatar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      
      avatarList2.setModel(new javax.swing.AbstractListModel() {
         Avatar[] strings = avatars;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p2Avatar.setViewportView(avatarList2);
      avatarList2.setVisibleRowCount( 2 );
      avatarList2.setLayoutOrientation( javax.swing.JList.HORIZONTAL_WRAP );
      
      p2Panel.add( p2Name );
      p2Panel.add( p2Country );
      p2Panel.add( p2Avatar );
      
      p2GrandPanel.setLayout( new BorderLayout() );
      p2GrandPanel.setBackground( Color.cyan );
      p2GrandPanel.add( twoCheck, BorderLayout.WEST );
      p2GrandPanel.add( p2Panel, BorderLayout.CENTER );
      
      centerPanel.add( p2GrandPanel );
      
      p3Panel.setBackground(new java.awt.Color(255, 153, 153));
      p3Panel.setLayout( layout1 );
      
      threeCheck.setBackground(new java.awt.Color(255, 51, 0));
      threeCheck.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
      threeCheck.setText("P3");
      threeCheck.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            threeCheckActionPerformed(evt);
         }
      });
      
      p3Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      p3Name.setForeground(new java.awt.Color(153, 0, 0));
      p3Name.setText("Enter Nickname");
      
      p3Country.setBackground(new java.awt.Color(255, 204, 204));
      p3Country.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      p3Country.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      
      countryList3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      countryList3.setModel(new javax.swing.AbstractListModel() {
         String[] strings = alphabeticalCountries;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p3Country.setViewportView(countryList3);
      
      p3Avatar.setBackground(new java.awt.Color(255, 204, 204));
      p3Avatar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      
      avatarList3.setModel(new javax.swing.AbstractListModel() {
         Avatar[] strings = avatars;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p3Avatar.setViewportView(avatarList3);
      avatarList3.setVisibleRowCount( 2 );
      avatarList3.setLayoutOrientation( javax.swing.JList.HORIZONTAL_WRAP );
      
      p3Panel.add( p3Name );
      p3Panel.add( p3Country );
      p3Panel.add( p3Avatar );
      
      p3GrandPanel.setLayout( new BorderLayout() );
      p3GrandPanel.setBackground( Color.cyan );
      p3GrandPanel.add( threeCheck, BorderLayout.WEST );
      p3GrandPanel.add( p3Panel, BorderLayout.CENTER );
      
      centerPanel.add( p3GrandPanel );
      
      p4Panel.setBackground(new java.awt.Color(153, 153, 255));
      p4Panel.setLayout( layout1 );
      
      fourCheck.setBackground(new java.awt.Color(102, 102, 255));
      fourCheck.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
      fourCheck.setText("P4");
      fourCheck.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            fourCheckActionPerformed(evt);
         }
      });
      
      p4Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      p4Name.setForeground(new java.awt.Color(102, 0, 153));
      p4Name.setText("Enter Nickname");
      
      p4Country.setBackground(new java.awt.Color(204, 204, 255));
      p4Country.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      p4Country.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      
      countryList4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
      countryList4.setModel(new javax.swing.AbstractListModel() {
         String[] strings = alphabeticalCountries;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p4Country.setViewportView(countryList4);
      
      p4Avatar.setBackground(new java.awt.Color(204, 204, 255));
      p4Avatar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      
      avatarList4.setModel(new javax.swing.AbstractListModel() {
         Avatar[] strings = avatars;
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      p4Avatar.setViewportView(avatarList4);
      avatarList4.setVisibleRowCount( 2 );
      avatarList4.setLayoutOrientation( javax.swing.JList.HORIZONTAL_WRAP );
      
      p4Panel.add( p4Name );
      p4Panel.add( p4Country );
      p4Panel.add( p4Avatar );
      
      p4GrandPanel.setLayout( new BorderLayout() );
      p4GrandPanel.setBackground( Color.cyan );
      p4GrandPanel.add( fourCheck, BorderLayout.WEST );
      p4GrandPanel.add( p4Panel, BorderLayout.CENTER );
      
      centerPanel.add( p4GrandPanel );
      
      back.setBackground(new java.awt.Color(255, 255, 255));
      back.setPreferredSize( new Dimension( 100, 50 ) );
      back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      back.setForeground(new java.awt.Color(204, 0, 0));
      back.setText("Back");
      back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
      back.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
      back.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            backActionPerformed(evt);
         }
      });
      
      start.setBackground(new java.awt.Color(255, 255, 255));
      start.setPreferredSize( new Dimension( 100, 50 ) );
      start.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      start.setForeground(new java.awt.Color(0, 153, 102));
      start.setText("Start");
      start.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
      start.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
      start.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            startActionPerformed(evt);
         }
      });
      
      southPanel.setLayout( new BorderLayout() );
      southPanel.setBackground( Color.cyan );
      southPanel.add( back, BorderLayout.WEST );
      southPanel.add( start, BorderLayout.EAST );
      
      add( jLabel1, BorderLayout.NORTH );
      add( centerPanel, BorderLayout.CENTER );
      add( southPanel, BorderLayout.SOUTH );
   }// </editor-fold>    
   
   public void toggle( javax.swing.JRadioButton r, javax.swing.JPanel p ) {
      if( r.isSelected() == true ) {
         p.setVisible(true);
      }
      else
         p.setVisible(false);
   }
   
   private void oneCheckActionPerformed(java.awt.event.ActionEvent evt) {                                         
      // TODO add your handling code here:
      toggle( oneCheck, p1Panel );
      numberOfPlayers = 1;
   }                                        
   
   private void twoCheckActionPerformed(java.awt.event.ActionEvent evt) {                                         
      // TODO add your handling code here:
      toggle( twoCheck, p2Panel );
      if( oneCheck.isSelected() == false ) {
         p2Panel.setVisible(false);
      }
      
      if( p2Panel.isVisible() ) {
         numberOfPlayers = 2;
      }
      else
         numberOfPlayers = 1;
   }                                        
   
   private void threeCheckActionPerformed(java.awt.event.ActionEvent evt) {                                           
      // TODO add your handling code here:
      toggle( threeCheck, p3Panel );
      if( twoCheck.isSelected() == false ) {
         p3Panel.setVisible(false);
      }
      
      if( p3Panel.isVisible() ) {
         numberOfPlayers = 3;
      }
      else
         numberOfPlayers = 2;
   }                                          
   
   private void fourCheckActionPerformed(java.awt.event.ActionEvent evt) {                                          
      // TODO add your handling code here:
      toggle( fourCheck, p4Panel );
      if( threeCheck.isSelected() == false ) {
         p4Panel.setVisible(false);
      }
      
      if( p4Panel.isVisible() ) {
         numberOfPlayers = 4;
      }
      else
         numberOfPlayers = 3;
   }                                         
   
   //action performed method for end button
   private void backActionPerformed(java.awt.event.ActionEvent evt) {                                     
      // TODO add your handling code here:
      setVisible( false );
      app.mainMenu.setVisible( true );
      
   }
   
   // action performed method for start button
   private void startActionPerformed(java.awt.event.ActionEvent evt) {                                      
      // TODO add your handling code here:
      String[] namesOfPlayers;
      int[] locationsOfPlayers;
      Avatar[] avatarsOfPlayers;
      String country;
      
      namesOfPlayers = new String[ numberOfPlayers ];
      locationsOfPlayers = new int[ numberOfPlayers ];
      avatarsOfPlayers = new Avatar[ numberOfPlayers ];
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         namesOfPlayers[ n ] = getPlayerName( n );
         locationsOfPlayers[ n ] = getSelectedCountry( n );
         avatarsOfPlayers[ n ] = getSelectedAvatar( n );
      }
      
      app.gameGui = new GameGUI( app, new Game( numberOfPlayers, locationsOfPlayers, namesOfPlayers, avatarsOfPlayers ) ); 
      app.add( app.gameGui );
      setVisible( false );
   }                                     
   
   // getting the name of player with given playerNo
   public String getPlayerName( int playerNo ) {
      if( playerNo == 0 ) {
         return p1Name.getText();
      }
      
      else if( playerNo == 1 ) {
         return p2Name.getText();
      }
      
      else if( playerNo == 2 ) {
         return p3Name.getText();
      }
      
      else
         return p4Name.getText();
   }
   
   /*
    * return the number of country which player with playerNo selected
    */
   public int getSelectedCountry( int playerNo ) {
      if( playerNo == 0 ) {
         return listedCountries.indexOf( countryList1.getSelectedValue().toString() );
      }
      
      else if( playerNo == 1 ) {
         return listedCountries.indexOf( countryList2.getSelectedValue().toString() );
      }
      
      else if( playerNo == 2 ) {
         return listedCountries.indexOf( countryList3.getSelectedValue().toString() );
      }
      
      else
         return listedCountries.indexOf( countryList4.getSelectedValue().toString() );
   }
   
   /*
    * return the avatar character considering given playerNo
    * @param playerNo
    * @return Avatar character of given playerNo
    */
   public Avatar getSelectedAvatar( int playerNo )
   {
      if( playerNo == 0 ) {
         return (Avatar)avatarList1.getSelectedValue();
      }
      
      else if( playerNo == 1 ) {
         return (Avatar)avatarList2.getSelectedValue();
      }
      
      else if( playerNo == 2 ) {
         return (Avatar)avatarList3.getSelectedValue();
      }
      
      else
         return (Avatar)avatarList4.getSelectedValue();
   }
   
   
   
   
   // Variables declaration - do not modify                     
   private javax.swing.JList avatarList1;
   private javax.swing.JList avatarList2;
   private javax.swing.JList avatarList3;
   private javax.swing.JList avatarList4;
   private javax.swing.JButton back;
   private javax.swing.JList countryList1;
   private javax.swing.JList countryList2;
   private javax.swing.JList countryList3;
   private javax.swing.JList countryList4;
   private javax.swing.JRadioButton fourCheck;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JTextField p3Name;
   private javax.swing.JTextField p4Name;
   private javax.swing.JRadioButton oneCheck;
   private javax.swing.JScrollPane p1Avatar;
   private javax.swing.JScrollPane p1Country;
   private javax.swing.JTextField p1Name;
   private javax.swing.JPanel p1Panel;
   private javax.swing.JScrollPane p2Avatar;
   private javax.swing.JScrollPane p2Country;
   private javax.swing.JTextField p2Name;
   private javax.swing.JPanel p2Panel;
   private javax.swing.JScrollPane p3Avatar;
   private javax.swing.JScrollPane p3Country;
   private javax.swing.JPanel p3Panel;
   private javax.swing.JScrollPane p4Avatar;
   private javax.swing.JScrollPane p4Country;
   private javax.swing.JPanel p4Panel;
   private javax.swing.JButton start;
   private javax.swing.JRadioButton threeCheck;
   private javax.swing.JRadioButton twoCheck;
   private JPanel southPanel;
   private JPanel centerPanel;
   private JPanel p1GrandPanel;
   private JPanel p2GrandPanel;
   private JPanel p3GrandPanel;
   private JPanel p4GrandPanel;
   // End of variables declaration                   
}
