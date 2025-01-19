/* PROBLEM DESCRIPTION

Given the head of a singly linked list, your task is to left rotate the linked list k times.

Examples:

Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

Input: head = 10 -> 20 -> 30 -> 40 , k = 6
Output: 30 -> 40 -> 10 -> 20 
 
Constraints:

1 <= number of nodes <= 105
0 <= k <= 109
0 <= data of node <= 109

*/

//Solution

/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if (head.next == null) {
            return head;
        }
        Node temp = head;
        Node tail = null;
        int length = 0;
        while(temp != null) {
            length++;
            tail = temp;
            temp = temp.next;
        }
        
        if(k == length) {
            return head;
        }
        k = k % length;
        for(int i = 0; i < k; i++) {
            Node newTail = head;
            head = head.next;
            newTail.next = null;
            tail.next = newTail;
            tail = newTail;
        }
        return head;
    }
}
