class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('*');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode rootNode=root;
        for(char c: word.toCharArray()){
            if(!rootNode.children.containsKey(c))
                rootNode.children.put(c,new TrieNode(c));
            rootNode =  rootNode.children.get(c);
        }
        rootNode.isLeaf=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWord(word,root);
    }
    public boolean searchWord(String word,TrieNode root) {
        TrieNode rootNode=root;
        int i=0;
        for(char c : word.toCharArray()){
            if(c=='.'){
                for(char key: rootNode.children.keySet()){
                 if(searchWord(word.substring(i+1),rootNode.children.get(key)))
                     return true;
                }
                return false;

            } else {
                if(!rootNode.children.containsKey(c))
                    return false;
                rootNode=rootNode.children.get(c);
                i++;
            }
    }
        return rootNode.isLeaf;
  }
}

 class TrieNode{
    char c;
    Map<Character,TrieNode> children;
    boolean isLeaf;
        
     public TrieNode(char c){
        this.c=c;
        children = new HashMap<Character,TrieNode>();
        this.isLeaf=false;
    }
    
    public TrieNode(char c,boolean isLeaf){
        this.c=c;
        children = new HashMap<Character,TrieNode>();
        this.isLeaf=isLeaf;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
