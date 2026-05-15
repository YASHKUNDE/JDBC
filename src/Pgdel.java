import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Pgdel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con;
		PreparedStatement psment;
		
		try {
			
			String url="jdbc:postgresql://localhost:5432/login";
			String user="postgres";
			String password="123456";
			con=DriverManager.getConnection( url, user, password );
			
			System.out.println("Connected Successfully.....!");
			
			psment=con.prepareStatement("delete from login where id=19");
			int del=psment.executeUpdate();
			if(del>0) {
				System.out.println("Delete Success");
			}else {
				System.out.println("Delete Failed");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
