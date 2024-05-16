import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;   
import javax.sql.RowSetEvent;  
import javax.sql.RowSetListener;  
import javax.sql.rowset.JdbcRowSet;  
import javax.sql.rowset.RowSetProvider;  
  
public class JdbcRowSet {  
        public static void main(String[] args) throws Exception {  
                 Class.forName("oracle.jdbc.driver.OracleDriver");  
      
    //Creating and Executing RowSet  
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
        rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");  
        rowSet.setUsername("system");  
        rowSet.setPassword("123456");  
                   
        rowSet.setCommand("select * from EMP");  
        rowSet.execute();  
                   
    	while (rowSet.next()) {  
                        System.out.println("Name: " + rowSet.getString(1));  
                        System.out.println("Age: " + rowSet.getInt(2));  
                }  
                 
        }  
}  