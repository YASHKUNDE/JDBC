/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Pgupd {

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
			
			Scanner scan=new Scanner(System.in);
			
			System.out.println("Enter Name: ");
			String nm=scan.next();
			
			System.out.println("Enter Email: ");
			String em=scan.next();
			
			System.out.println("Enter Mobile: ");
			String mo=scan.next();
			
			System.out.println("Enter Password: ");
			int pw=scan.nextInt();
			
			psment=con.prepareStatement("update login set users=?, email=?, mobile=?, pass=? where id=18");
			
			psment.setString(1,nm);
			psment.setString(2,em);
			psment.setString(3,mo);
			psment.setInt(4,pw);
			
			int upd=psment.executeUpdate();
			if(upd>0) {
				System.out.println("Insert Success");
			}else {
				System.out.println("Insert Failed");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Pgupd {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/login";
        String user = "postgres";
        String password = "123456";

        try (
            Connection con = DriverManager.getConnection(url, user, password);
            Scanner scan = new Scanner(System.in)
        ) {
            System.out.println("Connected Successfully.....!");

            // Get user input
            System.out.print("Enter Name: "); 
            String name = scan.nextLine();

            System.out.print("Enter Email: ");
            String email = scan.nextLine();

            System.out.print("Enter Mobile: ");
            String mobile = scan.nextLine();

            System.out.print("Enter Password: ");
            String pass = scan.nextLine();

            
            String sql = "UPDATE login SET users = ?, email = ?, mobile = ?, pass = ? WHERE id = 18";
            try (PreparedStatement psment = con.prepareStatement(sql)) {
                psment.setString(1, name);
                psment.setString(2, email);
                psment.setString(3, mobile);
                psment.setString(4, pass);

                int rowsUpdated = psment.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Update Successful!");
                } else {
                    System.out.println("Update Failed.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

