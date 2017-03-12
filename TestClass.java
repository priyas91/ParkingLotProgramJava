package VehicleParking;

import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {

		ParkingLot pLot = new ParkingLot();

		String inp = "";

		Scanner input = new Scanner(System.in);

		System.out.println("The empty parking lot\n");
		System.out.println(pLot.toString());

		System.out.print("Please enter bus, car, or motorcycle a vehicle (enter 0 to exit): ");
		inp = input.next();

		while (!inp.equals("0")) {
			if (inp.equals("Bus") || inp.equals("bus")) {

				Bus b = new Bus();

				if (pLot.parkVeh(b)) {
					System.out.println("\nThe bus has been parked successfully.");
					System.out.println(pLot.toString());

					System.out.print("Please enter bus, car, or motorcycle to park a vehicle (enter 0 to exit): ");
					inp = input.next();
				} else {

					System.out.println("\nParking Failed: Bus spots are full");

					System.out.print("Please enter car or motorcycle to park a vehicle (enter 0 to exit): ");
					inp = input.next();
				}
			} else if (inp.equals("Car") || inp.equals("car")) {

				Car c = new Car();

				if (pLot.parkVeh(c)) {

					System.out.println("\nThe car has been parked successfully.");

					System.out.println(pLot.toString());

					System.out.print("Please enter bus, car, or motorcycle to park a vehicle (enter 0 to exit): ");
					inp = input.next();
				} else {

					System.out.println("\nParking Failed: large spots are full");

					System.out.print("Please enter bus or motorcycle to park a vehicle (enter 0 to exit): ");
					inp = input.next();
				}
			} else if (inp.equals("Motorcycle") || inp.equals("motorcycle")) {

				MotorCycle m = new MotorCycle();

				if (pLot.parkVeh(m)) {

					System.out.println("\nThe motorcycle has been parked successfully.");

					System.out.println(pLot.toString());

					System.out.print("Please enter bus, car, or motorcycle to park a vehicle : ");
					inp = input.next();

				} else {

					System.out.println("\nParking Failed: Motorcycle spots are full");

					System.out.print("Please enter Bus or car to park a vehicle (enter 0 to exit): ");
					inp = input.next();
				}
			} else {

				System.out.println("\nInvalid input.");

				System.out.print("\nPlease enter bus, car, or motorcycle to park a vehicle (enter 0 to exit): ");
				inp = input.next();
			}

			if (inp.equals("0")) {
				System.out.print("\nProgram terminated");
				break;
			}
		}
	}
}
