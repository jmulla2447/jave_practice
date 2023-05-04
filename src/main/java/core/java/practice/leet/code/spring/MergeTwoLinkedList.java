package core.java.practice.leet.code.spring;

import java.util.Arrays;

public class MergeTwoLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void addNode(ListNode headNode, int value) {
        ListNode newNode = new ListNode(value);

        if (headNode == null) {
            headNode = newNode;
        } else {
            ListNode currentNode = headNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;

        }
    }

    public ListNode mergeTwoLists(ListNode firstListNode1, ListNode secondListNode2) {

        ListNode resultNode = null;

        while (firstListNode1 != null && secondListNode2 != null) {
            if (firstListNode1.val < secondListNode2.val) {
                addNode(resultNode, firstListNode1.val);
            } else {
                addNode(resultNode, firstListNode1.val);
            }
        }

        while (firstListNode1.next != null) {
            addNode(resultNode, firstListNode1.val);
        }

        while (secondListNode2.next != null) {
            addNode(resultNode, firstListNode1.val);
        }
        return resultNode;
    }

    public static void main(String[] args) {
        MergeTwoLinkedList list = new MergeTwoLinkedList();
        int[] a = {1, 2, 4};
        int[] b = {1, 3, 4};
        ListNode firstNode = null, secondNode = null;
        Arrays.stream(a).forEach(aa -> list.addNode(firstNode, aa));
        Arrays.stream(b).forEach(bb -> list.addNode(secondNode, bb));
        ListNode resutl = list.mergeTwoLists(firstNode, secondNode);
    }
}


