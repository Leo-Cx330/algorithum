package com.leo.algorithm.链表;

import com.leo.algorithm.leetcode.ListNode;

/**
 * @Author leo
 * @Date 2021/6/7
 * @Desc 判断链表是否有环
 */

public class HasCycle {

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node3.next = node;
        node2.next = node3;
        node.next = node2;
        root.next = node;
        System.out.println(hasCycle(root));
    }

    /**
     * 快慢指针
      * @param head
     * @return
     */
    private static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null) {
            if (fast.next == slow) {
               return true;
            }
            fast = fast.next.next;
            slow = slow.next;

        }
        return false;
    }
}
