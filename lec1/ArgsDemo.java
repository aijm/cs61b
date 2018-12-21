public class ArgsDemo{
    /** Prints out the sum of all args. */
    public static void main(String[] args){
        double sum = 0;
        int i=0;
        System.out.println(args.length);
        while(i<args.length){
            sum =sum + Integer.parseInt(args[i]);
            i = i+1;
        }
        System.out.println(sum);
    }
}