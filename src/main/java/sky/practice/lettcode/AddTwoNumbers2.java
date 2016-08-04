package sky.practice.lettcode;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * <p>
 * Output: 7 -> 0 -> 8
 * <p>
 * 翻译：给定两个由正整数组成的链表，数在链表中是倒序存放的，并且每个节点上的数是一位整数。把这两上链表上的数相加并返回一个链表
 *
 * @author fei
 */
public class AddTwoNumbers2 {
    /**
     * 官方提供的答案
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode standard(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        ListNode result = new ListNode(-1);
        ListNode start = result;
        int temp = 0;
        while (true) {
            int val1 = 0;
            int val2 = 0;
            if (one == null && two == null && temp == 0) {
                start = start.next;
                return start;
            }
            if (one != null) {
                val1 = one.val;
                one = one.next;
            }
            if (two != null) {
                val2 = two.val;
                two = two.next;
            }
            int sum = val1 + val2 + temp;
            ListNode node = new ListNode(sum % 10);
            temp = sum / 10;
            result.next = node;
            result = node;
        }

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode addAndPointNext(ListNode nextNode) {
            this.next = nextNode;
            return nextNode;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode node = this.next;
            while (true) {
                if (node == null) {
                    break;
                }
                sb.append(node.val);
                node = node.next;
            }
            return sb.toString();
        }

    }
}
