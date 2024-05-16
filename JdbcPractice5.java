import java.io.*;  
import java.sql.*;  
  
public class JdbcPractice5 {  
public static void main(String[] args) {  
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","123456");  
              
PreparedStatement ps=con.prepareStatement("select * from filetable");  
ResultSet rs=ps.executeQuery();  
rs.next();//now on 1st row  
              
Clob c=rs.getClob(2);  
Reader r=c.getCharacterStream();              
              
FileWriter fw=new FileWriter("C:/Users/User/Desktop/Wissen_Training/test.txt");  
              
int i;  
while((i=r.read())!=-1)  
fw.write((char)i);  
              
fw.close();  
con.close();  
              
System.out.println("success");  
}catch (Exception e) {e.printStackTrace();  }  
}  
}  