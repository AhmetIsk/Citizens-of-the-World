package mainCode.pictureClasses;

import util.ResizablePicture;
import java.io.Serializable;

/** 
 * creating country flags
 * @author Yusuf Ziya Özgül
 * @version 12.05.2019
 */
public class CountryFlag extends ResizablePicture implements Serializable
{
   // properties
   public static final int WIDTH = 60;
   public static final int HEIGHT = 40;
   
   // constructors
   public CountryFlag( String countryName )
   {
      super( WIDTH, HEIGHT, "..\\..\\Country Info\\Country Flags\\" + countryName + ".png" );
   }
}