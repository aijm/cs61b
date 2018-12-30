public class WordUtils{
    public static String longest(List61B<String> list){
        int longest_index = 0;
        for(int i=0;i<list.size();i++){
            String curr = list.get(i);
            String longest_str = list.get(longest_index);
            if(curr.length() > longest_str.length()){
                longest_index = i;
            }
        }
        return list.get(longest_index);
    }

    public static void peek(List61B<String> list){
        System.out.println(list.getFirst());
    }
    public static void peek(SLList<String> list){
        System.out.println(list.getLast());
    }


    public static void main(String[] args){
        SLList<String> somelist = new SLList<>();
        somelist.addLast("elk");
        somelist.addLast("are");
        somelist.addLast("watching");
        System.out.println(longest(somelist));

        peek(somelist);

    }
}