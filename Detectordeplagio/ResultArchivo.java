package Detectordeplagio;
public class ResultArchivo {
    private int n;
    private boolean[] results;
    private String[] fileNames;
    private String[] plagiarismInfo;

    public ResultArchivo(int n) {
        this.n = n;
        results = new boolean[n];
        fileNames = new String[n];
        plagiarismInfo = new String[n];
    }

    public void setResult(int index, boolean result, String fileName, String plagiarismInfo) {
        results[index] = result;
        fileNames[index] = fileName;
        this.plagiarismInfo[index] = plagiarismInfo;
    }

    public boolean[] getResult() {
        return results;
    }

    public String[] getFileNames() {
        return fileNames;
    }

    public String[] getPlagiarismInfo() {
        return plagiarismInfo;
    }
}