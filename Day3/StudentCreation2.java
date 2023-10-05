public class StudentCreation2 {
    public static void main(String[] args) {
        class Student {
            String name;
            int roll_no;
            long phone_number;
            String address;
            
            public Student(String name, int roll_no,long phone_number, String address) {
                this.name = name;
                this.roll_no = roll_no;
                this.phone_number = phone_number;
                this.address = address;
            }
            
            public void printStudent() {
                System.out.println("roll_no : " + this.roll_no);
                System.out.println("phone_number : " + this.phone_number);
                System.out.println("address : " + this.address);
            }
            
        }
        Student student_1 = new Student("Sam",1,9876543211L, "XYZ Street");
        Student student_2 = new Student("John",2,1234567890L, "YYY Street");
        
        student_1.printStudent();
    }
}