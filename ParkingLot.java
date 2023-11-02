import java.util.Scanner;
import java.util.HashMap;
import java.time.*;  
import java.time.format.*;
import java.io.*; 

class Parking {
    static int id;
    int parking_id;
    int vehicle_type;
    int vehicle_no;
    int parking_row;
    int parking_col;
    LocalDateTime entry;
    LocalDateTime exit;
    int cost;

    Parking(int vehicle_type, int vehicle_no, int parking_row,int parking_col) {
	this.parking_id = ++id;
	this.vehicle_type = vehicle_type;
	this.vehicle_no = vehicle_no;
	this.parking_row = parking_row;
	this.parking_col = parking_col;
	this.entry = LocalDateTime.now();
	this.exit = null;
	this.cost = 0;
    }
}

public class ParkingLot {
    public static void main(String[] args) {
	System.out.println("\t\tPARKING LOT");
	Scanner sc = new Scanner(System.in);
	boolean[][] lot = new boolean[5][5];
	HashMap<Integer, Parking> parkings = new HashMap<>();

	boolean back = false;
	while(!back) {
	    System.out.println("1. Park Vehicle");
	    System.out.println("2. Exit Vehicle");
	    System.out.println("3. Vehicle Slot");
	    System.out.println("4. Back");
	    System.out.print("Enter an option : ");
	    int option = sc.nextInt();
	    switch(option) {
		case 1:
		{
		    System.out.print("1. Vehicle Type - [1. Two Wheeler 2. Car] : ");
		    int vehicle_type = sc.nextInt();
		    System.out.print("2. Vehicle_No : ");
		    int vehicle_no = sc.nextInt();

		    int parking_row = -1, parking_col = -1;
		    for(int i=0;i<5;i++) {
			if(parking_row!=-1) break;
			for(int j=0;j<5;j++) if(lot[i][j]==false) {parking_row = i;parking_col = j;break;}
			}
		    if(parking_row==-1) System.out.println("No slots available");
		    else {
			lot[parking_row][parking_col] = true;
			Parking parking = new Parking(vehicle_type,vehicle_no,parking_row,parking_col);
			parkings.put(vehicle_no, parking);
			System.out.println("Vehicle parked successfully");
		    }
		}
		break;
		case 2:
		{
		    System.out.print("Enter your vehicle_no : ");
		    int vehicle_no = sc.nextInt();
		    if(parkings.get(vehicle_no)==null) System.out.println("Vehicle not found");
		    else {
			Parking parking = parkings.get(vehicle_no);
			lot[parking.parking_row][parking.parking_col] = false;
			parking.exit = LocalDateTime.now();
      			Duration duration = Duration.between(parking.entry, parking.exit);  
      			int hours = (int) duration.toSeconds();
			if(parking.vehicle_type==1) parking.cost = 5 * hours;
			else if(parking.vehicle_type==2) parking.cost = 10 * hours;

			System.out.println("Duration : " + hours + " " + "Cost : " + parking.cost);
			System.out.println("Vehicle exited successfully");



			File ExitVehicleFile = new File("C:\\Users\\Administrator\\Desktop\\sriram\\Test\\L3Test\\ExitVehicles.txt");
			try(FileWriter writer = new FileWriter(ExitVehicleFile,true)) {
			    String vehicle_info = "Parking ID : " + parking.parking_id + "\n" + "Vehicle Type : " + (parking.vehicle_type==1 ? "Two-Wheeler" : "Car") + "\n" + "Vehicle no : " + parking.vehicle_no + "\n" + "Duration : " + hours + " seconds" + "\n" + "Cost : " + parking.cost + "$\n\n";
			    writer.write(vehicle_info);
			    writer.close();
			}
			catch(Exception e) {
			    System.out.println("An error occured in file");
			}
		    }		    
		}
		break;
		case 3:
		{
		    System.out.print("Enter your vehicle_no : ");
		    int vehicle_no = sc.nextInt();
		    if(parkings.get(vehicle_no)==null) System.out.println("Vehicle not found");
		    else {
			char lot_name = 'A';lot_name += parkings.get(vehicle_no).parking_row;
			System.out.println(parkings.get(vehicle_no).parking_row);
			System.out.println("Vehicle is parked in " + lot_name + (parkings.get(vehicle_no).parking_col+1));
		    }
		}
		break;
		case 4:
		{
		    System.out.println("Exiting the Application");
		    back = true;
		}
		break;
		default:
		    System.out.println("Enter a valid option");
	    }
	}
    }
}