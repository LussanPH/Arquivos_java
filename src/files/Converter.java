package files;
import java.io.*;
import java.util.ArrayList;
public class Converter {
	public Converter() {}
	
	private String[][] fileToStringArray(File arquivo) {
		ArrayList<String> linhas = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(arquivo));
			String linha;
			while((linha = br.readLine()) != null ) {
				linhas.add(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	        
        int size = linhas.size();
        String[][] matriz = new String[2][size];
        
        for (int i = 0; i < size; i++) {
            String[] partes = linhas.get(i).split("	");
            matriz[0][i] = partes[0];
            matriz[1][i] = partes[1];
        }
        
        return matriz;
	}
		
		
	public String[][] ToNotes(File arquivo, File respostas) {
		
		String Answers = new String();
		try {
			BufferedReader br = new BufferedReader(new FileReader(respostas));
			Answers = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[][] gabarito_nomes = fileToStringArray(arquivo);
		int l = gabarito_nomes[0].length;
		Integer[] Notes = new Integer[l];
		for(int i = 0; i < l; i++ ) {
			Notes[i] = 0;
			if(gabarito_nomes[0][i].equals("VVVVVVVVVV") || gabarito_nomes[0][i].equals("FFFFFFFFFF")) {
				Notes[i] = 0;
			}
			else {
				for (int j = 0; j < 10; j++) {
					if(gabarito_nomes[0][i].charAt(j) == Answers.charAt(j)) {
						Notes[i]++;
					}
				}
			}
		}
		
		String[] NotesStr = new String[l];
		for (int i = 0; i < l; i++) {
			NotesStr[i] = Notes[i].toString();
		}
		
		gabarito_nomes[0] = NotesStr;
		
		return gabarito_nomes;
	}
	

}
