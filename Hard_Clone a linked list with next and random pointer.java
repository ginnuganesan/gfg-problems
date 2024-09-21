/* PROBLEM DESCRIPTION

You are given a special linked list where each node has a next pointer pointing to its next node. You are also given some random pointers, where you will be given some pairs denoting two nodes a and b i.e. a->random = b (random is a pointer to a random node).

Construct a copy of the given list. The copy should consist of the same number of new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the original and copied list pointers represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes x and y in the original list, where x->random = y, then for the corresponding two nodes xnew and ynew in the copied list, xnew->random = ynew.

Return the head of the copied linked list.

NOTE : 
1. If there is any node whose arbitrary pointer is not given then it's by default NULL. 
2. Don't make any changes to the original linked list.

ArbitLinked List1

Note: The diagram isn't part of any example, it just depicts an example of how the linked list may look.

Examples:

Input: LinkedList: 1->2->3->4 , pairs = [{1,2},{2,4}]
Output: true
Explanation: In this test case, there are 4 nodes in linked list.  Among these 4 nodes,  2 nodes have arbitrary pointer set, rest two nodes have arbitrary pointer as NULL. Second line tells us the value of four nodes. The third line gives the information about arbitrary pointers. The first node arbitrary pointer is set to node 2.  The second node arbitrary pointer is set to node 4.
Input: LinkedList: 1->3->5->9 , pairs[] = [{1,1},{3,4}]
Output: true
Explanation: In the given testcase, applying the method as stated in the above example, the output will be 1.
Expected Time Complexity: O(n)
Expected Auxilliary Space: O(1)

Constraints:
1 <= numbers of random pointer <= number of nodes <= 100
0 <= node->data <= 1000
1 <= a, b <= 100

*/

//Solution

/*
class Node {
    int data;
    Node next, random;

    Node(int d)
    {
        data = d;
        next = random = null;

    }
}*/

class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        Node temp = head;

        //created new nodes and inserted between each original node
        while(temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        //mark random nodes for all new nodes
        temp = head;
        while(temp != null) {
            Node newNode = temp.next;
            if(temp.random != null) {
                newNode.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        //mark next nodes for all new nodes and revert back the original LL
        temp = head;
        Node dummy = new Node(-1);
        Node ptr = dummy;
        while(temp != null) {
            ptr.next = temp.next;
            temp.next = ptr.next.next;
            ptr = ptr.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
