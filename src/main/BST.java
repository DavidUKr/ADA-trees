package main;

import java.lang.Comparable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

class Node<T extends Comparable> {
    public T key;

    public Node left, right, p;

    public Node(T key) {
        this.key = key;
    }

    public String toString(){
        String s=""+key;
        return s;
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

    public void inorder_arrList_rec(Node x, ArrayList<Integer> ARR){

        if(x!=null){
            inorder_arrList_rec(x.left, ARR);
            ARR.add((int)x.key);
            inorder_arrList_rec(x.right, ARR);
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

    protected int height_rec(Node x) {
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
    public Node min(Node x){
        while (x.left != null){
            x=x.left;
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

    public Node SearchClosest(T key){

        Node x=root;

        while(x!=null){
            if(x.key.equals(key)){
                return x;
            }
            //CompareInts.comp(Math.abs(x.key-key))
            if( x.left!=null && x.key.compareTo(key)>0){
                x=x.left;
            }
            else if(x.right!=null) x=x.right;
            else return x;
        }

        return null;
    }

    public boolean CheckExistTwoNodesWithSum(T sum){

        return checkPair_rec(root, root, (int)sum);
    }

    private boolean checkPair_rec(Node root, Node temp, int target){

        if(temp==null) return false;

        Node rem_target=new Node(target-(int)temp.key);

        return search((T)rem_target.key)!=null
                || checkPair_rec(root, temp.left, target)
                ||checkPair_rec(root, temp.right, target);
    }

    public void PrintPathFromTo(T A, T B){

        Node X=search(A);
        Node Y=search(B);

        ArrayList<Node> PATH= new ArrayList<Node>();
        PATH.add(X);
        path_rec(X, Y, PATH);
        System.out.println(PATH);
    }

    private void path_rec(Node A, Node B, ArrayList<Node> PATH){

       if(A.equals(B)){
           PATH.add(B);
       }
       if(search((T)B.key, A)){
           ArrayList<Node> back_path=new ArrayList<Node>();

           back_path.add(B);
           Node aux=B;
           while(aux!=A){
               aux=aux.p;
               back_path.add(aux);
           }
           Collections.reverse(back_path);

           for(Node n: back_path){
               PATH.add(n);
           }
       }
       else if(A!=root){
           A=A.p;
           path_rec(A, B, PATH);
       }
    }

    public boolean search(T searched_key, Node root) {
        //Node y=new Node(searched_key);
        Node x = root;
        while (x != null && x.key.compareTo(searched_key) != 0) {
            if (x.key.compareTo(searched_key) > 0) {
                x = x.left;
            } else x = x.right;
        }
        if(x!=null) return true;
        else return false;
    }

    public void PrintPathsWithSum(T s){
        //int sum=(int)s-(int)root.key;
        ArrayList<Node> PATH=new ArrayList<Node>();
        //PATH.add(root);
        SumPath_rec(root, (int)s , PATH);
    }

    private void SumPath_rec(Node x, int TARGET_SUM, ArrayList<Node> PATH){

        if(x!=null) {
            if (TARGET_SUM == (int) x.key) {
                PATH.add(x);
                System.out.println(PATH);
            }
            if (TARGET_SUM>(int)x.key) {
                TARGET_SUM -= (int) x.key;
                SumPath_rec(x.right,TARGET_SUM, PATH);
                SumPath_rec(x.right, TARGET_SUM, PATH);
            }

        }

    }

    public void PrintLevels(){
        for(int i=0; i<height_rec(root); i++) {
            print_levels_rec(root, i);
            System.out.println();
        }
    }

    protected void print_levels_rec(Node x, int levels_to_travel){
        if(levels_to_travel==0){
            System.out.print(x+" ");
        }
        else {
            if(x.left!=null) print_levels_rec(x.left, levels_to_travel-1);
            if(x.right!=null) print_levels_rec(x.right, levels_to_travel-1);
        }
    }


}





