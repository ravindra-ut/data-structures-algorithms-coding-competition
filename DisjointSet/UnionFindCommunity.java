import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// merging communities same as components in a graph
// vertex query compared to min and max
public class UnionFindCommunity{
  int[] parent;
  int numSets;
  int[] size;

  public UnionFindCommunity(int n){
    parent = new int[n];
    size = new int[n];
    numSets = n;
    // set each vertex as parent itself
    // size of each vertex is 1
    for(int i=0; i<n; i++){
      parent[i] = i;
      size[i] = 1;
    }
  }
  
  public int numSets(){
    return numSets;
  }
  
  public int find(int i){
    while(i!=parent[i]){
      i = parent[i];
    }
    return i;
  }
  
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }
  
  public void union(int p, int q){
    int rootP = find(p);
    int rootQ = find(q);
    // already connected
    if(rootP == rootQ) return;
    
    numSets--;
    if(size[rootP] > size[rootQ]){
      parent[rootQ] = rootP;
      size[rootP] += size[rootQ];
    } else {
      parent[rootP] = rootQ;
      size[rootQ] += size[rootP];
    }
  }
  
  public int getSize(int p){
    int parentP = find(p);
    return size[parentP];
  }
  
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      UnionFindCommunity UF = new UnionFindCommunity(n);
      int u, v;
      int Q = sc.nextInt();
      int size = 1;
      System.out.printf("Here we are fine %d %d\n", n, Q);
      for(int i=0; i < Q; i++){
        String word = sc.next();
        u = sc.nextInt();
        u--;
        if(word.equals("Q")){
          size = UF.getSize(u);
          System.out.println(size);
        } else {
          v = sc.nextInt();
          v--;
          UF.union(u, v);
        }
      }
  }
}