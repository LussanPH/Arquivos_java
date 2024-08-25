package Trabalho.main;
import java.io.*;

import Trabalho.files.*;/*NÃO ESQUECER DE TIRAR O TRABALHO. */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
	Scanner teclado = new Scanner(System.in);
        Organization o = new Organization();
        System.out.println("Insira o caminho onde o arquivo das matérias serão armazenados: ");/*SELECIONA A PASTA ONDE VÃO FICAR OS ARQUIVOS */
        String path = teclado.nextLine();
        System.out.println("Insira o numero de matérias");
        int n = teclado.nextInt();

        for(int i=0;i<n;i++){
                Arquivo disciplina;
            	System.out.print("Insira o nome da matéria: ");
           	String nome = teclado.next();
                o.gabarito(nome, path, teclado);
                System.out.print("Insira o número de alunos nessa matéria: ");
            	int numAlunos = teclado.nextInt();
            	teclado.nextLine();
                String sistema = System.getProperty("os.name");/*VERIFICA O SISTEMA OPERACIONAL UTILIZADO POR CAUSA DA UTILIZAÇÃO DIFERENTE DAS BARRAS PARA CAMINHO */
                if(sistema == "Windows 10" || sistema == "Windows 11"){
                    disciplina = new Arquivo(path + "\\" + nome);
                }
                else{
                    disciplina = new Arquivo(path + "/" + nome);
                }
            	disciplina.criarArquivo();

            for(int j=0;j<numAlunos;j++){
                System.out.println("Insira o nome do aluno, pressione enter, e depois as respostas dele");
                String aluno = teclado.nextLine();
                String respostas = teclado.nextLine();
                disciplina.escrever(aluno, respostas);
            }
            disciplina.fecharEscritores();
        }
        o.organizar(path, n);/*AQUI ORGANIZA AS NOTAS EM ORDEM ALFABETICA E DECRESCENTE E FAZ AS MEDIAS */
        teclado.close();
		

	}

}
