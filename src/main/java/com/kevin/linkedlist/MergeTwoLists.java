package com.kevin.linkedlist;

import lombok.Builder;
import lombok.Data;

/**
 * 归并两个有序的链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author kevin chen
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode list11 = ListNode.builder().val(2).build();
        ListNode list12 = ListNode.builder().val(6).build();
        ListNode list13 = ListNode.builder().val(8).build();
        list11.setNext(list12);
        list12.setNext(list13);

        ListNode list21 = ListNode.builder().val(5).build();
        ListNode list22 = ListNode.builder().val(6).build();
        ListNode list23 = ListNode.builder().val(7).build();
        list21.setNext(list22);
        list22.setNext(list23);

        System.out.println(mergeTwoLists(list11, list21));
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            // 如果l1的值小于l2,则将l2值链接在l1后面
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }


    @Data
    @Builder
    private static class ListNode {
        ListNode next;
        int val;
    }

}
