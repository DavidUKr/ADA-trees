package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class AVL_Main {
    public static void main(String[] args) {

        int SIZE=8;  //initialization
        /*Random rand=new Random();
        ArrayList<Integer> input_1mil=new ArrayList<>();
        for(int i=0; i<SIZE; i++){
            int x=rand.nextInt(100);
            input_1mil.add(x);
            System.out.print(x+",");
        }
        System.out.println();*/

        ArrayList<Integer> input_1mil=new ArrayList<>();
        input_1mil.add(3);
        input_1mil.add(6);
        input_1mil.add(18);
        input_1mil.add(2);
        input_1mil.add(1);
        input_1mil.add(13);
        input_1mil.add(16);
        input_1mil.add(4);

        AVL<Integer> AVL_UNSORTED=new AVL<Integer>();
        long start_AVL_unsorted=System.nanoTime();
        for(int k=0; k<SIZE; k++){     //AVL unsorted insertion
            AVL_UNSORTED.insert(input_1mil.get(k));
        }
        double time_AVL_unsorted_ms= (double)(System.nanoTime()-start_AVL_unsorted)/1000000;
        System.out.println("AVL unsorted insertion time:"+time_AVL_unsorted_ms+"ms; in sec:"+time_AVL_unsorted_ms/1000+"s");

        BST<Integer> BST_UNSORTED= new BST<Integer>();
        long start_BST_unsorted=System.nanoTime();
        for(int l=0; l<SIZE; l++){    //BST unsorted insertion
                BST_UNSORTED.insert(input_1mil.get(l));
        }
        double time_BST_unsorted_ms= (double)(System.nanoTime()-start_BST_unsorted)/100000;
        System.out.println("BST unsorted insertion time: "+time_BST_unsorted_ms+"ms; in sec:"+time_BST_unsorted_ms/1000+"s");

        input_1mil.sort(Comparator.naturalOrder());

        AVL<Integer> AVL_SORTED=new AVL<Integer>();
        long start_AVL_sorted=System.nanoTime();
        for(int j=0; j<SIZE; j++){    //AVL sorted insertion
            AVL_SORTED.insert(input_1mil.get(j));
        }
        double time_AVL_sorted_ms=(double)(System.nanoTime()-start_AVL_sorted)/1000000;
        System.out.println("AVL sorted insertion time:"+time_AVL_sorted_ms+"ms; in sec:"+time_AVL_sorted_ms/1000+"s");


        long start_BST_sorted=System.nanoTime();
        BST<Integer> BST_SORTED= new BST<Integer>();
        for(int h=0; h<SIZE; h++){      //BST sorted insertion
            BST_SORTED.insert(input_1mil.get(h));
        }
        double time_BST_sorted_ms= (double)(System.nanoTime()-start_BST_sorted)/1000000;
        System.out.println("BST sorted insertion time:"+time_BST_sorted_ms+"ms; in sec:"+time_BST_sorted_ms/1000+"s");

        System.out.println("BST unsorted:");
        BST_UNSORTED.PrintLevels();
        System.out.println("BST sorted:");
        BST_SORTED.PrintLevels();

        System.out.println("AVL unsorted:");
        AVL_UNSORTED.PrintLevels();
        System.out.println("AVL sorted:");
        AVL_SORTED.PrintLevels();
    }
}
