package week2;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Dog barks");
    }
}

class Puppy extends Dog {
    public void play() {
        System.out.println("Puppy plays");
    }
}

public class AnimalDogPuppy {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();
        
        Dog dog = new Dog();
        dog.makeSound();
        dog.bark();
        
        Puppy puppy = new Puppy();
        puppy.makeSound();
        puppy.bark();
        puppy.play();
    }
}

