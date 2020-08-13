package mainCode;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.io.Serializable;
import gui.Application;

/**
 * creating pawn object for each player
 * @author Burak Öçalan
 * @version 12.05.2019
 */
public class Pawn extends Observable implements Serializable
{
   // properties
   public static final int WIDTH = 20;
   public static final int HEIGHT = 30; 
   public static final int TIMER_CONSTANT = 40;
   public static final int SPEED = 4;
   Player p;
   Country currentCountry;
   double locX;
   double locY;
   Timer timer;
   int neededMovements;
   int remainingTime;
   int movementNumber;
   double movementOfX;
   double movementOfY;
   int resolutionWidth;
   
   // constructors
   public Pawn( Player p )
   {      
      this.p = p;
      setLocation( p.getCurrentCountry() );
      
      resolutionWidth = (int)( Application.NORMAL_RESOLUTION.getWidth() );
      
      timer = new Timer( TIMER_CONSTANT, new MovementTimeListener() ); 
   }
   
   // methods
   
   // drawing image for pawn object
   public void draw( Graphics g, JPanel panel )
   {
      Image bg = new ImageIcon( getClass().getResource( "..\\pictures\\pawns\\" + p.getPlayerNo() + ".png" ) ).getImage();
      
      Graphics2D g2 = (Graphics2D) g.create();
      g2.drawImage( bg, (int)locX, (int)locY - HEIGHT, WIDTH, HEIGHT, panel );
      g2.dispose();
   }
   
   // get the location of pawn as x and y coordinates
   public Point getLocation()
   {
      return new Point( (int)locX, (int)locY );
   }
   
   // get the current country of pawn
   public Country getCurrentCountry()
   {
      return currentCountry;
   }
         
   // setting the location of pawn to given country
   protected void setLocation( Country c )
   {
      currentCountry = c;
      setLocation( c.getResolutedLocation() );
   }
   
   // setting the location of pawn to given x and y coordinates
   protected void setLocation( double locX, double locY )
   {
      this.locX = locX;
      this.locY = locY;
      
      setChanged();
      notifyObservers();
   }
   
   // setting the location of pawn to given point
   protected void setLocation( Point p )
   {
      setLocation( p.getX(), p.getY() );
   }
   
   protected void setResolutionWidth( int resolutionWidth )
   {
      this.resolutionWidth = resolutionWidth;
   }
   
   // moving the pawn with given x and y values 
   protected void move( double x, double y )
   {
      setLocation( ( locX + x ) % resolutionWidth, locY + y );
   }
   
   // moving the pawn to next country in gameRoute
   protected void moveNextCountry()
   {
      p.payTravelFee();
      if ( p.isPlaying() )
      {
         // Get the location of next country
         currentCountry = Route.COUNTRIES_ON_ROUTE.get( ( currentCountry.getLocationOnRoute() + 1 ) % Route.COUNTRY_NUMBER );
         
         Point newLocation = new Point( currentCountry.getResolutedLocation() );
         if ( currentCountry.getLocationOnRoute() == 0 )
         {
            newLocation.translate( resolutionWidth, 0 );
         }
         
         // Find the distance and needed movements
         double distance = Math.hypot( newLocation.getX() - locX, newLocation.getY() - locY );      
         neededMovements = (int)( distance / SPEED );
         remainingTime = neededMovements;
         
         // Move the pawn
         movementOfX = ( newLocation.getX() - locX ) / neededMovements;
         movementOfY = ( newLocation.getY() - locY ) / neededMovements;
         timer.start();
      }
   }
   
   // move the pawn from given movement number of time further country from current position
   protected void moveAmongCountries( int movementNumber )
   {
      this.movementNumber = movementNumber;
      moveNextCountry();
   }
   
   //movement time listener
   public class MovementTimeListener implements ActionListener, Serializable
   {
      @Override
      public void actionPerformed( ActionEvent evt )
      {
         remainingTime--;
         
         move( movementOfX, movementOfY );   
         
         if ( remainingTime == 0 ) 
         {
            timer.stop();
            movementNumber--;
            
            setLocation( (int)locX, (int)locY ); // to destroy the decimals.        
            p.setLocation( currentCountry );
            
            if ( movementNumber != 0 )
            {
               moveNextCountry();
            }
            else
            {
               setChanged();
               notifyObservers( "current country" );
            }
         }
      }    
   }
}
         