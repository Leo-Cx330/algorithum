package com.leo.algorithm.链表;

import com.leo.algorithm.leetcode.ListNode;


/**
 * @Author leo
 * @Date 2021/5/26
 * @Desc 请判断一个链表是否为回文链表
 * 1->2->2->1
 */
public class PalindromeLists {


    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println( isPalindrome(node));
    }

    /**
     * 回文链表
     * 1->2->2->1
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        int len = len(head);
        int mid = len / 2;
        ListNode right =head;
        ListNode left = head;
        for (int i = 1; i < len; i++) {
            if (i <= mid) {
                right = right.next;
            }else {
                right=reverse(right);
                break;
            }
        }

        while (right != null && left != null) {
            if (right.val != left.val) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode node){
       ListNode prev=null;
       while (node!=null){
           ListNode next = node.next;
           node.next=prev;
           prev=node;
           node=next;
       }
       return prev;
    }

    private static int len(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    /**
     * 快慢指针 反转列表
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        ListNode fast=head,slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        slow=reverse(slow);
        fast=head;
        while (slow!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}
