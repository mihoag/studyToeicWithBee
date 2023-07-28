package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL {
       private static Connection c = null;
       public static Connection getConnection()
       {
    	   try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url  = "jdbc:mySQL://Localhost:3306/webtoetic";
			String user = "root";
			String pass = "leminhhoang";
			
			c = DriverManager.getConnection(url, user, pass);
					
    	   } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	   return c;
       }
       
      public static void close()
      {
    	  try {
			if(c != null)
			{
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
      }
}
