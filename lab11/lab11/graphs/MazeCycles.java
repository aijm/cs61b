package lab11.graphs;

import edu.princeton.cs.algs4.Edge;

import java.awt.*;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private boolean cycleFound;
    private DisjointSet ds;
    private Maze maze;
    private int[] parent;
    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        cycleFound = false;
        ds = new DisjointSet(maze.V());
        parent = new int[maze.V()];
        parent[0] = 0;
        distTo[0] = 0;
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        dfs(0);

    }
    public void dfs(int v){
        marked[v] = true;
        announce();
        if(cycleFound){
            return;
        }
        for(int w : maze.adj(v)){
            if(marked[w] && w != parent[v]){
                cycleFound = true;
                parent[w] = v;
                connectCycle(w);
                return;
            }else if(!marked[w]){
                parent[w] = v;
                distTo[w] = distTo[v] + 1;
                dfs(w);
                if(cycleFound){
                    return;
                }
            }
        }

    }
    public void connectCycle(int v){
        int w = v;
        while(true){
            edgeTo[w] = parent[w];
            w = parent[w];
            announce();
            if(w == v){
                break;
            }
        }
    }

    // Helper methods go here
    private class DisjointSet{
        private int[] parent;
        private int[] size;
        // constructor
        public  DisjointSet(int N){
            parent = new int[N];
            size = new int[N];
            for(int i = 0;i < N;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        // find the root of current tree
        int find(int p){
            if(parent[p] == p){
                return p;
            }
            parent[p] = find(parent[p]);
            return parent[p];
        }
        // check whether p,q is connected
        public boolean isConnected(int p, int q){
            return find(p) == find(q);
        }
        // connect p q
        public void connect(int p, int q){
            int i = parent[p];
            int j = parent[q];
            if(size[i] < size[j]){
                parent[i] = j;
                size[j] += size[i];
            }else{
                parent[j] = i;
                size[i] += size[j];
            }
        }

    }
}

