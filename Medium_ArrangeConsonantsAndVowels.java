/* PROBLEM DESCRIPTION

Given a singly linked list having n nodes containing english alphabets ('a'-'z'). Rearrange the linked list in such a way that all the vowels come before the consonants while maintaining the order of their arrival. 

Example 1:

Input:
n = 9
linked list: a -> b -> c -> d -> e -> f -> g -> h -> i 
Output: 
a -> e -> i -> b -> c -> d -> f -> g -> h
Explanation: 
After rearranging the input linked list according to the condition the resultant linked list will be as shown in output.
Example 2:

Input:
n = 8
linked list: a -> b -> a -> b -> d -> e -> e -> d 
Output: 
a -> a -> e -> e -> b -> b -> d -> d
Explanation: 
After rearranging the input linked list according to the condition the resultant linked list will be as shown in output.
Your Task:
Your task is to complete the function arrangeCV(), which takes head of linked list and arranges the list in such a way that all the vowels come before the consonants while maintaining the order of their arrival and returns the head of the updated linked list.

Expected Time Complexity :  O(n)
Expected Auxiliary Space :  O(1)

Constraints:
1 <= n <= 104
'a' <= elements of linked list <= 'z'

*/

//Solution

/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head) {
        //write code here and return the head of changed linked list
        Node temp = head;
        Node out = new Node('1');
        Node outTemp = out;
        Node prev = null;
        while(temp != null) {
            if(isVowel(temp.data)) {
                outTemp.next = new Node(temp.data);
                outTemp = outTemp.next;
                if(head == temp) {
                    head = head.next;
                } else {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;   
            }
            temp = temp.next;
        }
        outTemp.next = head;
        return out.next;
    }
    
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch =='o' || ch == 'u';
    }
}
