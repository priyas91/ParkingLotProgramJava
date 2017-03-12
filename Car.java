package VehicleParking;

public class Car extends Vehicle{
	
	public Car(){
		numberOfSpots=1;
		size= VehicleSize.Car;
	}
	
	

	public boolean canFitSpot(ParkingSpot spt) {
		
		return spt.getSize() == VehicleSize.Large || spt.getSize()==VehicleSize.Car;
	}
	

	}

