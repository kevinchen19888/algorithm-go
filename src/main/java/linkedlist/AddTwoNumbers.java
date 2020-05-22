package linkedlist;

import lombok.Data;

/**
 * 两数之和
 * 题目:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 思路:
 * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0，比如 177 + 23 = 177 + 023 = 200
 * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
 * 如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
 * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 *
 * @author kevin chen
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(7);
        LinkNode node12 = new LinkNode(7);
        LinkNode node13 = new LinkNode(1);
        node1.next = node12;
        node12.next = node13;
        LinkNode node2 = new LinkNode(3);
        LinkNode node22 = new LinkNode(2);
        node2.next = node22;
        System.out.println(addTwoNumbers(node1, node2));
    }

    public static LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {
        LinkNode pre = new LinkNode(0);
        LinkNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new LinkNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            cur.next = new LinkNode(carry);
        }

        return pre.next;
    }

    @Data
    static class LinkNode {
        private int val;
        private LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

}
