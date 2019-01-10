/**
 * represent every set as a tree,
 * for every item, record their parent's index
 */
public class QuickUnionDS implements DisjointSet{
    private int[] parent;

    public QuickUnionDS(int N){
        parent = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
        }
    }
    /**
     * find the parent of p,
     * search time depends on the depth of tree
     * in the worst case, Order of growth is O(N)
     * 0
     *   1
     *      2
     *         3
     *           ...
     *                n
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
        /** union: merge two tree */
        parent[i] = j;
    }
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }
}
