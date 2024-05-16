import java.sql.*;

public class JdbcBatch{
    public static void main(String[] args)throws Exception{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
	con.setAutoCommit(false);
	Statement stmt = con.createStatement();
	stmt.addBatch("insert into EMP values('Ankit',19)");
	stmt.addBatch("delete from EMP where name='Richa'");
	stmt.executeBatch();
	con.commit();
	con.close();
	System.out.println("Success");
    }
}