package VehicleParking;

import VehicleParking.ParkingSpot;

public class Level {

	private ParkingSpot[] spts;
	private int availableSpots = 0;
	private static final int Spots_Per_row = 10;

	public Level() {

	}

	public Level(int flr, int numofSpots) {
		int smallSpts = 0;
		int mediumSpts = 0;
		int largeSpts = 0;
		int spots = 0;
		int row = 0;

		availableSpots = numofSpots;
		spts = new ParkingSpot[numofSpots];

		smallSpts = numofSpots / 3;
		largeSpts = numofSpots / 3;
		mediumSpts = numofSpots - smallSpts - largeSpts;
		spots = mediumSpts + largeSpts;

		for (int count = 0; count < numofSpots; count++) {

			VehicleSize sz = VehicleSize.Bike;

			if (count < largeSpts) {
				sz = VehicleSize.Large;
			} else if (count < spots) {
				sz = VehicleSize.Car;
			}

			row = count / Spots_Per_row;

			spts[count] = new ParkingSpot(row, count, sz);
		}
	}

	public int availSpts() {

		return availableSpots;
	}

	public boolean parkVeh(Vehicle veh) {

		int sptNum = fiAvaSpts(veh);

		if (availSpts() < veh.getSpotsNeeded()) {

			return false;
		}

		if (sptNum < 0) {

			return false;
		}

		return parkSAtSpot(sptNum, veh);
	}

	private boolean parkSAtSpot(int numb, Vehicle veh) {

		boolean succ = true;

		for (int count = numb; count < (Vehicle.numberOfSpots + numb); count++) {
			succ = succ & spts[count].parkVehicle(veh);
		}
		availableSpots = availableSpots - Vehicle.numberOfSpots;

		return succ;
	}

	private int fiAvaSpts(Vehicle veh) {

		int sptNeeded = veh.getSpotsNeeded();
		int lastR = -1;
		int sptsFd = 0;
		int sptMOne = 0;

		for (int count = 0; count < spts.length; count++) {

			ParkingSpot spt = spts[count];

			if (lastR != spt.getRow()) {
				sptsFd = 0;
				lastR = spt.getRow();
			}

			if (spt.fitVehicle(veh)) {
				sptsFd++;
			} else {
				sptsFd = 0;
			}

			sptMOne = sptNeeded - 1;

			if (sptsFd == sptNeeded) {
				return (count - sptMOne);
			}
		}
		return -1;
	}

	public void frSpt() {

		availableSpots++;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int count = 0; count < spts.length; count++) {
			if (count == 10 || count == 20) {
				sb.append(" ");
			}

			sb.append(spts[count]);
		}
		return sb.toString();
	}
}
