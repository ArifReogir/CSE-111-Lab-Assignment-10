/*Design the Dragon class and Phoenix class derived from the MagicalCreature class so that the following output is produced. */

public class MagicalTester { // Driver code
    public static void main(String[] args) {
        Dragon drake = new Dragon("Drake", 500, 75);
        Phoenix fawkes = new Phoenix("Fawkes", 200, 5);
        drake.displayInfo();
        drake.makeSound();
        drake.performMagic();
        drake.fly();
        System.out.println("=====================");
        fawkes.displayInfo();
        fawkes.makeSound();
        fawkes.performMagic();
        fawkes.regenerate();
    }
}

// Class starts here

class MagicalCreature { // Parent class
    public String name;
    public int age;

    public MagicalCreature(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println(name + " makes a magical sound.");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + "\nAge: " + age);
    }

    public void performMagic() {
        System.out.println(name + " performs a generic magic.");
    }
}

class Dragon extends MagicalCreature { // Child class
    public int power;

    public Dragon(String name, int age, int power) {
        super(name, age);
        this.power = power;
    }

    public void displayInfo() {
        super.displayInfo();
    }

    public void makeSound() {
        System.out.println(name + " roars with a fiery breath!");
    }

    public void performMagic() {
        System.out.println(name + " breathes fire with power level: " + power);
    }

    public void fly() {
        System.out.println(name + " flies through the sky.");
    }
}

class Phoenix extends MagicalCreature {
    public int cycle;

    public Phoenix(String name, int age, int cycle) {
        super(name, age);
        this.cycle = cycle;
    }

    public void displayInfo() {
        super.displayInfo();
    }

    public void makeSound() {
        System.out.println(name + " sings an enchanting song.");
    }

    public void performMagic() {
        System.out.println(name + " is reborn with " + cycle + " rebirth cycles.");
    }

    public void regenerate() {
        System.out.println(name + " regenerates its body in a burst of flames.");
    }
}
