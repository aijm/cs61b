import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BinaryTrie implements Serializable {

    private class Node implements Comparable<Node>, Serializable{
        private int freq;
        private char ch;
        /** Children */
        private Node left;
        private Node right;

        private Node(char ch, int freq, Node left, Node right){
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
        /**
         * implements Comparable<Node>, Compare by freq
         */
        @Override
        public int compareTo(Node other){
            return this.freq - other.freq;
        }
        /** Return Whether the node is a leaf node */
        public boolean isLeaf(){
            return left == null && right == null;
        }

    }

    private Node root;

    /**
     * Construct a BinaryTrie by the frequency Table of Characters
     * by Huffman coding
     * @param frequencyTable
     */
    public BinaryTrie(Map<Character, Integer> frequencyTable){
        // construct node priorityQueue
        PriorityQueue<Node> nodePQ = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> pair : frequencyTable.entrySet()){
            Node node = new Node(pair.getKey(),pair.getValue(),null,null);
            if(node.freq > 0){
                nodePQ.add(node);
            }
        }
        /** special case if nodePQ only contain one character */
        if(nodePQ.size() == 1){
            if(nodePQ.peek().ch == '\0'){
                nodePQ.add(new Node('\1', 0, null, null));
            }else{
                nodePQ.add(new Node('\0', 0, null, null));
            }
        }
        /** Consruct Huffman tree */
        while(nodePQ.size() > 1){
            // Get the two nodes with the smallest frequency
            Node node1 = nodePQ.remove();
            Node node2 = nodePQ.remove();
            // construct a new node
            Node parent = new Node('\0', node1.freq+node2.freq,node1,node2);
            nodePQ.add(parent);
        }
        root = nodePQ.remove();
    }

    /**
     * Find the longest prefix that match the given querySequence
     * Return a Match object contains the prefix and the Character
     * For example: querySequence is "0011010001", then match "001"-> 'b'
     * @param querySequence
     * @return
     */
    public Match longestPrefixMatch(BitSequence querySequence){
        BitSequence longestSeq = new BitSequence();
        Node node = root;
        int i = 0;
        while(!node.isLeaf() && i < querySequence.length()){
            int bit = querySequence.bitAt(i);
            longestSeq =  longestSeq.appended(bit);
            if(bit == 0){
                node = node.left;
            }else{
                node = node.right;
            }
            i++;
        }

        return new Match(longestSeq, node.ch);
    }
    private void buildLookupTable_helper(Node node, Map<Character, BitSequence> map){
        Map<Character, BitSequence> left_map = new HashMap<>();
        Map<Character, BitSequence> right_map = new HashMap<>();
        if(node.isLeaf()){
            map.put(node.ch, new BitSequence());
            return;
        }
        // build left and right map
        buildLookupTable_helper(node.left, left_map);
        buildLookupTable_helper(node.right, right_map);
        // for all left map entry, add "0" in the front of BitSequence
        for(Map.Entry<Character, BitSequence> pair : left_map.entrySet()){
            String add0 = "0" + pair.getValue().toString();
            map.put(pair.getKey(), new BitSequence(add0));
        }
        // for all right map entry, add "1" in the front of BitSequence
        for(Map.Entry<Character, BitSequence> pair : right_map.entrySet()){
            String add1 = "1" + pair.getValue().toString();
            map.put(pair.getKey(), new BitSequence(add1));
        }

    }
    /**
     * Build a look up Table
     * For example: 'a': 000, 'b':001, 'c':01
     * @return
     */
    public Map<Character, BitSequence> buildLookupTable(){
        Map<Character, BitSequence> map = new HashMap<>();
        buildLookupTable_helper(root, map);
        return map;
    }



}
