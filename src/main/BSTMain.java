package main;
public class BSTMain {
    public static void main(String[] args) {

        BST<Integer> st1=new BST<Integer>();
        st1.insert(5);
        st1.insert(2);
        st1.insert(10);
        st1.insert(8);
        st1.insert(15);
       // st1.inorder();

        BST<String> st2=new BST<String>();
        st2.insert("dog");
        st2.insert("bear");
        st2.insert("cat");
        st2.insert("fish");
        st2.insert("wolf");
        //st2.inorder();
        //st1.preorder();

        BST<Integer> st3=new BST<Integer>();
        int[] INTS={8,15,2,5,4,10,3,1,20,18,7,22};
        for(int i=0; i<12;i++){
            st3.insert(INTS[i]);
        }

       /* System.out.println("height:"+st1.height());
        Node searched=st2.search("fish");
        System.out.println("searched node:"+searched+"; key:"+searched);
        System.out.println("successor of 10:"+st1.successor(10));
        System.out.println("successor of 8:"+st1.successor(8));
        System.out.println("st1.IsPerfectlyBalanced: "+st1.IsPerfectlyBalanced());
        System.out.println("st2.IsPerfectlyBalanced: "+st2.IsPerfectlyBalanced());

        System.out.println("Search closest to 9:"+st1.SearchClosest(9));
        System.out.println("Is there pair that adds up to 18?: "+st1.CheckExistTwoNodesWithSum(18));
        System.out.print("Path from 2 to 8: "); st1.PrintPathFromTo(2,8);
        System.out.println();

        System.out.println("Paths to sum 30 from st1: "); st1.PrintPathsWithSum(15);

        System.out.println("Is perf balanced:"+ st3.IsPerfectlyBalanced());
        System.out.println("Search closest to 16: "+ st3.SearchClosest(16));
        System.out.println("PrintPathFromTo(10,18): "); st3.PrintPathFromTo(10, 18);
        System.out.println("PrintPathWithSum(22): "); st3.PrintPathsWithSum(22);
        System.out.println("PrintLevels: "); st3.PrintLevels();
        */
    }
}