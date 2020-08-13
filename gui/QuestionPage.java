package gui;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import mainCode.*;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;
import mainCode.pictureClasses.CountryFlag;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Creating QuestioPanel to show the questions
 * @author Yusuf Ziya �zg�l
 * @version 12.05.2019
 */
public class QuestionPage extends JPanel implements Observer {
    
    //properties    
    public static final int CHOICE_NUMBER = 3;
    Game game;
    ArrayList<JButton> choiceButtons;
    JButton choiceOne;
    JButton choiceThree;
    JButton choiceTwo;
    JLabel header;
    JLabel questionSentence;
    JLabel timeLabel;
    
    //constructors
    public QuestionPage( Game game ) 
    {
        this.game = game;
        game.addObserver( this );
        game.getQuiz().addObserver( this );
        
        initComponents();
        
        choiceButtons = new ArrayList<JButton>();
        choiceButtons.add( choiceOne );
        choiceButtons.add( choiceTwo );
        choiceButtons.add( choiceThree );
        
        handleActionListeners();
    }
    
    //methods    
    
    //adding action listeners
    public void handleActionListeners()
    {
        for ( int n = 0; n < CHOICE_NUMBER; n++ )
        {
            choiceButtons.get( n ).addActionListener( new ChoiceBtnListener() );
        }
    }
    
    //ChoiceButton listener
    public class ChoiceBtnListener implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent evt )
        {                  
            game.giveAnswerToQuestion( choiceButtons.indexOf( evt.getSource() ) );
        }
    }
    
    // update method
    public void update( Observable obs, Object obj )
    {                     
       if ( game.getStage().equals( "quiz" ) )
       {           
          Quiz quiz = game.getQuiz();
          Question currentQuestion = quiz.getQuestion();
          
          timeLabel.setText( quiz.getRemainingTime() + "" );  
          
          header.setText( "QUESTION   " + quiz.getQuestionNumber() );
          questionSentence.setText( currentQuestion.getQuestionSentence() );
          
          JButton temp;
          for ( int n = 0; n < CHOICE_NUMBER; n++ )
          {
             temp = choiceButtons.get( n );
             temp.setText( "" );
             temp.removeAll();
             
             if ( currentQuestion.isFlagQuestion() )
             {
                temp.add( new CountryFlag( currentQuestion.getChoice( n ) ) );
             }
             else
             {
                temp.setText( currentQuestion.getChoice( n ) );
             }
          }
       }
       
       setVisible( game.getStage().equals( "quiz" ) );
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // creating components of question page
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

        choiceOne = new javax.swing.JButton();
        choiceTwo = new javax.swing.JButton();
        choiceThree = new javax.swing.JButton();
        header = new javax.swing.JLabel();
        questionSentence = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 255));

        choiceOne.setBackground(new java.awt.Color(204, 255, 255));
        choiceOne.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        choiceOne.setText("1");
        choiceOne.setToolTipText("");

        choiceTwo.setBackground(new java.awt.Color(204, 255, 255));
        choiceTwo.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        choiceTwo.setText("2");

        choiceThree.setBackground(new java.awt.Color(204, 255, 255));
        choiceThree.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        choiceThree.setText("3");

        header.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
        header.setForeground(new java.awt.Color(0, 0, 204));
        header.setText("jLabel1");

        questionSentence.setBackground(new java.awt.Color(255, 255, 255));
        questionSentence.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
        questionSentence.setText("jLabel1");

        timeLabel.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(0, 102, 102));
        timeLabel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(questionSentence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(choiceOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choiceTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choiceThree, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(questionSentence, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(choiceOne, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choiceTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choiceThree, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>                 
}