package mainCode;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import util.GameFileReader;
import java.io.Serializable;
import mainCode.pictureClasses.Avatar;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.awt.Dimension;

/** 
 * Represents the game. Responsible for the connections between the other classes in main code package and between
 * main code and gui classes. 
 * @author Burak Öçalan
 * @version 12.05.2019
 */
public class Game extends Observable implements Observer, Serializable
{     
   // properties
   public static final int MAX_PLAYER_NUMBER = 4;
   int numberOfPlayers;
   Player[] players;
   int roundNo;
   int turnOfPlayer;
   LeadershipTable leadershipTable;
   Player currentPlayer;
   Quiz quiz;
   Route route;
   String stage; // This variable provides the connection between main code and gui packages. 
   Dice dice;
   
   // constructors         
   public Game( int numberOfPlayers, int[] locationsOfPlayers, String[] namesOfPlayers, Avatar[] avatarsOfPlayers ) 
   { 
      this.numberOfPlayers = numberOfPlayers;
      roundNo = 0;
      turnOfPlayer = 0;
      
      quiz = new Quiz();
      quiz.addObserver( this );
      
      players = new Player[ numberOfPlayers ];
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         players[ n ] = new Player( namesOfPlayers[ n ], locationsOfPlayers[ n ], avatarsOfPlayers[ n ], n );
         players[ n ].addObserver( this );
      }
      
      shufflePlayers();
      
      currentPlayer = players[ 0 ];   
      currentPlayer.setHasTurn( true );
      
