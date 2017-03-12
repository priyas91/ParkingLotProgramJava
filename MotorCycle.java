package VehicleParking;

public class MotorCycle extends Vehicle{
 public MotorCycle(){
	 numberOfSpots=1;
	 size= VehicleSize.Bike;
 }
	@Override
	public boolean canFitSpot(ParkingSpot spt) {
		
		return spt.getSize()==VehicleSize.Large || spt.getSize()==VehicleSize.Bike || spt.getSize()==VehicleSize.Car;
	}

}
