import java.util.Comparator;

public class Dog implements Comparator<Dog>{
    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }
//    @Override
//    public int compareTo(Dog d){
//        return size - d.size;
//    }
    @Override
    public int compare(Dog d1,Dog d2){
        return d1.size-d2.size;
    }

//    public static class NameComparator implements Comparator<Dog>{
//        @Override
//        public int compare(Dog d1, Dog d2){
//            return d1.name.compareTo(d2.name);
//        }
//    }
//
//    public static Comparator<Dog> getNameComparator(){
//        return new NameComparator();
//    }
//    @Override
//    public int compareTo(Dog d){
//        return size - d.size;
//    }
//    @Override
//    public int compareTo(Object o){
//        Dog d = (Dog) o;
//        return size - d.size;
//    }



    public void bark() {
        System.out.println(name + " says: bark");
    }
}