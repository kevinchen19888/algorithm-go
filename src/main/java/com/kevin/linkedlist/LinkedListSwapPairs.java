package com.kevin.linkedlist;

import lombok.Data;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 题目要求：不能修改结点的 val 值，O(1) 空间复杂度。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 应该返回 2->1->4->3.
 * <p>
 * 思路:
 * 1,设置一个偏移指针cur,从head节点开始,每隔一个节点进行移动;
 * 2,cur指针对应节点,与链接的下一个节点进行交换,交换完毕移动cur(注意:在交换前需要提供一个临时节点变量来存储cur链接的下一个节点);
 *
 * @author kevin chen
 */
public class LinkedListSwapPairs {

    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        LinkNode linkNode2 = new LinkNode(2);
        LinkNode linkNode3 = new LinkNode(3);
        LinkNode linkNode4 = new LinkNode(4);

        head.setNext(linkNode2);
        linkNode2.setNext(linkNode3);
        linkNode3.setNext(linkNode4);
        System.out.println(linkedListSwapPairs(head));
    }

    /**
     * 使用递归
     * <p>
     * 关注点:
     * 返回值：交换完成的子链表
     * 调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
     * 终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
     *
     * @param head
     */
    public static LinkNode linkedListSwapPairs(LinkNode head) {
        //LinkNode cur = head;
        //boolean pendAlter = true;
        //while (cur != null) {
        //    LinkNode next = cur.next;
        //    LinkNode nextCur = cur.next;
        //    if (next != null) {
        //        LinkNode nextCurs = next.next;
        //        cur.setNext(nextCurs);
        //        next.setNext(cur);
        //        if (pendAlter) {
        //            head = next;
        //            pendAlter = false;
        //        }
        //    }
        //    cur = next;
        //}
        //return head;
        if (head == null || head.next == null) {
            return head;
        }
        // 预先存储head链接的下个节点
        LinkNode next = head.next;
        // 递归进行下次交换(使用head的下下个节点进行下次交换)
        head.next = linkedListSwapPairs(next.next);
        // 交换
        next.next = head;
        return next;
    }


    @Data
    private static class LinkNode {
        LinkNode next;
        int val;

        public LinkNode(int val) {
            this.val = val;
        }
    }
}
