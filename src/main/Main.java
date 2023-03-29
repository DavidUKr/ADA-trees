package main;
public class Main {
    public static void main(String[] args) {

        String[] toAdd={"aba", "abalact", "albina", "albinar", "alb",
                "carunt", "car", "carosa", "carosabil"};
        String[] toSearch={"albina", "carosabil", "car", "albi", "albin", "truc"};
        TrieTree tree1=new TrieTree();

        for(int i=0; i<9; i++){
            tree1.insert(toAdd[i]);
        }

        for(int j=0; j<6; j++) {
            System.out.println(tree1.search(toSearch[j]));
        }

        //bye

    }
}