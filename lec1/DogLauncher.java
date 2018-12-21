/** The DogLauncher class 'test drive' the Dog class */
public class DogLauncher{
    
    public static void main(String[] args){
        Dog smallDog; // Declaration of a Dog variable
        new Dog(20); // Instantiation of the Dog class as a Dog object
        smallDog = new Dog(5); // Instantiation and Assignment
        Dog hugeDog = new Dog(150); // Declaration, Instantiation and Assignment

        Dog bigger = Dog.maxDog(smallDog, hugeDog); 

        smallDog.makeNoise();
        hugeDog.makeNoise();
        bigger.makeNoise();
        System.out.println(Dog.binomen);

    }
}