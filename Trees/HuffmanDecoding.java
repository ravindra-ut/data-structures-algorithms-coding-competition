/*  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    
*/ 

void decode(String S ,Node root)
    {
        Node temp = root;
        StringBuilder sb = new StringBuilder("");
        if(root == null){
            System.out.println(sb);
            return;
        }
        for(int i=0; i< S.length(); i++){
            char c = S.charAt(i);
            if(temp.left == null && temp.right == null){
                // reached leaf, add it to string builder
                // and initialize temp to root
                sb.append(temp.data);
                temp = root;
            }
            if(c == '0'){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        if(temp.left == null && temp.right == null){
            sb.append(temp.data);
        }
        System.out.println(sb);
    }
