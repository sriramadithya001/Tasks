class Person {
    String name;
    int age;

    public Person(String name, String age) {
	this.name = name;
	this.age = age;
    }
}

class Patient extends Person{
    String disease;

    public Patient(String name, String age,String disease) {
	this.name = name;
	this.age = age;
	this.disease = disease;
    }
}

class Doctor extends Person{
    String speacalist;

    public Doctor(String name, String age,String specailist) {
	this.name = name;
	this.age = age;
	this.disease = disease;
    }
}

class Nurse extends Person{

     public Nurse(String name, String age) {
	this.name = name;
	this.age = age;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
	Doctor Doctor = new Doctor("john",35,"kidney specalist");
        Patient patient = new Patient("watson", 33, "kidney stone");
	Nurse nurse = new Nurse("Helen",23);
    } 
}