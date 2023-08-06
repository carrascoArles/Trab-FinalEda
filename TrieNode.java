class TrieNode{
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
    
    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
     
    public TrieNode getChild(char ch) {
        int index = ch - 'a';
        if (index >= 0 && index < 26) {
            return children[index];
        }
        return null;
    }

    public void addChild(char ch, TrieNode node) {
        int index = ch - 'a';
        if (index >= 0 && index < 26) {
            children[index] = node;
        }
    }
}
