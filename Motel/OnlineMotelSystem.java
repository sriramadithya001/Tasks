import java.util.*;
import java.io.*;
import java.time.*;

class Booking {
    static int id;
    int booking_id;
    String Aadhar_no;
    int floor_no;
    int room_no;
    boolean AC;
    int bed_room;
    LocalDateTime In;
    LocalDateTime Out;

    Booking(String Aadhar_no ,int floor_no, int room_no, boolean AC, int bed_room, LocalDateTime In, LocalDateTime Out) {
	this.booking_id = ++id;
	this.Aadhar_no = Aadhar_no;
	this.floor_no = floor_no;
	this.room_no = room_no;
	this.AC = AC;
	this.bed_room = bed_room;
	this.In = In;
	this.Out = Out;
    }
}

class User {
    static int id;
    int user_id;
    String name;
    String password;
    String Aadhar_no;
    String mobile_no;

    User(String name,String password,String Aadhar_no,String mobile_no) {
	this.user_id = ++id;
	this.name = name;
	this.password = password;
	this.Aadhar_no = Aadhar_no;
	this.mobile_no = mobile_no;
    }
}

class Room {
    int floor_no;
    static int id;
    int room_id;
    boolean AC;
    int bed_cnt;
    int booking_cnt;
    boolean freeze;
    HashMap<Integer,Booking> room_bookings = new HashMap<>();

    Room(int floor_no,boolean AC, int bed_cnt) {
	this.floor_no = floor_no;
	this.room_id = ++id;
	this.AC = AC;
	this.bed_cnt = bed_cnt;
	this.booking_cnt = 0;
	this.freeze = false;
    }
}

class Admin {


    static String small = "abcdefghijklmnopqrstuvwxyz" , large = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" , num = "0123456789";

    static File credentialdb = new File("C:\\Users\\Administrator\\Desktop\\sriram\\Practice\\L3\\Motel\\credentialdb.txt");
    static File roomdb = new File("C:\\Users\\Administrator\\Desktop\\sriram\\Practice\\L3\\Motel\\roomdb.txt");

    static HashMap<Integer,User> users = new HashMap<>();
    static HashMap<Integer,ArrayList<Room>> floors = new HashMap<>();

    static void bookRoom() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter Aadhar number : ");
	String aadhar = sc.next();
	
	try {
	    Scanner reader = new Scanner(credentialdb);
	    User booker = null;
	    while(reader.hasNextLine()) {
		String[] user_data = reader.nextLine().split(" ");
		int u_id = Integer.parseInt(user_data[0]); String u_aadhar = user_data[2];
		if(u_aadhar.equals(aadhar)) {
		    booker = users.get(u_id);
		}
	    }
	    reader.close();
	}
	catch(Exception e) {
	    System.out.println("An error occured in credentialDB file");
	}

