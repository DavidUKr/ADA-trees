package main;
class TrieNode{
    public boolean isEnd;
    public TrieNode[] KIDS= new TrieNode[26];
    public TrieNode(){
        isEnd=false;
        for(int i=0; i<26; i++){
            KIDS[i]=null;
        }
    }

    public String toString(){
        String s="";
        for(int i=0; i<26; i++){
            s+=KIDS[i]+",";
        }
        return s;
    }
}

public class TrieTree {
    TrieNode root;

    public TrieTree(){
        root=new TrieNode();
    }
    public void insert(String key){
        int length=key.length();
        int KIDS_index;
        TrieNode cursor=root;

        for(int level=0; level<length; level++){
            KIDS_index=key.charAt(level)-'a';
            if(cursor.KIDS[KIDS_index]==null) {
                cursor.KIDS[KIDS_index] = new TrieNode();
            }
            cursor=cursor.KIDS[KIDS_index];
        }

        cursor.isEnd=true;
    }

    public boolean search(String key){
        int length=key.length();
        int KIDS_index;
        TrieNode cursor=root;

        for(int level=0; level<length; level++){
            KIDS_index=key.charAt(level)-'a';
            if(cursor.KIDS[KIDS_index]==null) return false;
            else cursor=cursor.KIDS[KIDS_index];
        }
        return cursor.isEnd;
    }
}
