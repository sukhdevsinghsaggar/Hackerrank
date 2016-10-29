import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TrieNode{
    int value;
    TrieNode[] nodes = new TrieNode[26];
    TrieNode(){
        value = 0;
    }
}

class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
        root.value = 0;
    }
   
    void insert(String word){
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(p.nodes[index] == null){
                p.nodes[index] = new TrieNode();
            }
            p.nodes[index].value++;
            p = p.nodes[index];
        }
    }
   
    public Integer startWith ( String word )
    {
        TrieNode p = root;
        int i;
        int index = 0;
        for ( i = 0; i < word.length(); i++ )
        {
            index = word.charAt(i) - 'a';
            if ( p.nodes[index] == null )
                return 0;
            p = p.nodes[index];
        }
        return p.value;
     }
}

public class Solution {

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        int i;
        Trie t = new Trie();
        n = s.nextInt();
        for(i = 0; i < n; i++){
            String m = s.next();
            if(m.equals("add"))
                t.insert(s.next());
            else{
                 System.out.println(t.startWith(s.next()));
               
        }
    }
}
}
