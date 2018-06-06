package algorithms.redblacktree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private class Node{
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color; // 红色为true，其他为黑色

        Node(Key key, Value val, int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node node){
        if(node == null)return false;
        return node.color == RED;
    }

    private int size(Node node){
        return node == null ? 0 : node.N;
    }


    // 保证非空，为一个3节点；右链接非空，对应一个红节点
    Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h){
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }

    public Node put(Node root, Key key, Value val){
        if(root == null){
            return new Node(key, val, 1, RED);
        }

        if(key.compareTo(root.key) == 0){
            root.val = val;
            return root;
        }else if(key.compareTo(root.key) < 0){
            root.left = put(root.left, key, val);
        }else {
            root.right = put(root.right, key, val);
        }

        if(!isRed(root.left) && isRed(root.left)){
            root.left = rotateLeft(root.left);
        }
        if(isRed(root.left) && isRed(root.left.left)){
            root = rotateRight(root);
        }
        if(isRed(root.left) && isRed(root.right)){
            flipColors(root);
        }

        root.N = 1 + size(root.left) + size(root.right);
        return root;
    }

}
