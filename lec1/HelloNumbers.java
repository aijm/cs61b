public class HelloNumbers{
    public static void main(String[] args){
        int N = 9;
        int i=0;
        int sum = 0;
        while(i<=N){
            sum = sum + i;
            System.out.println(sum);
            i = i+1;
        }
    }
}