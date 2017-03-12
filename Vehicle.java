package VehicleParking;

import java.util.ArrayList;

public abstract class Vehicle {
	
	protected static int numberOfSpots;
	protected VehicleSize size;
	protected String licenseNumber;
	protected static ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	public VehicleSize getSize(){
		return size;
	}
	public int getSpotsNeeded(){
		return numberOfSpots;
	}
	public void parkSpots(ParkingSpot s){
		parkingSpots.add(s);
	}
	public abstract boolean canFitSpot(ParkingSpot spt);
		
	
}
