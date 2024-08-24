package main;
import java.io.*;

import files.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
        	System.out.println("Insira o numero de materias");
        	int n = teclado.nextInt();

        	for(int i=0;i<n;i++){
            		System.out.println("Insira o nome da materia e o número de alunos");
           		String nome = teclado.next();
            		int numAlunos = teclado.nextInt();
            		teclado.nextLine();
            		Arquivo disciplina = new Arquivo(nome);
            		disciplina.criarArquivo();

            	for(int j=0;j<numAlunos;j++){
                	System.out.println("Insira o nome do aluno e as respostas dele");
                	String aluno = teclado.nextLine();
                	String respostas = teclado.nextLine();
                	disciplina.escrever(aluno, respostas);
            	}
            	disciplina.fecharEscritores();
        	}
        	teclado.close();

	}

}
