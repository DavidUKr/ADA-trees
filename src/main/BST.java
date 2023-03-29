package main;

import java.lang.Comparable;
class Node<T extends Comparable> {
    public T key;

    public Node left, right, p;

    public Node(T key) {
        this.key = key;
    }
}


public class BST <T extends Comparable> {

    private Node<T> root;             // root of main.BST


    public BST() {
        root = null;
    }


    public void insert(T k) {
        Node x, y;
        Node z = new Node(k);
        y = null;
        x = root;
        while (x != null) {
            y = x;
            if (x.key.compareTo(z.key) < 0)
                x = x.right;
            else
                x = x.left;
        }
        z.p = y;
        if (y == null)
            root = z;
        else if (y.key.compareTo(z.key) < 0)
            y.right = z;
        else
            y.left = z;

    }

    public void inorder() {
        //System.out.println("Being implemented ");
        inorder_rec(root);

    }

    public void inorder_rec(Node x) {
        if (x != null) {
            inorder_rec(x.left);
            System.out.println(x.key);
            inorder_rec(x.right);
        }
    }

    public void preorder() {
        preorder_rec(root);
    }

    private void preorder_rec(Node x) {
        if (x != null) {
            System.out.println(x.key);
            preorder_rec(x.left);
            preorder_rec(x.right);
        }
    }

    public int height() {
        return height_rec(root);
    }

    private int height_rec(Node x) {
        int sum_height = 0;

        if (x != null) {
            sum_height++;
            sum_height += Integer.max(height_rec(x.left), height_rec(x.right));
        }
        return sum_height;
    }

    public Node search(T searched_key) {
        //Node y=new Node(searched_key);
        Node x = root;
        while (x != null && x.key.compareTo(searched_key) != 0) {
            if (x.key.compareTo(searched_key) > 0) {
                x = x.left;
            } else x = x.right;
        }
        return x;
    }

    public Node successor(T key) {
        Node x = search(key);
        return successor_fun(x);
    }

    private Node successor_fun(Node x) {
        if (x == null) return null;
        if (x.right != null) {
            return max(x.right);
        }
        Node y = x.p;
        while (y != null && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;

    }

    public Node max(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public boolean IsPerfectlyBalanced(){
        int mod=count_nodes(root.left)-count_nodes(root.right);
        if(mod<=1 && mod>=-1) return true;
        else return false;
    }

    private int count_nodes(Node x){
        int count=0;
        if(x!=null){
            count++;
            count+= count_nodes(x.right)+count_nodes(x.left);
        }
        return count;
    }
}



