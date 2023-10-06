class Car {
    public final int speed(int x) {
	return x;
    }
}

class BMW extends Car{
    public int speed(int x) {
	return x*100;
    }
}


public class PreventOverriding {
    public static void main(String[] args) {
	BMW bmw = new BMW();
	int bmw_speed = bmw.speed(100);
	System.out.print(bmw_speed);
    }
}