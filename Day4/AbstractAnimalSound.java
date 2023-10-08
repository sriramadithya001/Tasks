abstract class Animal {
    public abstract void sound();
}

class Cat extends Animal {
    public void sound() {
        System.out.println("Cat Meow");
    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("Dog bark");
    }
}

public class AbstractAnimalSound {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        
        cat.sound();
        dog.sound();
    }
}