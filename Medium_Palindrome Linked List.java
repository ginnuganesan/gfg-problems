/* PROBLEM DESCRIPTION

Given a singly linked list of integers. The task is to check if the given linked list is palindrome or not.

Examples:

Input: LinkedList: 1->2->1->1->2->1
Output: true
Explanation: The given linked list is 1->2->1->1->2->1 , which is a palindrome and Hence, the output is true.

Input: LinkedList: 1->2->3->4
Output: false
Explanation: The given linked list is 1->2->3->4, which is not a palindrome and Hence, the output is false.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1) 
Note: You should not use the recursive stack space as well

Constraints:
1 <= number of nodes <= 105
1 ≤ node->data ≤ 103



*/

//Solution

/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        //Your code here
        List<Integer> list = new ArrayList<>();
        int length = 0;
        while(head != null) {
            length++;
            list.add(head.data);
            head = head.next;
        }
        for(int i = 0; i < length/2; i++) {
            if(list.get(i) != list.get(length - i - 1)) {
                return false;
            }
        }
        return true;
    }    
}

//Optimal Solution

/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // Your code here
        if(head.next == null) {
            return true;
        }
        Node temp = head;
        Node rev = reverse(head);
        while(temp != null && rev != null) {
            if(temp.data !=  rev.data) {
                return false;
            }
            temp = temp.next;
            rev = rev.next;
        }
        return true;
    }
    
    Node reverse(Node head) {
        Node prev = null;
        Node after = null;
        Node curr = head;
        while(curr != null) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
}
