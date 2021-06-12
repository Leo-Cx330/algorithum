package com.leo.algorithm.链表;

import com.leo.algorithm.leetcode.ListNode;

import java.util.Stack;

/**
 * @Author leo
 * @Date 2021/5/6
 * @Desc 反转列表
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverseList = reverseList3(listNode);
        while (reverseList != null) {
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }

    }

    /**
     * 栈实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        ListNode root = new ListNode(stack.pop());
        ListNode parent = null;
        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            if (parent == null) {
                parent = new ListNode(val);
                root.next = parent;
            } else {
                parent.next = new ListNode(val);
                parent = parent.next;
            }
        }
        return root;

    }

    /**
     * 双链表实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = temp;
            temp = node;
            head = head.next;
        }
        return temp;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode node = reverseList3(next);
        next.next=head;
        head.next=null;
        return node;
    }
}
