class LRUCache {
    
    int capacity=0;
    DNode head=null;
    DNode tail=null;
    Map<Integer,DNode> map=null;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<Integer,DNode>();
        head = new DNode(-1,-1);
        tail = new DNode(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public void cleanUpSpace(DNode node){
        if(capacity<map.size()){
            removeNode(node);
            map.remove(node.key);
        }       
    }
    
    public DNode removeNode(DNode nodeToBeRemoved){
        System.out.println(nodeToBeRemoved.key+"   "+nodeToBeRemoved.value);
        DNode prevNode = nodeToBeRemoved.prev;
        DNode nextNode = nodeToBeRemoved.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        // nodeToBeRemoved.next = null;
        // nodeToBeRemoved.prev = null;
        return nodeToBeRemoved;
    }
    
    public void addAtTail(DNode nodeToBeAdded){
        DNode prevNode=tail.prev;
        prevNode.next=nodeToBeAdded;
        nodeToBeAdded.next=tail;
        nodeToBeAdded.prev=prevNode;
        tail.prev=nodeToBeAdded;
    }
    
    public void moveToTail(DNode nodeToBeTransfered){
        addAtTail(removeNode(nodeToBeTransfered));
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        DNode node = map.get(key);
        moveToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0)
            return;
        if(!map.containsKey(key)){
            DNode node = new DNode(key,value);
            addAtTail(node);
            map.put(key,node);
            cleanUpSpace(head.next);
        } else{
            DNode node = map.get(key);
            node.value=value;
            moveToTail(node);
        }
        //printMap(); 
        //System.out.println("=============");
    }
    
    public void printMap(){
        for(Map.Entry<Integer,DNode> entry : map.entrySet()){
            DNode node = entry.getValue();
            System.out.println("Key : "+node.key+"  Value : "+node.value);
        }
    }
}


class DNode{
    int key;
    int value;
    DNode prev;
    DNode next;
    
    
    public DNode(int key,int value){
        this.key=key;
        this.value=value;
        this.prev=null;
        this.next=null;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
