import java.sql.*;

public class JdbcCallable1{
    public static void main(String[] args){
	try{
	    Class.forName("oracle.jdbc.driver.OracleDriver");  

	    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
	      
	    CallableStatement csmt = con.prepareCall("{call INSERTR(?,?)}");
	    
	    csmt.setInt(2,25);
	    csmt.setString(1,"Dolly");
	    csmt.execute();
	    System.out.println("Success");
	}catch(Exception e){
	    System.out.println(e);
	}
    }
}