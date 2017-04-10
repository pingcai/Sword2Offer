package _37;

/**
 * Created by pingcai on 17-4-10.
 */
public class Solution {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(new Solution().FindFirstCommonNode(n1, new ListNode(19)).val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int l1 = len(pHead1);
        int l2 = len(pHead2);
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                pHead1 = pHead1.next;
            }
        } else if (l2 > l1) {
            for (int i = 0; i < l1 - l2; i++) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null && pHead2 != null && pHead1.val != pHead2.val) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    private int len(ListNode pHead1) {
        int len = 0;
        while (pHead1 != null) {
            pHead1 = pHead1.next;
            len++;
        }
        return len;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}