        if(booker != null) {
	    System.out.print("Enter floor no : ");
	    int floor_no = sc.nextInt();
	    System.out.print("AC [1 , 2] : ");
	    boolean ac = (sc.nextInt()==1 ? true : false);
	    System.out.print("Bedroom [1 , 2] : ");
	    int bed = sc.nextInt();

	    int room_id = -1;
	    try {
	        Scanner reader = new Scanner(roomdb);
	        while(reader.hasNextLine()) {
		    String[] room_data = reader.nextLine().split(" ");
		    if(room_data[0] == floor_no && room_data[2]==ac && room_data[3]==bed) room_id = room_data[1];
		    
	        }
	        reader.close();
	    }
	    catch(Exception e) {
	        System.out.println("An error occured in roomdb");
	    }

	    if(room_id==-1) {
		for(int f=1;f<=5;f++) {
		    for(int r=0;r<5;r++) {
		 	if(floors.get(f).get(r).freeze==false) room_id = floors.get(f).get(r).room_id;
		    }
	    	}
	    }

	    if(room_id==-1) System.out.println("No available rooms");
	    else {
	        for(int f=1;f<=5;f++) {
	            for(int r=0;r<5;r++) {
	                if(floors.get(f).get(r).room_id==room_id) floors.get(f).get(r).freeze = true; 
		    }
	        }
		Booking booking = new Booking(aadhar,floor_no,room_id,ac,bed,LocalDateTime.now(),null);
		bookings.put(booking);
	    }
	}
	else System.out.println("User not found");


    }

    
    static void changeRoom() {

    }

    static void leaveRoom() {

    }

    static void signedIn(User user) {
	Scanner sc = new Scanner(System.in);
	System.out.println("1. Book Room");
	System.out.println("2. Change Room");
	System.out.println("3. Leave Room");
	System.out.println("0. Back");
	System.out.print("Enter your option : ");
	int option = sc.nextInt();
	

	switch(option) {
	    case 1:
		bookRoom();
	        break;
	    case 2:
	        changeRoom();
	        break;
	    case 3:
	        leaveRoom();
	        break;
	    case 0:
	        OnlineMotelSystem.homepage();
	        break;
	}
    }


    static void signIn() {
	Scanner sc =new Scanner(System.in);
	System.out.print("Enter your name : ");
	String name = sc.next();
	System.out.print("Enter your password : ");
	String password = sc.next();

	boolean user_found = false;
	
	try {
	    Scanner reader = new Scanner(credentialdb);
	    while(reader.hasNextLine()) {
		String[] user_data = reader.nextLine().split(" ");
		int u_id = Integer.parseInt(user_data[0]); String u_name = user_data[1] , u_password = decrypt(user_data[2]);
		if(u_name.equals(name) && u_password.equals(password)) {
		    signedIn(users.get(u_id));
		    user_found = true;
		}
	    }
	    reader.close();
	}
	catch(Exception e) {
	    System.out.println("An error occured in credentialDB file");
	}

        if(!user_found) System.out.println("User not found");
    }


    static void signUp() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter your name : ");
	String name = sc.next();
	System.out.print("Enter your password : ");
	String password = sc.next();
	System.out.print("Enter your Aadhar no : ");
	String Aadhar_no = sc.next();
	System.out.print("Enter your mobile no : ");
	String mobile_no = sc.next();
	User user = new User(name,encrypt(password),Aadhar_no,mobile_no);
        users.put(user.user_id , user);
  	writeUser(user);
    }



    static String encrypt(String password) {
	String encrypted = "";
	for(int i=0;i<password.length();i++) {
	    char c = password.charAt(i);
	    if('a'<=c && c<='z') {
		if(c=='z') encrypted += 'a';
		else encrypted += small.charAt(small.indexOf(c)+1);
	    }
	    else if('A'<=c && c<='Z') {
		if(c=='Z') encrypted += 'A';
		else encrypted += large.charAt(large.indexOf(c)+1);
	    }
	    else if('0'<=c && c<='9') {
		if(c=='9') encrypted += '0';
		else encrypted += num.charAt(num.indexOf(c) + 1);
	    }
	}
	return encrypted;
    }

    static String decrypt(String password) {
	String decrypted = "";
	for(int i=0;i<password.length();i++) {
	    char c = password.charAt(i);
	    if('a'<=c && c<='z') {
		if(c=='a') decrypted += 'z';
		else decrypted += small.charAt(small.indexOf(c)-1);
	    }
	    else if('A'<=c && c<='Z') {
		if(c=='A') decrypted += 'Z';
		else decrypted += large.charAt(large.indexOf(c)-1);
	    }
	    else if('0'<=c && c<='9') {
		if(c=='0') decrypted += '9';
		else decrypted += num.charAt(num.indexOf(c)-1);
	    }
	}
        return decrypted;
    }

    static void writeUser(User user) {
	    try(FileWriter writer = new FileWriter(credentialdb , true)) {
	        String user_data = user.user_id + " " + user.name + " " + user.password + " " + user.mobile_no + " " + user.password + "\n";
		writer.write(user_data);
		writer.close();
	    }
	    catch(Exception e) {
	        System.out.println("An error occured in credentialDB file");
	    }
    }

    static void displayRooms() {
	System.out.println("Floor No	Room Id    AC    BedRoom    BookingCnt");
	try {
	    Scanner reader = new Scanner(roomdb);
	    while(reader.hasNextLine()) {
		System.out.println(reader.nextLine());
	    }
	    reader.close();
	}
	catch(Exception e) {
	    System.out.println("An error occured in roomdb");
	}
    }
}

public class OnlineMotelSystem {

    static void homepage() {
	Scanner sc = new Scanner(System.in);
	boolean back = false;
	while(!back) {
	    System.out.println("1. SignUp");
	    System.out.println("2. SignIn");
	    System.out.println("0. back");
	    System.out.print("Enter an option : ");
	    int option = sc.nextInt();
	    switch(option) {
		case 1:
		    Admin.signUp();
		    break;
		case 2:
		    Admin.signIn();
		    break;
		case 0:
		    back = true;
		    break;
	    }
	}
    }


    public static void main(String[] args) {

	for(int floor=1;floor<=5;floor++) {
	    ArrayList<Room> rooms = new ArrayList<>();
	    for(int room=1;room<=5;room++) {
		if(room%2==0) rooms.add(new Room(floor,true,1));
		else rooms.add(new Room(floor,false,2));
	    }
	    Admin.floors.put(floor,rooms);
	}

	try(FileWriter writer = new FileWriter(Admin.roomdb , true)) {
	    HashMap<Integer,ArrayList<Room>> floors = Admin.floors;

	    for(int floor=1;floor<=5;floor++) {
		for(int room=1;room<=5;room++) {
		    Room cur_room = floors.get(floor).get(room-1);
		    String room_data = cur_room.floor_no + " " + cur_room.room_id + " " + cur_room.AC + " " + cur_room.bed_cnt + " " + cur_room.booking_cnt + "\n";
		    writer.write(room_data);
		}
	    }

	    writer.close();
	}
	catch(Exception e) {
	    System.out.println("An error occured in roomdb file");
	}


	homepage();
    }
}