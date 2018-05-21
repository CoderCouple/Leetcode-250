/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        List<Interval> result = new ArrayList<Interval>();
        List<Integer> startInterval = new ArrayList<Integer>();
        List<Integer> endInterval = new ArrayList<Integer>();
        
        if(intervals.size()<=1)
            return intervals;
        for(int i=0;i<intervals.size();i++){
            startInterval.add(intervals.get(i).start);
            endInterval.add(intervals.get(i).end);
        }
        
        Collections.sort(startInterval);
        Collections.sort(endInterval);
        
        int start = startInterval.get(0);
        int end =  endInterval.get(0);
        
        for(int i=1;i<intervals.size();i++){
           if(start<=startInterval.get(i) && startInterval.get(i)<=end){
               start = Math.min(start,startInterval.get(i));
               end = Math.max(end,endInterval.get(i));
           } else {
               Interval item = new Interval(start,end);
               result.add(item);
               start=startInterval.get(i);
               end=endInterval.get(i);
           }
        }
        result.add(new Interval(start,end));

        return result;
        
    }
}
