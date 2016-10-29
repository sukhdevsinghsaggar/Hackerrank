import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TrieNode{
    int value;
    boolean end = false;
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
   
    public boolean insert(String word){
        TrieNode p = root;
        int index, i;
        for(i = 0; i < word.length(); i++){
            index = word.charAt(i) - 'a';
            if(p.nodes[index] == null){
                p.nodes[index] = new TrieNode();
            }
            p.nodes[index].value++;
            if( p.nodes[index].value > 1 && (p.nodes[index].end == true || i == word.length() - 1) )
                return false;
            //p.end = true;
            p = p.nodes[index];
        }
        p.end = true;
        return true;
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
          String str = s.next();
          boolean pre = t.insert(str);
          //t.search();
          if(!pre) {
              System.out.println("BAD SET");
              System.out.println(str);
              break;
          }    
        }
        if(i == n) System.out.println("GOOD SET");
        
    }
}
