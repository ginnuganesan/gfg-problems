/* PROBLEM DESCRIPTION

You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number. If more than one prime number exists at an equal distance, choose the smallest one. Return the head of the modified linked list.

Examples :

Input: head = 2 → 6 → 10
Output: 2 → 5 → 11

Explanation: The nearest prime of 2 is 2 itself. The nearest primes of 6 are 5 and 7, since 5 is smaller so, 5 will be chosen. The nearest prime of 10 is 11.
Input: head = 1 → 15 → 20
Output: 2 → 13 → 19

Explanation: The nearest prime of 1 is 2. The nearest primes of 15 are 13 and 17, since 13 is smaller so, 13 will be chosen. The nearest prime of 20 is 19.
Constraints:
1 <= no. of Nodes <= 104
1 <= node.val <= 104

*/

//Solution

// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        // code here
        Node temp = head;
        while (temp != null) {
            temp.val = getPrime(temp.val);
            temp = temp.next;
        }
        return head;
    }
    
    int getPrime(int num) {
        if (isPrime(num)) {
            return num;
        }
        
        int i = 1;
        while (true) {
            if (isPrime(num - i)) {
                return num - i;
            }
            if (isPrime(num + i)) {
                return num + i;
            }
            i++;
        }
    }
    
    boolean isPrime(int n)
    {
        if (n == 0 || n == 1)
            return false;
        for (int i = 2; i*i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
