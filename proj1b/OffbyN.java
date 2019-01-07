public class OffbyN implements CharacterComparator {
    private static int off;
    public OffbyN(int N){
        off = N;
    }
    @Override
    public boolean equalChars(char x, char y){
        int diff = x - y;
        return (diff == off) || (diff == -off);
    }
}
