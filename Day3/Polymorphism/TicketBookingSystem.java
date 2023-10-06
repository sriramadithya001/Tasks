import java.util.Scanner;

class Booker {
    public void book(Person person) {
	System.out.println("Ticket price : " + 100 + "$");
	System.out.println("Ticket booked successfully for " + person.name);
    }

// @Overloading
    public void book(int total_persons, Person persons[]) {
	System.out.println("Ticket price : " + 100*total_persons + "$");
	System.out.print("Ticket booked successfully for ");
	for(int i=1;i<=total_persons;i++) {
	    System.out.print(persons[i-1].name + (i<total_persons ? " , " : ""));
        }
	System.out.println();
    }
}

// @Overriding
class VIPTicketBooker extends Booker {
    public void book(Person person) {
	System.out.println("Ticket price : " + 400 + "$");
	System.out.println("Ticket booked successfully for " + person.name);
    }
}

class Person {
    Scanner sc = new Scanner(System.in);
    String name;
    int age;

    public Person(String name, int age) {
	this.name = name;
	this.age = age;
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	boolean exit = false;
	while(!exit) {
	    System.out.println("1. Book Ticket");
	    System.out.println("2. Group Booking");
	    System.out.println("3. VIP Ticket");
	    System.out.println("4. Exit");
	    System.out.print("Enter your option : ");
	    int option = sc.nextInt();
	    switch(option) {
		case 1:
		    {
			System.out.print("Enter your name : ");
			String name = sc.next();
			System.out.print("Enter your age : ");
			int age = sc.nextInt();
			Person person = new Person(name,age);
			Booker booker = new Booker();
			booker.book(person);
		    }
		    break;
		case 2:
		    {
			System.out.print("Total persons : ");
			int total_persons = sc.nextInt();
			Person persons[] = new Person[total_persons];
			for(int i=1;i<=total_persons;i++) {
				System.out.print("Enter name for person " + i + " : ");
				String name = sc.next();
				System.out.print("Enter age for person " + i + " : ");
				int age = sc.nextInt();
				persons[i-1] = new Person(name,age);
			}

			    	Booker booker = new Booker();
			    	booker.book(total_persons,persons);
		    }
		    break;
		case 3:
		     {

			System.out.print("Enter your name : ");
			String name = sc.next();
			System.out.print("Enter your age : ");
			int age = sc.nextInt();
			Person person = new Person(name,age);
			VIPTicketBooker bookVip = new VIPTicketBooker();
			bookVip.book(person);
		     }
		     break;
		case 4:
		    System.out.println("Thanks for visiting");
		    exit = true;
		    break;
		default:
	            System.out.println("Enter a valid option");
	    }
	}
    }
}