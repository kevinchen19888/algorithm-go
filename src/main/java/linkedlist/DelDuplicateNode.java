package linkedlist;

import lombok.Data;

/**
 * 从有序链表中删除重复节点
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 思路:
 * 1,可以通过递归来解决,首先找出基线条件:即如果链表节点为空或链表为尾节点则返回节点;
 * 2,找出递归条件:遍历链表,依次获取链表的下一个节点;
 * 3,最后处理重复逻辑,即在递归时当本节点和值与下一个节点相等时则返回下个节点,丢弃本节点,否则直接返回本节点;
 *
 * @author kevin chen
 */
public class DelDuplicateNode {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        listNode1.setVal(1);
        listNode2.setVal(2);
        listNode3.setVal(2);
        listNode4.setVal(3);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        System.out.println(delDuplicateNode(listNode1));
    }

    public static ListNode delDuplicateNode(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        listNode.next = delDuplicateNode(listNode.next);
        return listNode.val == listNode.next.val ? listNode.next : listNode;
    }

    @Data
    private static class ListNode {
        int val;
        ListNode next;
    }

}
