public class Discussion{
    
    /** return the nth Fibonacci number */
    public static int fib(int n){
        int f0 = 0;
        int f1 = 1;
        int i=1;
        while(i<n){
            int temp = f0+f1;
            f0 = f1;
            f1 = temp;
            i++;
        }
        return f0;
    }
    /** return the nth Fibonacci number (More efficient) */
    // public static int fib2(int n, int k, int f0, int f1){

    // }
    public static void main(String[] args) {
        int i=1;
        int N = Integer.parseInt(args[0]);
        while(i<=N){
            System.out.println(fib(i));
            i++;
        }
    }
}