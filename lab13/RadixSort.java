/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        String[] sorted = asciis.clone();
        int maxlen = 0;
        for(String str : asciis){
            if(str.length() > maxlen){
                maxlen = str.length();
            }
        }
        /** sort by character at ith least significant digit */
        for(int i = 0;i < maxlen;i++){
            sortHelperLSD(sorted, i);
        }
        return sorted;
    }

    /**
     * Does MSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort_MSD(String[] asciis) {
        String[] sorted = asciis.clone();
        int maxlen = 0;
        for(String str : asciis){
            if(str.length() > maxlen){
                maxlen = str.length();
            }
        }
        sortHelperMSD(sorted, 0, sorted.length, maxlen-1);
        return sorted;
    }

    /** get the bucket of ith least significant digit of str
     * For example:
     * getbucket("bc", 0) == 99+1
     * getbucket("bc", 1) == 98+1
     * getbucket("bc", 2) == 0
     */
    private static int getbucket(String str, int i){
        if(i >= str.length()){
            return 0;
        }else{
            return str.charAt(str.length() - 1 - i) + 1;
        }
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        int[] count = new int[257]; // using count[0] for empty
        for(String str : asciis){
            int bucket = getbucket(str, index);
            count[bucket]++;
        }
        // update count to start position
        int count_before = count[0];
        count[0] = 0;
        for(int i = 1;i < count.length;i++){
            int temp = count[i];
            count[i] = count[i-1] + count_before;
            count_before = temp;
        }
        // sorted by start position array
        String[] asciis_copy = new String[asciis.length];
        System.arraycopy(asciis,0,asciis_copy,0,asciis.length);
        for(String item : asciis_copy){
            int place = count[getbucket(item, index)];
            asciis[place] = item;
            count[getbucket(item, index)]++;
        }
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        if(index == -1){
            return;
        }
        // Optional MSD helper method for optional MSD radix sort
        int[] count = new int[257]; // using count[0] for empty

        for(int i = start;i < end;i++){
            int bucket = getbucket(asciis[i], index);
            count[bucket]++;
        }
        // update count to start position
        int count_before = count[0];
        count[0] = 0;
        for(int i = 1;i < count.length;i++){
            int temp = count[i];
            count[i] = count[i-1] + count_before;
            count_before = temp;
        }
        int[] startpos = count.clone();

        // sorted using ith most significant digit
        String[] asciis_copy = new String[end - start];
        System.arraycopy(asciis,start,asciis_copy,0, end - start);
        for(String item : asciis_copy){
            int place = count[getbucket(item, index)] + start;
            asciis[place] = item;
            count[getbucket(item, index)]++;
        }



        // for the same most significant digit(can be considered as several frames)
        // apply sortHelperMSD
        for(int i = 0;i < count.length - 1;i++){
            int frame_start = startpos[i] + start;
            int frame_end = startpos[i+1] + start;
            sortHelperMSD(asciis, frame_start, frame_end, index - 1);
        }
    }
}
