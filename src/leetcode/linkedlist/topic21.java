package leetcode.linkedlist;

public class topic21 {
    public static void main(String[] args) {
        int[] l1 = {1, 2, 4};
        int[] l2 = {1, 3, 4};
        Solution21 s21 = new Solution21();
        Solution21.ListNode listNode1 = s21.new ListNode(l1);
        Solution21.ListNode listNode2 = s21.new ListNode(l2);
        System.out.println(listNode1.toString());
        System.out.println(listNode2.toString());
        System.out.println(s21.mergeTwoLists(listNode1, listNode2).toString());
    }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode();
        ListNode cur = res;
        while (list1.next != null && list2.next != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1.next != null){
            cur.next = list1;
        }else{
            cur.next = list2;
        }
        return res;


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