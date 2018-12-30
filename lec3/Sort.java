public class Sort{
    /** selection sort */
    public static void sort_itrative(String[] str) {
        for (int i = 0; i < str.length - 1; i++) {
            int smallest_ind = i;
            /** find smallest index */
            for (int j = i + 1; j < str.length; j++) {
                if (str[j].compareTo(str[smallest_ind]) < 0) {
                    smallest_ind = j;
                }
            }
            /** swap */
            if (smallest_ind != i) {
                String temp = str[i];
                str[i] = str[smallest_ind];
                str[smallest_ind] = temp;
            }
        }
    }
    /** find the smallest index of a string start from specific position */
    public static int findSmallestindex(String[] str, int pos){
        int smallestindex = pos;
        for(int i = pos;i<str.length;i++){
            int cmp = str[i].compareTo(str[smallestindex]);
            if(cmp<0){
                smallestindex = i;
            }
        }
        return smallestindex;
    }
    /** swap the position a,b of a string */
    public static void swap(String[] str, int a, int b){
        String temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }

    /** Recursive selection sort from a specific position */
    public static void sort(String[] str,int pos){
        if(pos == str.length-1){
            return;
        }
        int smallestindex = findSmallestindex(str,pos);
        swap(str,pos,smallestindex);
        sort(str,pos+1);
    }
    public static void sort(String[] str){
        sort(str,0);
    }
}