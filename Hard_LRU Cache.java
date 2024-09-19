/* PROBLEM DESCRIPTION

Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes the number of queries. Query can be of two types:

SET x y: sets the value of the key x with value y
GET x: gets the key of x if present else returns -1.
The LRUCache class has two methods get() and set() which are defined as follows.

get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
set(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
In the constructor of the class the capacity of the cache should be initialized.
Examples:

Input: cap = 2, Q = 2, Queries = SET 1 2, GET 1
Output: 2
Explanation: Cache Size = 2
SET 1 2 will insert the key-value pair (1,2) in the cache,
GET 1 will print the value corresponding to Key 1, ie 2.
Input: cap = 2,Q = 8, Queries = SET 1 2, SET 2 3, SET 1 5, SET 4 5, SET 6 7, GET 4, SET 1 2, GET 3
Output: 5 -1
Explanation: Cache Size = 2
SET 1 2 will insert the pair (1,2) in the cache.
SET 2 3 will insert the pair (2,3) in the cache: 1->2, 2->3(the most recently used one is kept at the rightmost position) 
SET 1 5 will replace the value of 1 from 2 to 5 : 2 -> 3, 1 -> 5
SET 4 5 : 1 -> 5, 4 -> 5 (Cache size is 2, hence we delete the least recently used key-value pair)
SET 6 7 : 4 -> 5, 6 -> 7 
GET 4 : Prints 5 (The cache now looks like 6 -> 7, 4->5)
SET 1 2 : 4 -> 5, 1 -> 2  (Cache size is 2, hence we delete the least recently used key-value pair)
GET 3 : No key value pair having key = 3. Hence, -1 is printed.
Expected Time Complexity: O(1) for both get() and set().
Expected Auxiliary Space: O(1) for both get() and set(). 
(Although, you may use extra space for cache storage and implementation purposes).

Constraints:
1 <= cap <= 10^3
1 <= Q <= 10^5
1 <= x, y <= 10^4

*/

//Solution

// design the class in the most optimal way

class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    
    LRUCache(int cap) {
        // code here
        this.capacity = cap;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        // your code here
        if(!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public void set(int key, int value) {
        // your code here
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        add(newNode);
        
        if(map.size() > capacity) {
            Node toRemove = tail.prev;
            remove(toRemove);
            map.remove(toRemove.key);
        }
    }
    
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if(prev != null) {
            prev.next = next;
        }
        if(next.prev != null) {
            next.prev = prev;
        }
    }
    
    private void add(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
}

// Structure of Doubly Linked List
class Node
{
	int key;
	int value;
	Node next;
	Node prev;
	Node(int key, int value)
	{
	    this.key = key;
	    this.value = value;
	    this.next = this.prev = null;
	}
}
