public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.getChild(ch) == null) {
                current.addChild(ch, new TrieNode());
            }
            current = current.getChild(ch);
        }
        current.setEndOfWord(true);
    }
}
