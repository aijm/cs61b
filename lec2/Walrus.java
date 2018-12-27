public class Walrus{
    public int weight;
    public double size;

    public Walrus(int w, double s){
        weight = w;
        size = s;
    }

    public static void main(String[] args){
        Walrus a = new Walrus(1000, 8.3);
        Walrus b;
        b = a;
        b.weight = 5;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.weight);
        System.out.println(b.weight);
        
    }
}