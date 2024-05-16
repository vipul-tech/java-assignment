import java.sql.*;  
public class JdbcPractice1{  
public static void main(String args[]){  
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","123456");  
  
DatabaseMetaData dbmd=con.getMetaData();  
String table[]={"VIEW"};  
ResultSet rs=dbmd.getTables(null,null,null,table);  
  
while(rs.next()){  
System.out.println(rs.getString(3));  
}  
  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}