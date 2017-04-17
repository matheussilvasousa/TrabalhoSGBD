import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {

	public static String deserializeFile(int key){
		String line = null;
		try {
	      FileReader file = new FileReader("arquivo.txt");
	      BufferedReader readFile = new BufferedReader(file);
	      line = readFile.readLine();
	      int i = 0;
	      while ((line != null) && (i != key)) {
	        line = readFile.readLine();
	        i++;
	      }
	      readFile.close();
	      file.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
		return line;

	}
	
}
