/* PROBLEM DESCRIPTION

Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed (See Example 2 for clarification).

Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5 
Explanation: 
The first 4 elements 1,2,2,4 are reversed first 
and then the next 4 elements 5,6,7,8. Hence, the 
resultant linked list is 4->2->2->1->8->7->6->5.
Example 2:

Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4 
Explanation: 
The first 3 elements are 1,2,3 are reversed 
first and then elements 4,5 are reversed.Hence, 
the resultant linked list is 3->2->1->5->4.
Your Task:
You don't need to read input or print anything. Your task is to complete the function reverse() which should reverse the linked list in group of size k and return the head of the modified linked list.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N <= 105
1 <= k <= N

*/

//Solution

/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        Node temp = node;
        Node out = new Node(-1);
        Node res = out;
        int track = 1; 
        while(temp != null) {
            Node subList = new Node(-1);
            Node tempSub = subList;
            for(int i = 0; i < k; i++) {
                if(temp != null) {
                    tempSub.next = new Node(temp.data);
                    tempSub = tempSub.next;
                    temp = temp.next;
                }
            }
            Node rev = reverse(subList.next);
            while(rev != null) {
                res.next = rev;
                res = res.next;
                rev = rev.next;
            }
        }
        return out.next;
    }
    
    public static Node reverse(Node head) {
        Node before = null;
        Node temp = head;
        Node after = null;
        while(temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before;
    }
}
