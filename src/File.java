import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {

	public static Page deserializeFile(int key){
		String line = null;
        Page p = null;
        try {
	      FileReader file = new FileReader("arquivo.txt");
	      BufferedReader readFile = new BufferedReader(file);
	      line = readFile.readLine();
	      int i = 1;
	      while ((line != null) && (i != key)) {
	        line = readFile.readLine();
	        i++;
	      }
          p = new Page(i, line);
	      readFile.close();
	      file.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
		return p;
	}
	
}
