import java.sql.*;  
  
public class JdbcCallable2 {  
    public static void main(String[] args) throws Exception{  
  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");  
  
	CallableStatement stmt=con.prepareCall("{?= call sum4(?,?)}");  
	stmt.setInt(2,100);  
	stmt.setInt(3,432);  
	stmt.registerOutParameter(1,Types.INTEGER);  
	stmt.execute();  
  
	System.out.println("Sum = "+stmt.getInt(1));  
          
    }  
}  