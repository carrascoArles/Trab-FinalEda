
public class Detector {
    private List<String> database;

    public Detector() {
        database = new ArrayList<>();
    }

    public void loadFiles(List<String> files) {
        database = files;
    }

    }