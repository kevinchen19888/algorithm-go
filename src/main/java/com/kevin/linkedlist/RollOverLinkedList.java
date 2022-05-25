package com.kevin.linkedlist;

import lombok.Data;

/**
 * k个一组翻转链表
 */
public class RollOverLinkedList {
    // k=2 情况下的翻转
    public static void main(String[] args) {
        int k = 2;

        Node head = new Node(1);
        Node nex2 = new Node(2);
        Node nex3 = new Node(3);
        Node nex4 = new Node(4);
        Node nex5 = new Node(5);
        head.next = nex2;
        nex2.next = nex3;
        nex3.next = nex4;
        nex4.next = nex5;

        // System.out.println("翻转前:"+head);
        // reverseGroup(k, head);
        // System.out.println("翻转后:"+head);
        System.out.println(head);
        Node[] reverse = reverse(head, nex5);
        System.out.println(reverse[0]);

    }

    private static Node reverseGroup(int k, Node head) {
        Node hair = new Node(0);
        hair.next = head;
        Node pre = hair;

        while (head != null) {
            Node tail = pre;
            // 判断剩余部分长度是否>= k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            Node nex = tail.next;

            Node[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回远链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    private static Node[] reverse(Node head, Node tail) {
        Node prev = null;
        // Node prev = tail.next;
        Node hea = head;
        while (prev != tail) {
            Node nex = hea.next;
            hea.next = prev;
            prev = hea;
            hea = nex;
        }

        return new Node[]{tail, head};
    }


    @Data
    private static class Node {
        public Node(int val) {
            this.val = val;
        }

        int val;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

