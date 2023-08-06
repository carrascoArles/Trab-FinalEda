public class ResultArchivo {
    private boolean[] result;

    public ResultArchivo(int n) {
        this.result = new boolean[n];
    }

    public void setResult(int index, boolean isPlagiarized) {
        this.result[index] = isPlagiarized;
    }

    public boolean[] getResult() {
        return this.result;
    }
}