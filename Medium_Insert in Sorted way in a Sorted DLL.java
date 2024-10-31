/* PROBLEM DESCRIPTION

Given a sorted doubly linked list and an element x, you need to insert the element x into the correct position in the sorted Doubly linked list(DLL).

Note: The DLL is sorted in ascending order

Example:

Input: LinkedList: 3->5->8->10->12 , x = 9

Output: 3->5->8->9->10->12

Explanation: Here node 9 is inserted in the Doubly Linked-List.
Input: LinkedList: 1->4->10->11 , x = 15

Output: 1->4->10->11->15

Constraints:
1 <= number of nodes <= 103
1 <= node -> data , x <= 104

*/

//Solution

/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code here
        if(head.data >= x) {
            Node newNode = new Node(x);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }
        if(head != null && head.next == null && head.data < x) {
            Node newNode = new Node(x);
            head.next = newNode;
            newNode.prev = head;
            return head;
        }
        Node temp = head.next;
        Node pre = temp;
        while(temp != null) {
            if(x >= temp.prev.data && x <= temp.data) {
                Node newNode = new Node(x);
                Node prev = temp.prev;
                prev.next = newNode;
                newNode.next = temp;
                newNode.prev = prev;
                temp.prev = newNode;
                return head;
            }
            pre = temp;
            temp = temp.next;
        }
        Node newNode = new Node(x);
        pre.next = newNode;
        newNode.prev = pre;
        return head;
    }
}
