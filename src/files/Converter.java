package files;
import java.io.*;
import java.util.ArrayList;
public class Converter {
	public Converter() {}
	
	public ArrayList<String> fileToArrayList(File arquivo) {
		ArrayList<String> linhas = new ArrayList<>();
		
		try {
			FileReader reader = new FileReader(arquivo);
			BufferedReader breader = new BufferedReader(reader);
			String linha;
			while((linha = breader.readLine()) != null ) {
				linhas.add(linha);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return linhas;
	}
		
		
	public ArrayList<String> ToNotes(ArrayList<String> BruteAnswers){
		ArrayList<char[]> Answers = new ArrayList<char[]>();
		ArrayList<String> Names = new ArrayList<String>();
		
		for(String l : BruteAnswers) {
			for(int i = 0; i < 10; i++) {
				char[] answer = new char[10]; 
				answer[i] = l.charAt(i);
				Answers.add(answer);
			}
			
		}
		
		
		
		return Answers;
	}
	

}
