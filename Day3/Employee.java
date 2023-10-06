public class Employee {
    public static void main(String[] args) {
        class createEmployee {
            String name;
            int year_of_joining;
            int salary;
            String address;
            
            public createEmployee(String name, int year_of_joining, int salary, String address) {
                this.name = name;
                this.year_of_joining = year_of_joining;
                this.salary = salary;
                this.address = address;
            }
            
            public void printEmployee() {
                System.out.println(this.name + "\t" + this.salary + "\t" + this.year_of_joining + "\t" + this.address);
            }
            
        }
        createEmployee employee_1 = new createEmployee("john",30000, 2012, "XYZ Street");
        createEmployee employee_2 = new createEmployee("kumar",35000, 2013, "XYY Street");
        createEmployee employee_3 = new createEmployee("johny",33000, 2012, "YYZ Street");
        
        System.out.println("Name\tsalary\tYear_of_joining\tAddress");
        employee_1.printEmployee();
        employee_2.printEmployee();
        employee_3.printEmployee();
    }
}
