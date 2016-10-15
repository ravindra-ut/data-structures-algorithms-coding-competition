// Queue with head and last pointer
class Node{
    final int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    } 
}

class Queue{
    
    Node head=null; // head pointer
    Node tail=null; // tail pointer
    
    public void enqueue(int data){
        Node temp = new Node(data);
        if(this.head == null){
            this.head = temp;
            this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }
    
    public int deque(){
        if(this.head == null){
            return -1;
        }
        int data = head.data;
        this.head = this.head.next;
        if(this.head == null){
            this.tail = null;
        }
        return data;
    }
    
    public void print(){
      System.out.println("content of queue");
      Node cur = this.head;
      while(cur!=null){
        System.out.println(cur.data);
        cur = cur.next;
      }
    }
    
    public static void main(String[] args){
      Queue q = new Queue();
      q.enqueue(3);
      q.enqueue(1);
      q.print();
      q.deque();
      q.enqueue(5);
      q.print();
      q.deque();
      q.enqueue(4);
      q.print();
      q.deque();
      q.enqueue(5);
      q.print();
    }
}