package mainCode;

import util.GameFileReader;
import java.io.Serializable;
import java.awt.Dimension;

/**
 * creating the game route that pawns ( and players of course ) will follow
 * @author Burak ��alan
 * @version 12.05.2019
 */
public class Route implements Serializable
{
   // properties
   public static final int COUNTRY_NUMBER = 60;
   public static final int TRAVEL_CHARGE = 5; // The charge that cuts from player when he travels from a country to the next one.
   public static final Countries COUNTRIES_ON_ROUTE = GameFileReader.uploadCountryInfo( );
   Pawn[] pawns; // Route has pawns on it, each belongs to a player.
   
   // constructors
   public Route( Player[] players )
   {
      pawns = new Pawn[ players.length ];
      for ( int n = 0; n < pawns.length; n++ )
      {
         pawns[ n ] = new Pawn( players[ n ] );
      }
   }
   
   // methods
   
   /*
    * return the counry with given location on gameRoute
    * @param int location 
    * @return the counry with given location on gameRoute
    */
   public static Country getCountry( int location )
   {
      return COUNTRIES_ON_ROUTE.get( location );
   }
   
   /*
    * return the pawn of given player
    * @param playerNo
    * @return pawn of given player( playerNo) 
    */
   public Pawn getPawn( int playerNo )
   {
      return pawns[ playerNo ];
   }
   
   /*
    * moving the pawn of given player with given movementNumber
    * @param1 Player p
    * @param2 int movementNumber
    */
   protected void movePawn( Player p, int movementNumber )
   {        
      getPawn( p.getPlayerNo() ).moveAmongCountries( movementNumber );    
   }
   
   // Arranges the country and pawn locations according to the resolution of computer screen.
   protected void setRouteResolution( Dimension resolution )
   {
      // arrange the locations of countries
      for ( int n = 0; n < COUNTRY_NUMBER; n++ )
      {
         getCountry( n ).resoluteLocation( resolution );
      }
      
      // To refresh the locations of pawns 
      for ( int n = 0; n < pawns.length; n++ )
      {
         pawns[ n ].setLocation( pawns[ n ].getCurrentCountry() );
         pawns[ n ].setResolutionWidth( (int)( resolution.getWidth() ) );
      }
   }                          
}