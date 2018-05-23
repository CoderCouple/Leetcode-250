class Solution {
    
    //https://stackoverflow.com/questions/6065710/how-does-javas-priorityqueue-differ-from-a-min-heap
    //https://stackoverflow.com/questions/1846225/java-priorityqueue-with-fixed-size
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<Integer,Integer>();
        for(int num : nums){
            if(frequencyMap.containsKey(num)){
                frequencyMap.put(num,frequencyMap.get(num)+1);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        ElementComparator ec = new ElementComparator();
        PriorityQueue<Element>  pq = new PriorityQueue<Element>(k,ec);
        for(Map.Entry<Integer,Integer> entry: frequencyMap.entrySet()){
            Element curr = new Element(entry.getKey(),entry.getValue());
            if(pq.size()<k)
                pq.add(curr);
            else if(ec.compare(pq.peek(), curr) < 0)
            {
                pq.poll();
                pq.add(curr);
            }   
        }
        
        List<Integer> result = new ArrayList<Integer>();
        while(!pq.isEmpty()){
            result.add(pq.poll().key);
        }
        
        return result;
    }
}

class Element implements Comparable<Element>{
    public int key;
    public int value;
    
    public Element(int key,int value){
        this.key=key;
        this.value=value;
    }
}

class ElementComparator implements Comparator<Element>
{
    public int compare(Element e1, Element e2)
    {
        return e1.value - e2.value;
    }
}
