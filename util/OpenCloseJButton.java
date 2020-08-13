package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.Observer;
import java.util.Observable;
import mainCode.Player;
import mainCode.pictureClasses.Avatar;

/** 
 * This class has been created to add buttons some functionality 
 * For example: Player info button can close the player info if you click it when player info is open.
 * @author Burak Öçalan
 * @version 12.05.2019
 */
public class OpenCloseJButton extends JButton implements Observer
{
   // properties
   boolean opened;
   
   // constructors
   public OpenCloseJButton( String text, int size )
   {
      super( text );
      setBackground( Color.cyan );
      setPreferredSize( new Dimension( size, size ) );
      
      opened = false;
   }
   
   public OpenCloseJButton( Player p, int size )
   {
      setLayout( new FlowLayout( FlowLayout.CENTER ) );
      setPreferredSize( new Dimension( size, size ) );
      
      p.addObserver( this );
      add( new JLabel( new Avatar( ( p.getAvatar().getAvatarName() ), size - 20 ) ) ); // 20 is to make it looks better
      
      opened = false;
   }
   
   // methods
   
   /*
    * return whether button is open or not
    * @return whether button is opened or no
    */
   public boolean isOpened()
   {
      return opened;
   }
   
   //changing the current situation of button open - close or close open
   public void changeOpened()
   {
      opened = !opened;
   }
   
   /*
    * updating the buttons, when a player has a turn, his button's color becomes orange. The other buttons remain cyan.
    * @param Observable obs
    * @param Object obj
    */
   public void update( Observable obs, Object obj )
   {
      if ( obj == null || ( (String)obj ).equals( "next turn" ) )
      {
         if ( ( (Player)obs ).hasTurn() )
         {
            setBackground( Color.orange );
         }
         else
         {
            setBackground( Color.cyan );
         }
      }
   }
}