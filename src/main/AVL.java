package main;

import java.lang.Comparable;

class AVL_NODE <T extends Comparable>{
    public T key;
    private int height;
    public AVL_NODE(T key) {
        this.key=key;
        height=0;
    }

    public AVL_NODE p, right, left;

    public void add_to_Height(int increment){
        height+=increment;
    }
    public void setHeight(int h){
        height=h;
    }

    public int getHeight(){
        return height;
    }

    public String toString(){
        return new String(""+key);
    }

}

public class AVL <T extends Comparable>{

    private AVL_NODE<T> root;

    public AVL(){
        root=null;
    }
    public void right(AVL_NODE x) {
        System.out.println("right("+x+")");

            AVL_NODE y = x.left;
            if(x.p==null) root=y;
            y.p = x.p;
            x.p = y;
            if (y.right != null) {
                x.left = y.right;
                y.right.p = x;

            } else x.left = null;
            y.right = x;

    }

    public void left(AVL_NODE x) {
        System.out.println("left("+x+")");

            AVL_NODE y = x.right;
            if(x.p==null) root=y;
            y.p = x.p;
            x.p = y;
            if(y.left!=null) {
                x.right = y.left;
                y.left.p = x;
            }
            else x.right=null;
            y.left = x;

    }

    public void insert(Comparable k) {

        AVL_NODE x, y;
        AVL_NODE z= new AVL_NODE(k);
        y=null;
        x=root;
        while(x!=null){
            y=x;
            if(x.key.compareTo(z.key)<0){
                x=x.right;
            }
            else x=x.left;
        }
        z.p=y;
        if(y==null) root=z;
        else if(y.key.compareTo(z.key)<0) y.right=z;
        else y.left=z;

        update_height(root);

        AVL_NODE imb;

        if((imb=find_imbalance(root))!=null){
            System.out.println("imbalance found"+find_imbalance(root)+"; imb degree: "+getImbDegree(imb));
            if(getImbDegree(imb)<0){
                if(getImbDegree(imb.left)<0) right(imb);
                else {
                    left(imb.left);
                    right(imb);
                }
            }
            else if (getImbDegree(imb.right)<0){
                    right(imb.right);
                    left(imb);
            }
            else left(imb);
            if(root.getHeight()==2) root=y;
        }

    }

    public void update_height(AVL_NODE x){

        if(x!=null){
            x.setHeight(height_rec(x));
            update_height(x.right);
            update_height(x.left);
        }

    }

    protected int height_rec(AVL_NODE x){
        int sum_height=0;
        if(x!=null){
            if(x.right!=null || x.left!=null) sum_height++;
            sum_height+=Integer.max(height_rec(x.left), height_rec(x.right));
        }

        return sum_height;
    }

    protected AVL_NODE find_imbalance(AVL_NODE x){

        AVL_NODE aux;

        if(x!=null){
            if(x.getHeight()>1 || x.getHeight()<-1) return x;
            else{
                if((aux=find_imbalance(x.right))!=null) return aux;
                return  find_imbalance(x.left);
            }
        }
        return null;
    }
    protected int getImbDegree(AVL_NODE x) {
        if (x != null) {
            if (x.right != null && x.left != null) return x.right.getHeight() - x.left.getHeight();
            else if (x.right != null){
                return x.right.getHeight();
            }
            else {
                return 0-x.left.getHeight();
            }

        }
        return 0;
    }

    public void inorder(){
        inorder_rec(root);
    }

    protected void inorder_rec(AVL_NODE x){
        if(x!=null){
            inorder_rec(x.left);
            System.out.println(x);
            inorder_rec(x.right);
        }
    }

    public void PrintLevels(){
        for(int i=0; i<height_rec(root); i++){
            print_levels_rec(root, i);
            System.out.println();
        }
    }

    protected void print_levels_rec(AVL_NODE x, int levels_to_travel){
        if(levels_to_travel==0){
            System.out.print(x+", ");
        }
        else {
            if(x.left!=null) print_levels_rec(x.left, levels_to_travel-1);
            if(x.right!=null) print_levels_rec(x.right, levels_to_travel-1);
        }
    }

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        