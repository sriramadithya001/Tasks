class Parent {
    public void func() {
	System.out.println("Parent class");
    }
}

class Child {
    public void func() {
	System.out.println("Child class");
    }
}

public class StaticBinding {
    public static void main(String[] args) {
	Parent parent = new Parent();
	parent.func();
    }
}