      route = new Route( players );
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         route.getPawn( n ).addObserver( this );
      }
      
      leadershipTable = new LeadershipTable( players );
      dice = new Dice();
   }     
   
   public Game(){}
   
   // methods
   
   /*
    * return the player having right to play now
    * @return the player having right to play now
    */
   public int getTurnOfPlayer()
   {
      return turnOfPlayer;
   }
   
   /*
    * return the player with given playerNo
    * @param playerNo
    * @return the player with given playerNo
    */
   public Player getPlayer( int playerNo )
   {
      return players[ playerNo ];
   }
   
   /*
    * return the current player in game order
    * @return the current player in game order
    */
   public Player getCurrentPlayer()
   {
      return currentPlayer;
   }
   
   /*
    * return the location of current player
    * @return the location of current player
    */
   public Country getCurrentLocation()
   {
      return getLocationOfPlayer( currentPlayer );
   }
   
   /*
    * return the number of players
    * @return the number of players
    */
   public int getNumberOfPlayers()
   {
      return numberOfPlayers;
   }
   
   /*
    * return the round no of game
    * @return the roundNo of game
    */
   public int getRoundNo()
   {
      return roundNo;
   }
   
   /*
    * return the quiz of game
    * @return the quiz of game
    */
   public Quiz getQuiz()
   {
      return quiz;
   }
   
   /*
    * return the dice
    * @return the dice
    */
   public Dice getDice()
   {
      return dice;
   }
   
   /*
    * return the stage of game
    * @return the stage of game
    */
   public String getStage()
   {
      return stage;
   }
   
   /*
    * accessing the leadership table of game
    * @return the LeaderShipTable of game
    */
   public LeadershipTable getLeadershipTable()
   {
      return leadershipTable;
   }
   
   /*
    * return the current country of player p
    * @param Player p
    * @return the current country of Player p
    */
   public Country getLocationOfPlayer( Player p )
   {
      return p.getCurrentCountry();
   }
   
   /*
    * return the game route
    * @return the Game route
    */
   public Route getRoute()
   {
      return route;
   }
   
   /*
    * updating the stage of game and observers with given string
    * @param String s
    */
   public void setStage( String s )
   {
      stage = s;
      
      setChanged();
      notifyObservers();
   }
   
   /*
    * shuffling the players of game
    */
   public void shufflePlayers()
   {
      Player[] playersTemp;
      int location;
      
      // create the clone of players array
      playersTemp = new Player[ numberOfPlayers ];
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         playersTemp[ n ] = players[ n ];
      }
      
      // shuffle the players array with the help of template
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         location = (int)( Math.random() * ( numberOfPlayers - n ) );
         players[ n ] = playersTemp[ location ];
         players[ n ].setPlayerNo( n );
         playersTemp[ location ] = playersTemp[ numberOfPlayers - n - 1 ];
      }
   }
   
   // turn for next player in the order
   public void nextTurn()
   {
      if ( currentPlayer.isPlaying() )
      {
         currentPlayer.addRevenue();
         currentPlayer.setHasTurn( false );
      }
      
      if ( !isGameOver() )
      {
         boolean found = false;         
         while( !found )
         {
            turnOfPlayer = ( turnOfPlayer + 1 ) % numberOfPlayers;
            
            if ( players[ turnOfPlayer ].isPlaying() )
            {
               found = true;
            }
         }
         
         leadershipTable.refresh();
         
         roundNo++;
         setStage( "new player" );
         
         currentPlayer = getPlayer( turnOfPlayer );
         currentPlayer.setHasTurn( true );
      }
   }
   
   // rolling dices and move pawn of player currently playing related to result of dices to country in route
   public void rollDice( )
   {
      setStage( "moving pawn" );
      
      route.movePawn( currentPlayer, currentPlayer.rollDice( dice ) );
   }
   
   // whether given player is in turn or not
   public boolean isTurnOf( Player p)
   {
      return p.getPlayerNo() == turnOfPlayer;
   }
   
   // paying accomodation fee of player in turn 
   public void payAccomodationFee()
   {
      currentPlayer.payAccomodationFee( getCurrentLocation() );
      
      if ( currentPlayer.hasMoney() )
      {
         setStage( "accomodation fee" );
      }
   }
   
   // paying question fee of current player
   public void payQuestionFee()
   {
      currentPlayer.payQuestionFee();
   }
   
   // creating new quiz for current player
   public void newQuiz()
   {      
      quiz.newQuiz( getCurrentLocation() );
      
      setStage( "quiz" );
   }
   
   //trial for getting citizenship and quiz
   public void getCitizenship()
   {
      payQuestionFee();
      
      if ( currentPlayer.hasMoney() )
      {
         newQuiz();
      }
   }
   
   // adding new citizenships and its message to player
   public void youWin()
   {
      setStage( "you win" );
      
      currentPlayer.addCitizenship( getCurrentLocation() );
      getCurrentLocation().addToCitizenship( currentPlayer );             
   }
   
   // losing the chance of citizenship and its message
   public void youLose()
   {
      setStage( "you lose" );
   }
   
   // checking the answer of question
   public void giveAnswerToQuestion( int answer )
   {
      quiz.checkAnswer( answer );
   }
   
   // makes the current player to leave game, used in two situations; 1-player wants to leave, 2-player has no money
   public void leaveGame()
   {
      currentPlayer.leaveGame();
      setStage( "player left" );
   }
   
   public void lastStage()
   {
      setStage( "last stage" );
   }
   
   // starting new game
   public void startGame( Dimension resolution )
   {
      // Initialise all players and leadership table 
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         getPlayer( n ).notifier();
      }      
      leadershipTable.notifier();
      
      // adding all observers again. Because serializable class doesn't save the observer class, therefore we need
      // to add them again after loading a game. 
      quiz.addObserver( this );
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         players[ n ].addObserver( this );
         route.getPawn( n ).addObserver( this );
      }
      
      setStage( "new player" );
      route.setRouteResolution( resolution );
      
      setChanged();
      notifyObservers();
   }   
   
   //updating the probable changes like money, win, lose, answer for questions in the game
   public void update( Observable obs, Object obj )
   {
      if ( obj != null )
      {
         String s = (String)obj;
         
         if ( s.equals( "money changed" ) )
         {
            if ( !currentPlayer.hasMoney() )
            {
               leaveGame();
            }
         }   
         else if ( s.equals( "you win" ) )
         {
            youWin();
         }
         else if ( s.equals( "you lose" ) )
         {
            youLose();
         }
         else if ( s.equals( "next question" ) )
         {
            currentPlayer.payQuestionFee();
         }
         else if ( s.equals( "current country" ) )
         {
            setStage( "country info" );
         }
      }
   }
   
   // whether game is over or not
   public boolean isGameOver()
   {
      for ( int n = 0; n < numberOfPlayers; n++ )
      {
         if ( getPlayer( n ).isPlaying() )
         {
            return false;
         }
      }
      
      setStage( "game over" );
      return true;
   }
   
   // saving current game in to file
   public void saveGame( String fileName)
   {
      try
      {
         FileOutputStream fos = new FileOutputStream( "saved games\\" + fileName+ ".txt");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject( this);
         oos.close();
         fos.close();
      }
      catch( IOException e)
      {
         e.printStackTrace();
      }
   }
   
   // loading the saved game from file
   public Game loadGame( String fileName)
   {
      FileInputStream fos;
      ObjectInputStream oos;
      Object a = new Object();
      try
      {
         fos = new FileInputStream( "saved games\\" + fileName );
         oos = new ObjectInputStream(fos);
         a = oos.readObject();
         oos.close();
         fos.close();
      }
      catch( IOException e )
      {
         e.printStackTrace();
      }
      catch(Exception exp)
      {
         exp.printStackTrace();
      }
      return (Game)(a);
      
   }
}



