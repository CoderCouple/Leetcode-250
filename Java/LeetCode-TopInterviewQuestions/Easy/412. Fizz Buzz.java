class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>(); 
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                result.add("FizzBuzz");
                continue;
            }
            
            if(i%3==0){
                result.add("Fizz");
                continue;
            }
            
            if(i%5==0){
                result.add("Buzz");
                continue;
            }
            
            result.add(i+"");
        }
        
        return result;
    }
}
