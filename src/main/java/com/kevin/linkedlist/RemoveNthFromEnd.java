package com.kevin.linkedlist;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的(0 < n < 链表链接节点数量)。
 * <p>
 * 思路:
 * 1,遍历链表,将链表所链接的所有节点放入一个list中,可获得链表上节点数量count=list.size;
 * 2,取出第count-n(倒数第n个节点)&count-n-1(待删除节点的上一个节点[注意count==n的判断)
 * 3,判断如果count==n则将head的下一个节点返回;
 * <p>
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @author kevin chen
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        head.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);

        System.out.println(removeNthFromEnd(head, 5));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int inverseN = list.size() - n;
        // 如果倒数第n个节点的上个节点不存在
        if (inverseN - 1 < 0) {
            return head.next;
        } else {
            ListNode preNode = list.get(inverseN - 1);
            preNode.next = list.get(inverseN).next;
        }

        return head;
    }


    @Data
    private static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
