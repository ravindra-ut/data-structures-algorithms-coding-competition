public class ListNode{
  int data;
  ListNode next;
  
  ListNode(int data){
    this.data = data;
    this.next = null;
  }
}

public Solution{

  public ListNode mergeSortedList(ListNode l1, ListNode l2){
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    
    while(l1 != null && l2 != null){
      if(l1.data <= l2.data){
        current.next = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        l2 = l2.next;
      }
      current = current.next;
    }
    if(l1 == null){
      current.next = l2;
    } else {
      current.next = l1;
    }
    
    return dummyHead.next;
  }
}