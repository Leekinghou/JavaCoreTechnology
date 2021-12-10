package leetcode;

/**
 * @author: lijinhao
 * @date: 2021/12/06 09:31
 */
public class offer24 {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};

        for (int i = 0; i < input.length; i++) {
            int in = input[i];

        }

    }
    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head, pre = null;
            while(cur != null){
                ListNode temp = cur.next;
                cur.next = pre;          // 修改 next 引用指向
                pre = cur;               // pre 暂存 cur
                cur = temp;               // cur 访问下一节点
            }
            return pre;
        }
    }
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode() {

        }
    }
}

