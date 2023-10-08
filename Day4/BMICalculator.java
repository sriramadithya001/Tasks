import BMIPackage.BMI;
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        double height = sc.nextDouble();
        BMI bmi = new BMI(height,weight);
        System.out.println(bmi.calculate());
    }
}