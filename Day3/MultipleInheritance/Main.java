/*class A {
	public void fun() {
	    System.out.print('A');
	}
}

class B {
	public void fun() {
	    System.out.print('B');
	}
}

public class Main extends A,B {
	public static void main(String[] args) {
	    Main m = new Main();
	    m.fun();
	} 
}*/

interface A {
    void fun();
}


interface B {
    void fun(int x);
}

class Test implements A,B {
    public void fun() {
	System.out.println("fun");
    }
    public void fun(int x) {
	System.out.println(x);
    }
}

public class Main {
    public static void main(String[] args) {
	Test test = new Test();
	test.fun();
	test.fun(3);
    }
}