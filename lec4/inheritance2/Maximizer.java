import java.util.Comparator;

/** find the max in an array regradless of type */

public class Maximizer {
    public static OurComparable max(OurComparable[] items){
        int maxindex = 0;
        for(int i = 0;i<items.length;i++){
            if(items[i].compareTo(items[maxindex]) > 0){
                maxindex = i;
            }
        }
        return items[maxindex];
    }

    public static <T>T max1(T[] items, Comparator<T> comparator){
        int maxindex = 0;

        for(int i = 0;i< items.length;i++){
            if(comparator.compare(items[i],items[maxindex]) > 0){
                maxindex = i;
            }
        }
        return items[maxindex];
    }
}
