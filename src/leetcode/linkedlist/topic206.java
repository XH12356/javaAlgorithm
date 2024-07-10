package leetcode.linkedlist;

public class topic206 {
    public static void main(String[] args) {
        int[] l1 = {1,2,3,4,5};
        int[] l2 = {1,3,4};
        Solution206_1 s206 = new Solution206_1();
        Solution206_1.ListNode listNode1 = s206.new ListNode(l1);
//        Solution206_1.ListNode listNode2 = s206.new ListNode(l2);
        System.out.println(listNode1.toString());
//        System.out.println(listNode2.toString());
        System.out.println(s206.reverseList(listNode1).toString());
    }
}
//递归

class Solution206_1 {
    public ListNode reverseList(ListNode head){
        return recur(head, null);
    }
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 当cur.next为null时，返回cur作为res的值
        ListNode res = recur(cur.next, cur);  // 最后一层为5->null
        cur.next = pre;              // cur的next指向4
        return res;                  // 返回5->4，之后cur变为4，cur.next指向3
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0)
                return;
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val).append("->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }

    }
}
//迭代
class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode tmp = head;
        ListNode cur = head;
        while (cur != null){
            tmp = tmp.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;


    }
    public class ListNode {
        int val;
        Solution206.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0)
                return;
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val).append("->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }

    }
}