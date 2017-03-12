package VehicleParking;

public class Bus extends Vehicle{
      public Bus(){
    	  numberOfSpots=5;
    	  size= VehicleSize.Large;
      }
	public boolean canFitSpot(ParkingSpot spt) {
		
		return spt.getSize()== VehicleSize.Large;
	}
	

}
