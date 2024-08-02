package concretes.solutions.leetcode.linked_list;

import java.util.Iterator;

import abstracts.Solution;
import concretes.leetcode.linkedlist.ListNode;

public class Leetcode_2 extends Solution {

    private ListNode l1;
    private ListNode l2;
    private ListNode res;

    class LinkedList {
        private ListNode head;
        private ListNode tail;

        public LinkedList() {
        }

        public LinkedList(ListNode head) {
            this.head = head;
            this.tail = head;
        }

        public ListNode getHead() {
            return head;
        }

        public void setHead(ListNode head) {
            this.head = head;
        }

        public void add(int x) {
            if (this.head == null) {
                this.head = new ListNode(x);
                this.tail = this.head;
            } else {
                ListNode temp = new ListNode(x);
                this.tail.next = temp;
                this.tail = temp;
            }
        }
        
    }

    @Override
    public void prepareInput() {
        Iterator<String> iterator = this.input.iterator();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        int size1 = Integer.parseInt(iterator.next());
        for (int i = 0; i < size1; i++) {
            list1.add(Integer.parseInt(iterator.next()));
        }

        int size2 = Integer.parseInt(iterator.next());
        for (int i = 0; i < size2; i++) {
            list2.add(Integer.parseInt(iterator.next()));
        }

        this.l1 = list1.getHead();
        this.l2 = list2.getHead();
    }

    @Override
    public void prepareOutput() {
        while (this.res != null) {
            this.output.add(String.format("%d -> ", this.res.val));
            this.res = this.res.next;
        }
    }

    @Override
    public void solveProblem() {
        this.res = this.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int size1 = 1;
        int size2 = 1;
        for (; temp1.next != null; temp1 = temp1.next) size1++;
        for (; temp2.next != null; temp2 = temp2.next) size2++;
        if (size1 < size2) normalize(temp1, size2 - size1);
        else normalize(temp2, size1 - size2);
        temp1 = l1;
        temp2 = l2;
        int carry = 0;

        while (temp2 != null) {
            int sum = (temp1.val + temp2.val + carry);
            int resultantSum = sum % 10;
            carry = sum / 10;
            temp2.val = resultantSum;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (carry != 0) {
            temp2 = l2;
            while (temp2.next != null) temp2 = temp2.next;
            temp2.next = new ListNode(carry);
        }

        return l2;
    }

    public void normalize(ListNode node, int count) {
        while (count > 0) {
            node.next = new ListNode(0);
            node = node.next;
            count--;
        }
    }
    
}
