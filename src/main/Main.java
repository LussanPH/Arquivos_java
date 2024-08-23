package main;
import java.util.ArrayList;
import java.io.*;

import files.*;

public class Main {
	public static void main(String[] args) {
		File file = new File("storage/folha_de_respostas.txt");
		Converter conv = new Converter();
		ArrayList<String> list = conv.fileToArrayList(file);
		
		for(String l : list) {
			System.out.println(l);
		}

	}

}
