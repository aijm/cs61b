public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d = new LinkedListDeque<>();
        for(int i=0;i<word.length();i++){
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word){
        if(word.length() <= 1){
            return true;
        }
        if(word.charAt(0) != word.charAt(word.length()-1)){
            return false;
        }
        return isPalindrome(word.substring(1,word.length()-1));

//        Deque<Character> d = wordToDeque(word);
//        for(int i =0;i<word.length();i++){
//            if(d.removeLast() != word.charAt(i)){
//                return false;
//            }
//        }
//        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length() <= 1){
            return true;
        }
        if(!cc.equalChars(word.charAt(0), word.charAt(word.length()-1))){
            return false;
        }
        return isPalindrome(word.substring(1,word.length()-1), cc);
    }
}
