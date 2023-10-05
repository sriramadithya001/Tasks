import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        class Average {
            int a,b,c;
            public Average(int a,int b,int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }
            public int printAverage() {
                return (a+b+c)/3;
            }
        }
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        Average average1 = new Average(a,b,c);
        average1.printAverage();
    }
}