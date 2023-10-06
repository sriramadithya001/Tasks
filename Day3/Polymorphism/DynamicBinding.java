class Parent {
    public void func() {
	System.out.println("Parent class");
    }
}

class Child extends Parent {
    public void func() {
	super.func();
	System.out.println("Child class");
    }
}

public class DynamicBinding {
    public static void main(String[] args) {
	Child child = new Child();
	child.func();
    }
}