class Solution {
    public String frequencySort(String s) { 
        StringBuilder result = new StringBuilder();
        Map<Character,Node> map = new HashMap<Character,Node>();
        for(int i=0; i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                Node n = map.get(s.charAt(i));
                n.sb.append(Character.toString(s.charAt(i)));
                n.count=n.count+1;
            } else {
                Node n = new Node(Character.toString(s.charAt(i)),1);
                map.put(s.charAt(i),n);
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(Map.Entry<Character,Node> entry : map.entrySet()){
            pq.add(entry.getValue());
        }
                            
        while(!pq.isEmpty()){
            Node n = pq.poll();
            result.append(n.sb.toString());
        }   
                            
        return result.toString();
    } 
  }
                            
                            
class Node implements Comparable<Node>{
    public StringBuilder sb;
    public int count;
    
    public Node(String str, int count){
        this.sb=new StringBuilder(str);
        this.count = count;
    }
    
    @Override
    public int compareTo(Node n){
        return n.count-this.count;
    }
    
} 


===========================================Solution 2 =====================================================
    
    
