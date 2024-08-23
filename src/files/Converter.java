package files;
import java.io.*;
import java.util.ArrayList;
public class Converter {
	public Converter() {}
	
	private String[][] fileToStringArray(File arquivo) {
		ArrayList<String> linhas = new ArrayList<>();
		
		try {
			FileReader reader = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(reader);
			String linha;
			while((linha = br.readLine()) != null ) {
				linhas.add(linha);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> parte1 = new ArrayList<>();
		ArrayList<String> parte2 = new ArrayList<>();
		
		for (String s : linhas) {
            String[] partes = s.split("	");
            parte1.add(partes[0]);
            parte2.add(partes[1]);
        }
		String[] vetor1 = parte1.toArray(new String[0]);
		String[] vetor2 = parte2.toArray(new String[0]);
		
		String[][] vetores = new String[2][linhas.size()];
		vetores[0] = vetor1;
		vetores[1] = vetor2;
		
		return vetores;
	}
		
		
	public String[][] ToNotes(File arquivo){
		int RANGE_OF_ANSWER = 10;
		String[][] BruteAnswers = fileToStringArray(arquivo);
		
		
		
		
	}
	

}
