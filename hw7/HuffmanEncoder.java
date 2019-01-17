import java.util.*;

public class HuffmanEncoder {
    /**
     * Return the Frequency Table of symbols
     * @param inputSymbols
     * @return the Frequency Table of symbols in inputSymbols
     */
    public static Map<Character, Integer> buildFrequencyTable(char[] inputSymbols){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : inputSymbols){
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Usage: HuffmanEncoder input");
            System.exit(1);
        }
        String filename = args[0];
        /** read file to char[] */
        char[] inputSymbols = FileUtils.readFile(filename);
        /** build frequency Table */
        Map<Character, Integer> frequencyTable = new HashMap<>();
        frequencyTable = buildFrequencyTable(inputSymbols);
        /** build Huffman BinaryTrie */
        BinaryTrie trie = new BinaryTrie(frequencyTable);
        /** write the trie to the output file */
        ObjectWriter ow = new ObjectWriter(filename + ".huf");
        ow.writeObject(trie);

        Map<Character, BitSequence> lookupTable = trie.buildLookupTable();
        List<BitSequence> bitseqs = new LinkedList<>();

        /** for every symbol in inputSymbols, using lookupTable get
         * the corresponding BitSequence
         */
        for(char ch : inputSymbols){
            bitseqs.add(lookupTable.get(ch));
        }
        BitSequence all_bitseqs = BitSequence.assemble(bitseqs);
        ow.writeObject(all_bitseqs);
    }
}
