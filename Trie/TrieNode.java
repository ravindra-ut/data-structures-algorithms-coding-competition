import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TrieNode{
  TrieNode[] arr;
  int wordCount;
  boolean isEnd;
  // Initialize your data structure here.
  public TrieNode() {
    this.arr = new TrieNode[26];
    wordCount = 1;
  }
}

class Trie{
  private TrieNode root;
  
  public Trie(){
    root = new TrieNode();
  }
  
  public boolean insert(String word){
    TrieNode p = root;
    // convert all letters to lowercase
    for(int i=0; i < word.length(); i++){
      char c = word.charAt(i);
      int index = c - 'a';
      if(p.arr[index] == null){
        TrieNode newNode = new TrieNode();
        p.arr[index] = newNode;
        p = newNode;
      } else {
        p = p.arr[index];
        p.wordCount = p.wordCount + 1;
        if(p.isEnd){
          //we found prefix which ended here
          return false;
        }
      }
    }
    p.isEnd = true;
    // after adding check there is children
    // already exists for longer node
    for(int i = 0; i < 26; i++){
      if(p.arr[i]!=null){
        return false;
      }
    }
    return true;
  }
   // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if(p==null){
            return false;
        }else{
            if(p.isEnd)
                return true;
        }
 
        return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public int startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if(p==null){
            return 0;
        }else{
          /*int count = 0;
          Vector<TrieNode> q = new Vector<TrieNode>();
          q.add(p);
          while(!q.isEmpty()){
            // also count nodes which have same prefix
            p = (TrieNode) q.remove();
            if(p.isEnd){
              count = count + 1;
            }
            for(int i=0; i<26; i++){
              if(p.arr[i] != null){
                q.add(p.arr[i]);
              }
            }
          }*/
          return p.wordCount;
        }
    }
 
    public TrieNode searchNode(String s){
        TrieNode p = root;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            int index = c-'a';
            if(p.arr[index]!=null){
                p = p.arr[index];
            }else{
                return null;
            }
        }
        if(p==root)
            return null;
        return p;
    }
}

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie contacts = new Trie();
        for(int i = 0; i < n; i++){
          String word = in.next();
          boolean result = contacts.insert(word);
          if(!result){
            System.out.println("BAD SET");
            System.out.println(word);
            return;
          }
        }
        System.out.println("GOOD SET");
        return;
    }
}