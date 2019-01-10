import java.util.Random;
import static org.junit.Assert.*;

public class QuickFindDS implements DisjointSet{
    private int[] id;

    public QuickFindDS(int N){
        id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
        }
    }
    @Override
    public void Connect(int p, int q){
        if(id[p] == id[q]){
            return;
        }
        for(int i=0;i<id.length;i++){
            if(id[i] == id[p]){
                id[i] = id[q];
            }
        }
    }
    @Override
    public boolean isConnected(int p, int q){
        return id[p] == id[q];
    }

    public static void main(String[] args){
        int N = 10000;
        int M = 1000;
        try {
            N = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
        }catch (Exception e){
            System.out.println("Usage: QuickFindDS N M");
        }

        QuickFindDS set = new QuickFindDS(N);
        for(int i = 0;i< M;i++){
            Random r = new Random();
            int p = r.nextInt(N);
            int q = r.nextInt(N);
            set.Connect(p, q);
            assertTrue(set.isConnected(p, q));
        }
//        System.out.println(set.isConnected(0,100));
    }
}

