public class BSTree<E extends Comparable<E>> implements Tree<E>{

    private class TreeNode<E>{
        E data;
        TreeNode left;
        TreeNode right;
    }

    private int size;
    private TreeNode root;

    public static void main(String[] args){
        System.out.println(-1 % 4);
        System.out.println(Math.floorMod(-1, 4));
    }



}
