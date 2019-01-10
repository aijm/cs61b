import java.util.Random;
import static org.junit.Assert.*;

/**
 * represent every set as a tree,
 * for every item, record their parent's index
 */
public class WeightedQuickUnionDSWithPathCompression implements DisjointSet {

    private int[] parent;
    private int[] size;

    public WeightedQuickUnionDSWithPathCompression(int N){
        parent = new int[N];
        size = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    /**
     * find root of p by recursion,
     * for items in the path, set the parent to the root
     * */
    private int find(int p){
        if(parent[p] == p){
            return p;
        }
        parent[p] = find(parent[p]);
        return parent[p];
    }
    @Override
    public void Connect(int p, int q){
        /** find the parent of each item */
        int i = find(p);
        int j = find(q);
        /** union: merge two tree depends on size*/
        // add the smaller tree to bigger tree
        // then the depth of tree <= log(N)
        if(size[i] < size[j]){
            parent[i] = j;
            size[j] += size[i];
        }else{
            parent[j] = i;
            size[i] += size[j];
        }
    }
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
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

        WeightedQuickUnionDSWithPathCompression set = new WeightedQuickUnionDSWithPathCompression(N);
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

