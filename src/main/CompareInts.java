package main;


public class CompareInts {
    public static int comp(Integer ... values){

        int lowest=100;

        for(Integer i:values){
            if (lowest>i){
                lowest=i;
            }
        }
        return lowest;
    }
}
