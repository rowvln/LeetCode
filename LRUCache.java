/*
    LRU Cache:

    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:

    - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    - int get(int key) Return the value of the key if the key exists, otherwise return -1.
    - void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    
    Follow up:
    Could you do get and put in O(1) time complexity?
 */

class LRUCache {
    // This method uses Doubly Linked-List and Hashmap to keep track of head and tail nodes.
    
    // Creates a Doubly LinkedList Node
    class DLinkedNode {
        int key; // key for k-v pair
        int value; // value for k-v pair
        DLinkedNode prev; // Current head or tail node
        DLinkedNode next; // Determines next head or tail node
    }
    
    // ------------------------------
    private void addNode(DLinkedNode node){
        // adds new node right after the head
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(DLinkedNode node){
        // Removes current node from Linked List
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void moveToHead(DLinkedNode node){
        // moves certain node in between to the head
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedNode popTail(){
        // pops current tail node
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
    
    // ------------------------------
    private Map<Integer, DLinkedNode> cache = new HashMap<>(); // New HashMap object to keep track of nodes in the running cache
    private int size; // Holds size of cache
    private int capacity; // Determines capactiy of cache
    private DLinkedNode head, tail; // New head and tail objects to keep track of where we are currently in the cache
    
    // Creates an empty cache w/ pre-determined capacity
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        
        // Create a new head and tail node tracker
        head = new DLinkedNode();
        
        tail = new DLinkedNode();
        
        // Tracks current and next node in Linked List
        tail.prev = head;
        head.next = tail;
    }
    
    // get method to get node value at key
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        
        // If node is null, terminate from looking in LL
        if(node == null) {
            return -1;
        }
        
        // move accessed node to the head
        moveToHead(node);
        
        // return the value at key
        return node.value;
    }
    
    // put method to put node in cache
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            // put new node in cache with key-value pair
            cache.put(key, newNode);
            addNode(newNode);

            size++;

            // Check to see if you are at capacity, if not then pop the tail and remove it from cache
            if(size > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        }
        
        else {
            // update value of node
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */