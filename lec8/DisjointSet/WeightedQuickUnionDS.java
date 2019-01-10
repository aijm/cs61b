import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * represent every set as a tree,
 * for every item, record their parent's index
 */
public class WeightedQuickUnionDS implements DisjointSet {

    private int[] parent;
    private int[] size;

    public WeightedQuickUnionDS(int N){
        parent = new int[N];
        size = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    /**
     * find the parent of p,
     * search time depends on the depth of tree
     * */
    private int find(int p){
        while(p!=parent[p]){
            p = parent[p];
        }
        return p;
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

        WeightedQuickUnionDS set = new WeightedQuickUnionDS(N);
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
