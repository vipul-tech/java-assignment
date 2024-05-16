import java.sql.*;  
public class JdbcTransaction1{  
    public static void main(String args[])throws Exception{  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");  
	con.setAutoCommit(false);  
  
	Statement stmt=con.createStatement();  
	stmt.executeUpdate("insert into EMP values('Subham',30)");  
	stmt.executeUpdate("insert into EMPLOYEE values(50,26,'Tester','Priya',30000)");  
  
	con.commit();  
	con.close();  
    }
}  