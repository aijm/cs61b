package lab11.graphs;

import edu.princeton.cs.algs4.LinkedQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private Maze maze;
    ConcurrentLinkedQueue<Integer> q; // using queue to do bfs


    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        q = new ConcurrentLinkedQueue<>();
        q.add(s);
        marked[s] = true;

    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        while(!q.isEmpty()){
            int v = q.remove();
            if(v == t){
                return;
            }
            for(int w : maze.adj(v)){
                if(!marked[w]){
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    announce();
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs();
    }
}

