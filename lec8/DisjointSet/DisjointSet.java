public interface DisjointSet {
    void Connect(int p, int q);

    boolean isConnected(int p, int q);
}
