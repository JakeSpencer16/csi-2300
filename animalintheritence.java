
public class animalintheritence {
    public int age;
    public String gender;

    public boolean isMammal() {
        System.out.println(); // for formatting purpose only
        System.out.println("This is the isMammal() method from the Animal class.");
        return true; // Assuming all animals in this example are mammals
    }

    public void mate() {
        System.out.println("This is the mate() method from the Animal class.");
    }

    public static void main(String[] args) {
        animalintheritence myAnimal = new animalintheritence();
        Fish myFish = new Fish();
        Zebra myZebra = new Zebra();

        // Calling methods from Animal class
        myAnimal.isMammal();
        myAnimal.mate();

        // Calling methods from Zebra class
        myZebra.is_wild = true; // Setting the is_wild field
        myZebra.run();

        // Calling the public method in Fish class, which in turn calls the private method
        myFish.eat(); 
    }
}

class Fish extends animalintheritence {
    @SuppressWarnings("unused")
    private double sizeInFeet;

    private void canEat() {
        System.out.println("This is the private canEat() method from the Fish class.");
        System.out.println(); // for formatting purpose only
    }

    public void eat() {
        canEat(); // Call the private method from within the public method
    }
}

class Zebra extends animalintheritence {
    public boolean is_wild;

    public void run() {
        System.out.println("This is the run() method from the Zebra class.");
    }
}
