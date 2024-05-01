/* PROBLEM DESCRIPTION

Given two numbers, num1 and num2, represented by linked lists of size n and m respectively. The task is to return a linked list that represents the sum of these two numbers.

For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Example 1:

Input:
n = 2
num1 = 45 (4->5->null)
m = 3
num2 = 345 (3->4->5->null)
Output: 
3->9->0->null  
Explanation: 
For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant linked list will be (3 9 0).
Example 2:

Input:
n = 4
num1 = 0063 (0->0->6->3->null)
m = 2
num2 = 07 (0->7->null)
Output: 
7->0->null
Explanation: 
For the given two linked list (0 0 6 3) and (0 7), after adding the two linked list resultant linked list will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the sum list.   

Expected Time Complexity: O(n+m)
Expected Auxiliary Space: O(max(n,m)) for the resultant list.

Constraints:
1 <= n, m <= 104

*/

//Solution

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        Node reverseNum1 = reverse(num1);
        Node reverseNum2 = reverse(num2);
        Node temp = new Node(-1);
        Node curr = temp;
        int carry = 0;
        while(reverseNum1 != null || reverseNum2 != null) {
            int l1 = reverseNum1 == null ? 0 : reverseNum1.data;
            int l2 = reverseNum2 == null ? 0 : reverseNum2.data;
            int sum = l1 + l2 + carry;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if(reverseNum1 != null) {
                reverseNum1 = reverseNum1.next;
            }
            if(reverseNum2 != null) {
                reverseNum2 = reverseNum2.next;
            }
        }
        if(carry != 0) {
            curr.next = new Node(carry);
        }
        //System.out.println(temp.next.data);
        Node result = reverse(temp.next);
        while(result != null && result.data == 0) {
            result = result.next;
        }
        return result == null ? new Node(0) : result;
        
    }
    static Node reverse(Node num){
        Node head = num;
        Node before = null;
        while(head != null) {
            Node after = head.next;
            head.next = before;
            before = head;
            head = after;
        }
        return before;
    }
}
