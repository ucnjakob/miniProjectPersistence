package database;
import java.sql.*;

public class DBCon implements DBCIF
{   //Constants used to get access to the database
	//SQL Server
    private static final String  driver = "jdbc:sqlserver://hildur.ucn.dk";
    private static final String  databaseName = ";databaseName=DMA-CSD-V23_10483818";
    private static String  userName = "; user=DMA-CSD-V23_10483818";
    private static String password = ";password=Password1!";
    private static String encryption = ";encrypt=false";
   
  
    private DatabaseMetaData dma;
    private static Connection con;
    // an instance of the class is generated
    private static DBCon  instance = null;
    
    public static void main(String [] args) {
    	try {
    	DBCon dbcon = new DBCon();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    // the constructor is private to ensure that only one object of this class is created
    private DBCon()
    {
    	String url = driver + databaseName + userName + password + encryption;

        try{
            //load af driver
            //SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Load af class ok");
          
        }
        catch(Exception e){
            System.out.println("Can not find the driver");
            System.out.println(e.getMessage());
        }//end catch
        try{
            //connection to the database
           
            con = DriverManager.getConnection(url);
            //set autocommit
            con.setAutoCommit(true);
            dma = con.getMetaData(); // get meta data
            System.out.println("Connection to " + dma.getURL());
            System.out.println("Driver " + dma.getDriverName());
            System.out.println("Database product name " + dma.getDatabaseProductName());
        }//end try
        catch(Exception e){

            System.out.println("Problems with the connection to the database");
            System.out.println(e.getMessage());
            System.out.println(url);
        }//end catch
    }//end  constructor
	   
    //closeDb: closes the connection to the database
    public static void closeConnection()
    {
       	try{
            con.close();
            System.out.println("The connection is closed");
        }
         catch (Exception e){
            System.out.println("Error trying to close the database " +  e.getMessage());
         }
    }//end closeDB
		
    //getDBcon: Get-method, returns the connection to the database
    public  Connection getDBcon()
    {
       return con;
    }
    //this method is used to get the instance of the connection
    public static DBCon getInstance()
    {
        if (instance == null)
        {
          instance = new DBCon();
        }
        return instance;
    }
    
    /*
     * Transaction handling
     */
    public static void startTransaction() {
    	try {
    		con.setAutoCommit(false);
        } catch(SQLException e) {
	        System.out.println("Start transaction failure");
	        System.out.println(e.getMessage());
      }
    }
    public static void commitTransaction() throws SQLException {
    	try {
    		con.commit();
        }
      catch(SQLException e) {
        System.out.println("Commit transaction failure");
        System.out.println(e.getMessage());
      } finally {
    	  con.setAutoCommit(true);
      }
    }
    public static void rollbackTransaction() throws SQLException { 
    	try{
    		con.rollback();
        }
      catch(Exception e){
        System.out.println("Rollback transaction failure");
        System.out.println(e.getMessage());
      } finally {
    	  con.setAutoCommit(true);
      }
    }
}//end DbConnection
