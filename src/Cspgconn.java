import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cspgconn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement sment;
		ResultSet rs;
		
		try {
			
			String url="jdbc:postgresql://localhost:5432/login";
			String user="postgres";
			String password="123456";
			con=DriverManager.getConnection( url, user, password );
			
			System.out.println("Connected Successfully");
			
			sment=con.createStatement();
			rs=sment.executeQuery("select * from login");
			while(rs.next()) {
				System.out.println(rs.getString("users")+" "+rs.getString("mobile"));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}