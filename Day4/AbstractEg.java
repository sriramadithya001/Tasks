abstract class Parent {
    public abstract void message();
}

class Sub1 extends Parent {
    public void message() {
        System.out.println("This is the first subclass");
    }
}

class Sub2 extends Parent {
    public void message() {
        System.out.println("This is the second subclass");
    }
}

public class AbstractEg {
    public static void main(String[] args) {
        Sub1 sub1 = new Sub1();
        Sub2 sub2 = new Sub2();
        sub1.message();
        sub2.message();
    }
}