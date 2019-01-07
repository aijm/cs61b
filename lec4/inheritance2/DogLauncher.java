public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("Elyse", 3);
        Dog d2 = new Dog("Sture", 9);
        Dog d3 = new Dog("Benjamin", 15);
        Dog d4 = new Dog("Zoom", 5);
        Dog[] dogs = new Dog[]{d1, d2, d3, d4};

//        Dog d = (Dog) Maximizer.max(dogs);
//        Dog d = Maximizer.max1(dogs,Dog.getNameComparator());
        Dog d = Maximizer.max1(dogs, new Dog("a",1));
        System.out.println(d.name);
    }
}
