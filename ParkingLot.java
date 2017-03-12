package VehicleParking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ParkingLot {
	private Level[] lvls;
	private final int number_of_levels = 5;

	public ParkingLot() {
		lvls = new Level[number_of_levels];
		for (int count = 0; count < number_of_levels; count++) {
			lvls[count] = new Level(count, 30);
		}
	}

	public boolean parkVeh(Vehicle veh) {

		for (int count = 0; count < lvls.length; count++) {
			if (lvls[count].parkVeh(veh)) {

				return true;
			}
		}
		return false;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (int count = 0; count < number_of_levels; count++) {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/parking_lot","root","root");  
			  
			Statement stmt=con.createStatement();  
			
            stmt= con.createStatement();
           
            String sql="update levels set parking_data='"+lvls[count]+"' where count='"+count+"'";
            int val= stmt.executeUpdate(sql);  
            
            
            con.close();
            stmt.close();
			}catch(Exception e){ System.out.println(e);}  
			
        sb.append("Level " + count + ": " + lvls[count] + "\n");
	 
	}

		return sb.toString();

	}
}
