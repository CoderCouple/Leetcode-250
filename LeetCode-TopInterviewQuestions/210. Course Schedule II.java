class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> PreReqGraph = new HashMap<Integer,Set<Integer>>();
        Map<Integer,Set<Integer>> PostReqGraph = new HashMap<Integer,Set<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        int newNode=0;
        int toBeProcessed=0;

        for(int row=0; row<prerequisites.length;row++){
            if(PreReqGraph.containsKey(prerequisites[row][0])){
                Set<Integer> set = PreReqGraph.get(prerequisites[row][0]);
                set.add(prerequisites[row][1]);
                PreReqGraph.put(prerequisites[row][0],set);
            }else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(prerequisites[row][1]);
                PreReqGraph.put(prerequisites[row][0],set);
            }
            
            if(PostReqGraph.containsKey(prerequisites[row][1])){
                Set<Integer> set =PostReqGraph.get(prerequisites[row][1]);
                set.add(prerequisites[row][0]);
                PostReqGraph.put(prerequisites[row][1],set);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(prerequisites[row][0]);
                PostReqGraph.put(prerequisites[row][1],set);
            }
        }
        
        for(int i=0; i<numCourses;i++){
            Set<Integer> set = new HashSet<Integer>();
            if(!PreReqGraph.containsKey(i))
            PreReqGraph.put(i,set);
            
             if(!PostReqGraph.containsKey(i))
            PostReqGraph.put(i,set);
        }

        for(Map.Entry<Integer,Set<Integer>> entry : PreReqGraph.entrySet()){
            if(entry.getValue().isEmpty()){
                result.add(entry.getKey());
                 newNode++;
            }
        }
        
        if(newNode==0){
             return new int[0];
        }
        
        while(toBeProcessed<newNode){
            int key = result.get(toBeProcessed);
            PreReqGraph.remove(key);
            Set<Integer> set = PostReqGraph.get(key);
            for(int item : set){
                Set<Integer> s = PreReqGraph.get(item);
                    s.remove(key);
                if(s.isEmpty()){
                    result.add(item);
                    newNode++;
                }
            }
            toBeProcessed++;
        }
        
        if(PreReqGraph.isEmpty()){
            int [] resultArray = new int[result.size()];
              for(int i=0;i<result.size();i++){
                  resultArray[i]=result.get(i);
              }
            return resultArray;
        }
        
        return new int[0];
    }
}
