import java.sql.*;

public class JdbcPractice{
    public static void main(String[] args){
	try{
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");

	    DatabaseMetaData dbmd = con.getMetaData();
	    System.out.println("Driver name : "+dbmd.getDriverName());
	    System.out.println("Driver version : "+dbmd.getDriverVersion());
	    System.out.println("User name : "+dbmd.getUserName());
	    System.out.println("Database product name : "+dbmd.getDatabaseProductName());
	    System.out.println("Database product version : "+dbmd.getDatabaseProductVersion());

	    PreparedStatement stmt = con.prepareStatement("update Employee set NAME=? where EID=?");
	    stmt.setInt(2,5);
	    stmt.setString(1,"Abhishek Singh");
	    
	    int i = stmt.executeUpdate();
	    System.out.println(i+" records updated");
	    
	    PreparedStatement pstmt=con.prepareStatement("select * from Employee");
	    ResultSet rs = pstmt.executeQuery();  
	    while(rs.next()){
		System.out.println(rs.getInt(1)+"	"+rs.getInt("AGE")+"	"+rs.getString("DESIG")+"	"+rs.getString(4)+"	"+rs.getInt(5));
	    }
	    ResultSetMetaData rsmd = rs.getMetaData();
	    System.out.println("Total columns : "+rsmd.getColumnCount());
	    System.out.println("Name of third column : "+rsmd.getColumnName(3));
	    System.out.println("Type of third column : "+rsmd.getColumnTypeName(3));
	    System.out.println("Table name : "+rsmd.getTableName(1));
	    con.close();
	}
	catch(Exception e){
	    System.out.println(e);
	}
    }
}