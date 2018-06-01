class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String,Integer> freqMap = new HashMap<String,Integer>();
        Queue<Node> pq = new PriorityQueue<Node>();
        LinkedList<String> result = new LinkedList<String>();
        
        for(String word : words){
            if(freqMap.containsKey(word)){
                freqMap.put(word,freqMap.get(word)+1);
            } else {
                freqMap.put(word,1);
            }
        }
        
        for(Map.Entry<String,Integer> entry : freqMap.entrySet()){
            Node n = new Node(entry.getKey(),entry.getValue());
            if(pq.size()<k){
                  pq.add(n);
            }else {
                if(pq.peek().compareTo(n)<0){
                    pq.poll();
                    pq.add(n);
                }
                    
            }

        }
        
        System.out.println(pq.size());
        while(!pq.isEmpty()){
            Node n = pq.poll();
            result.addFirst(n.word);
        }
        
        return (List)result;
    }
}

class Node implements Comparable<Node>{
    public String word;
    public int count;
    
    public Node(String word,int count){
        this.word=word;
        this.count=count;
    }
    
    public int compareTo(Node n){
        int res = this.count-n.count;
        if(res==0){
            return n.word.compareTo(this.word);
        } else {
            return res;
        }
    }
}

==================================================== Solution 2 =========================================================
    class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String,Integer> freqMap = new HashMap<String,Integer>();
        NodeCompare nc = new NodeCompare();
        Queue<Node> pq = new PriorityQueue<Node>(10,nc);
        LinkedList<String> result = new LinkedList<String>();
        
        for(String word : words){
            if(freqMap.containsKey(word)){
                freqMap.put(word,freqMap.get(word)+1);
            } else {
                freqMap.put(word,1);
            }
        }
        
        for(Map.Entry<String,Integer> entry : freqMap.entrySet()){
            Node n = new Node(entry.getKey(),entry.getValue());
            if(pq.size()<k){
                  pq.add(n);
            }else {
                if(nc.compare(pq.peek(),n)<0){
                    pq.poll();
                    pq.add(n);
                }
                    
            }

        }
        
        System.out.println(pq.size());
        while(!pq.isEmpty()){
            Node n = pq.poll();
            result.addFirst(n.word);
        }
        
        return (List)result;
    }
}

class Node {
    public String word;
    public int count;
    
    public Node(String word,int count){
        this.word=word;
        this.count=count;
    }
}

class NodeCompare implements Comparator<Node>{
    
     public int compare(Node n1,Node n2){
        int res = n1.count-n2.count;
        if(res==0){
            return n2.word.compareTo(n1.word);
        } else {
            return res;
        }
    }
}
