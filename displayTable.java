import java.sql.*;

public class displayTable
{
	public static void main(String args[]){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from "+args[0]);
			ResultSetMetaData rsmd = rs.getMetaData();
			int col=rsmd.getColumnCount();
			while(rs.next()){
				for(int i=1;i<col;i++){
					System.out.println(rsmd.getColumnName(i)+" : "+rs.getString(i));
				}
				System.out.println();
			}
			rs.close(); 
			stmt.close();
			con.close();
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
}