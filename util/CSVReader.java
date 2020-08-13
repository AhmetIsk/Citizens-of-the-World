package util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

/**
 * Designed to read the information in countries.txt which keeps all of the questions and other information about countries.
 * Because there are 60 countries and 10 questions for each countries, we designed the countries.txt as a CSV file. 
 * !IMPORTANT! We ensure that there is no " character in our information. 
 * @author Yusuf Ziya Özgül
 * @version 12.05.2019
 */
public class CSVReader extends BufferedReader implements Serializable
{
   // properties
   public static final char QUOTER = '"'; 
   boolean write;
   
   // constructors
   public CSVReader( FileReader fr )
   {
      super( fr );
      write = false;
   }
   
   // methods
   
   /**
    * reads the information inside the CSV file
    * @return the string that is inside two QUOTER (") character. ( That is: "reads this whole part" )
    */
   public String next() throws IOException
   {
      String s;
      char c;
      
      while ( !write )
      {
         c = (char)super.read();
         if ( c == QUOTER )
         {
            write = true;
         }
      }
      
      s = "";
      while ( write )
      {
         c = (char)super.read();
         if ( c != QUOTER )
         {
            s = s + c;
         }
         else
         {
            write = false;
         }
      }
      
      return s;
   }
   
   //closing the reader
   @Override
   public void close() throws IOException
   {
      super.close();
   }
}
