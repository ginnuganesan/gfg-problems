/* PROBLEM DESCRIPTION

Given a sorted circular linked list of length n, the task is to insert a new node in this circular list so that it remains a sorted circular linked list.

Example 1:

Input:
n = 3
LinkedList = 1->2->4
(the first and last node is connected, i.e. 4 --> 1)
data = 2
Output: 
1 2 2 4
Explanation:
We can add 2 after the second node.
Example 2:

Input:
n = 4
LinkedList = 1->4->7->9
(the first and last node is connected, i.e. 9 --> 1)
data = 5
Output: 
1 4 5 7 9
Explanation:
We can add 5 after the second node.
Your Task:
The task is to complete the function sortedInsert() which should insert the new node into the given circular linked list and return the head of the linked list.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
0 <= n <= 105

*/

//Solution

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node newNode = new Node(data);
        if(head == null) {
            newNode.next = newNode;
            head = newNode;
        } else if(head.data >= data) {
            Node tail = head;
            while(tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != head && temp.next.data < data) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
    }
}
