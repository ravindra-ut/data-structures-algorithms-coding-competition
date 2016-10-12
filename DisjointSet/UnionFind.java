import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UnionFind {
  int[] parent;
  int numSets;
  int[] size;

  public UnionFind(int n){
    parent = new int[2*n];
    size = new int[2*n];
    numSets = n;
    // set each vertex as parent itself
    // size of each vertex is 1
    for(int i=0; i<2*n; i++){
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
      UnionFind UF = new UnionFind(2*n);
      int u, v;
      for(int i=0; i < n; i++){
        u = sc.nextInt();
        v = sc.nextInt();
        u--;
        v--;
        UF.union(u, v);
      }
      int largest = 0;
      int INF = 60000; //30000 is maximum nodes so, its fine.
      int minimum = INF;
      int size;
      for(int i=0; i < 2*n; i++){
        size = UF.getSize(i);
        if(size!=1){ // problem ignores isolated vertex
          largest = Math.max(largest, size);
          minimum = Math.min(minimum, size);
        }
      }
      System.out.printf("%d %d", minimum, largest);
  }
}