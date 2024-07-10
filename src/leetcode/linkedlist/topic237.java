package leetcode.linkedlist;

public class topic237 {
    public static void main(String[] args) {

        int[] l1 = {4,5,1,9};
        Solution237 s237 = new Solution237();
        Solution237.ListNode listNode = s237.new ListNode(l1);
        s237.deleteNode(listNode);
    }
}

class Solution237 {
    /**
     * 复制后继节点 node.next 的「节点值」至节点 node ；
     * 使用上述方法将 node.next 从链表中删除即可；
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

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