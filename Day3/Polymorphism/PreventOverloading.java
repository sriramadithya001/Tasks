class Car {
    public int speed(int x) {
	return x;
    }

    public int speed(int x,int y) {
	return x*y;
    }
}


public class PreventOverloading {
    public static void main(String[] args) {
	Car car = new Car();
	int speed1 = car.speed(10), speed2 = car.speed(10,10);
	System.out.print(speed1 + " " + speed2);
    }
}