import java.util.ArrayList;
import java.util.List;

public class HuffmanDecoder {
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("Usage: HuffmanDecoder input output");
            System.exit(1);
        }
        String input = args[0];
        String output = args[1];
        /** Read BinaryTrie object and BitSequence object from file */
        ObjectReader or = new ObjectReader(input);
        BinaryTrie trie = (BinaryTrie) or.readObject();
        BitSequence bitseqs = (BitSequence) or.readObject();

        List<Character> outputSymbols = new ArrayList<>();
        while(bitseqs.length() > 0){
            Match match = trie.longestPrefixMatch(bitseqs);
            outputSymbols.add(match.getSymbol());
            bitseqs = bitseqs.allButFirstNBits(match.getSequence().length());
        }
        char[] symbols = new char[outputSymbols.size()];
        for(int i = 0;i < symbols.length;i++){
            symbols[i] = outputSymbols.get(i);
        }
        FileUtils.writeCharArray(output, symbols);
    }
}
