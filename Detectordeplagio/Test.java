package Detectordeplagio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       // Ejemplo de uso:

       List<String> files = new ArrayList<>();
       files.add("este archivo recibe muchas cosas");
       files.add("este archivo recibe muchas almacenadas cosas");
       // Agregar más archivos a la lista...


       Detector detector = new Detector();
       detector.loadFiles(files);

       String textToCheck = "recibe muchas almacenadas";
       
       ResultArchivo result = detector.verifyPlagiarism(textToCheck);

       // Imprimir resultados
       boolean[] plagiarismResults = result.getResult();
       String[] fileNames = result.getFileNames();
       String[] plagiarismInfo = result.getPlagiarismInfo();
       for (int i = 0; i < plagiarismResults.length; i++) {
           System.out.println(fileNames[i] + " - Plagio: " + plagiarismResults[i]);
           System.out.println("   " + plagiarismInfo[i]);
       }
   }
}

