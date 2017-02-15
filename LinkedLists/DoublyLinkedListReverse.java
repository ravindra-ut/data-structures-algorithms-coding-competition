class Node{
    int data;
    Node next, prev;
    
    public Node(int value){
        data = value;
        next = prev = null;
    }
}

class DoublyLinkedListReverse{
    static Node head;
    
    public Node reverse(Node head){
        Node temp = null;
        Node current = head;
        
        if(head == null){
            return null;
        }
        
        while(current != null){
            temp = current.prev;
            current.next = current.prev;
            current.prev = temp;
            current = current.prev;
        }
        
        return temp.prev;
    }
}