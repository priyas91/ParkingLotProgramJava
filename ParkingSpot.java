package VehicleParking;

import java.util.logging.Level;

public class ParkingSpot {

	private int row;
	private int numberOfSpots;
	private VehicleSize sizeOfSpot;
	private Level lv;
	private Vehicle veh;
	
	public ParkingSpot(){
		
	}
	
	
	
	public ParkingSpot(int row2, int count, VehicleSize siz) {
		
		row=row2;
		numberOfSpots=count;
		sizeOfSpot= siz;
	}

	

	public int getSptNum(){
		return numberOfSpots;
	}
	
	public int getRow(){
		return row;
	}
	
	
	

	public VehicleSize getSize() {
		
		return sizeOfSpot;
	}
	
	public boolean isAvailable(){
		return (veh ==null);
	}
	
	public boolean fitVehicle(Vehicle veh){
		return veh.canFitSpot(this)&& isAvailable();
	}
 public boolean parkVehicle(Vehicle ve){
	 if(!fitVehicle(ve)){
		 return false;
	 }
	 veh =ve;
	 veh.parkSpots(this);
	 return true;
 }
 
 public void rvVehicle(){
 }
 
 public String toString(){
	 StringBuilder sb= new StringBuilder();
	 
	 if(!isAvailable()){
		 if(veh.getSize()==VehicleSize.Large){
			 sb.append('B');
		 }
		 else if(veh.getSize()==VehicleSize.Car){
			 sb.append('C');
		 }
		 else{
			 sb.append('M');
		 }
	 }
		 else{
			 if(sizeOfSpot==VehicleSize.Large){
				 sb.append('l');
				 
			 }
			 else if(sizeOfSpot==VehicleSize.Car){
				 sb.append('c');
				 
			 }
			 else{
				 sb.append('m');
			 }
		 }
		 
	 return sb.toString();
	 }
}
	


