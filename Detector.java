public class Detector {
    Trie trie;
    List<List<String>> database;

    public Detector() {
        trie = new Trie();
        database = new ArrayList<>();
    }

    public void loadFiles(List<String> files) {
        for (String fileContent : files) {
            insertWordsToTrie(fileContent);
            List<String> fileWords = new ArrayList<>();
            String[] words = fileContent.toLowerCase().split("\\s+");
            for (String word : words) {
                fileWords.add(word);
            }
            database.add(fileWords);
        }
    }
}
