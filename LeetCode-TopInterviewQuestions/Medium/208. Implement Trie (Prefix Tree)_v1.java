class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode('*');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
         TrieNode rootNode=root;
        for(char c: word.toCharArray()){
            TrieNode child;
            if(!rootNode.children.containsKey(c)){
                child = new TrieNode(c);
                rootNode.children.put(c,child);
            } else {
                child =  rootNode.children.get(c);
            }
            rootNode = child;
        }
        rootNode.isLeaf=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        System.out.println("Search Word : "+word);
        TrieNode rootNode=root;
        for(char c : word.toCharArray()){
            if(!rootNode.children.containsKey(c)){
                return false;
            }
            else {
                rootNode=rootNode.children.get(c);
            }
        }
        if(rootNode.isLeaf){
            System.out.println("Search : "+"true");
            return true;
        }
        System.out.println("Search : "+"false");  
        return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        System.out.println("startsWith Word : "+prefix);
        TrieNode rootNode=root;
        for(char c : prefix.toCharArray()){
            if(!rootNode.children.containsKey(c)){
                return false;
            }
            else {
                rootNode=rootNode.children.get(c);
            }
        }
//         if(!rootNode.isLeaf){
//             System.out.println("startsWith : "+"true");
//             return true;
//         }
            
//         System.out.println("startsWith : "+"false");
        return true;
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


================================================Solution 2=================================================
    
    
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
       System.out.println("Search Word : "+word);
        TrieNode rootNode=root;
        for(char c : word.toCharArray()){
            if(!rootNode.children.containsKey(c))
                return false;
            rootNode=rootNode.children.get(c);
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
