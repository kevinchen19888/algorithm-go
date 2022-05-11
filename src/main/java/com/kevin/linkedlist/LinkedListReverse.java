package linkedlist;

import lombok.Data;

/**
 * 反转一个单链表。
 * 使用双指针迭代的思想
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author kevin chen
 */
public class LinkedListReverse {
    public static ListNode linkedListReverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 先将下个节点进行存储,避免在向下迭代时时信息丢失
            ListNode tmp = cur.next;
            // 将原来的后向指针改成指向前向
            cur.next = pre;
            // 将前向指针指向现在的节点
            pre = cur;
            // 将现在的指针指向下个节点,实现迭代
            cur = tmp;
        }
        // 返回翻转后的最前向的指针所指向的节点
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        head.setNext(listNode2);
        listNode2.setNext(listNode3);

        listNode3.setPre(listNode2);
        listNode2.setPre(head);

        System.out.println(linkedListReverse(head));
    }


    @Data
    private static class ListNode {
        int val;
        ListNode pre;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
            pre = null;
        }
    }


}
