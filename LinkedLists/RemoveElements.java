class RemoveElements {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode cur = head, prev = fakeHead;
        while(cur!=null){
            if(cur.val == val){
                prev.next = cur.next;
            } else {
                // otherwise advance prev pointer
                prev = prev.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }
}
