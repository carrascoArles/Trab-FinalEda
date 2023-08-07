package Detectordeplagio;
import java.util.ArrayList;
import java.util.List;

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

    private void insertWordsToTrie(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            trie.insert(word);
        }
    }

    public ResultArchivo verifyPlagiarism(String textToCheck) {
        String[] wordsToCheck = textToCheck.toLowerCase().split("\\s+");
        int n = database.size();
        ResultArchivo resultChecker = new ResultArchivo(n);

        for (int i = 0; i < n; i++) {
            boolean isPlagiarized = isTextPlagiarized(wordsToCheck, database.get(i));
            String fileName = "Archivo " + (i + 1);
            String plagiarismInfo = isPlagiarized ? "Plagio detectado" : "Sin plagio";
            resultChecker.setResult(i, isPlagiarized, fileName, plagiarismInfo);
        }

        return resultChecker;
    }
    private boolean isTextPlagiarized(String[] wordsToCheck, List<String> fileWords) {
        TrieNode current = trie.root;

        for (String word : wordsToCheck) {
            char[] wordChars = word.toCharArray();
            for (char ch : wordChars) {
                TrieNode node = current.getChild(ch);
                if (node == null) {
                    return false; // mo esta en el trie pipiipip
                }
                current = node;
            }
            // Verificar si la palabra está en la base de datos
            if (!fileWords.contains(word)) {
                return false; // returna false si la palabra que buscamos en el trie no se encuentra
            }
            // vuelve a empeza
            current = trie.root;
        }
        return true;
    }
}
