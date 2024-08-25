package files;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Organization {
    public Organization(){}

    public void organizar(String path, int n){
        File dir = new File(path);
        Integer m = n;
        Converter conv = new Converter();
        File[] files = dir.listFiles();
        Scanner sc = new Scanner(System.in);
        System.out.println("Lista contendo matérias, gabaritos, e etc.:");/*PRINTA NA TELA OS ARQUIVOS CRIADOS PARA O USUÁRIO ESCOLHER */
        for(File file : files){
            System.out.println(file.getName());
        }
        while(m != 0){
            System.out.print("Digite o arquivo da matéria que deseja organizar incluino as letras que representam seu tipo(" + m.toString() + " matéria(s) faltando):");
            String palavra = sc.next();
            File materia = new File(path, palavra);
            File gab = new File(path, "gabarito" + palavra);
            String[][] mat = conv.ToNotes(materia, gab);
            ordemAlfabetica(mat, palavra, path);
            ordemDecrescente(mat, palavra, path);
            m -= 1;
        }
        sc.close();
    }
    private void ordemAlfabetica(String[][] mat, String materiaNome, String path){
        DecimalFormat formatador = new DecimalFormat("0.00");
        File mediasAlfa = new File(path, "médiasAlfabética.txt");
        boolean trocado;
        String aux, mediaNome;
        double soma = 0, media;
        int nAlunos = 0;
        String[] nomes = new String[mat[1].length], notas = new String[mat[0].length];
        for(int i = 0; i<mat[1].length; i++){
            nomes[i] = mat[1][i];
        }
        do{
            trocado = false;
            for(int i = 0; i<nomes.length - 1; i++){
                if(nomes[i].charAt(0) > nomes[i+1].charAt(0)){
                    aux = nomes[i];
                    nomes[i] = nomes[i+1];
                    nomes[i+1] = aux;
                    trocado = true;
                }
                else if(nomes[i].charAt(0) == nomes[i+1].charAt(0)){
                    int indiceSobrenome1 = nomes[i].indexOf(" "), indiceSobrenome2 = nomes[i+1].indexOf(" ");
                    if(nomes[i].charAt(indiceSobrenome1 + 1) > nomes[i+1].charAt(indiceSobrenome2 + 1)){
                        aux = nomes[i];
                        nomes[i] = nomes[i+1];
                        nomes[i+1] = aux;
                        trocado = true;
                    }
                }
            }
        }while(trocado);
        for(int i = 0; i<nomes.length; i++){
            for(int j = 0; j<mat[1].length; j++){
                if(mat[1][j].equals(nomes[i])){
                    notas[i] = mat[0][j];
                }
            }
        }
        for(int i = 0; i<nomes.length; i++){
            mat[0][i] = notas[i];
            mat[1][i] = nomes[i];
            soma += Double.valueOf(mat[0][i]);
            nAlunos+=1;
        }
        media = soma/nAlunos;
        mediaNome = formatador.format(media);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(mediasAlfa, true))){
            int v = 0;
            bw.write(materiaNome);
            bw.newLine();
            while(v != nomes.length){
                bw.write(mat[0][v] + "\t" + mat[1][v]);
                bw.newLine();
                v++;
            }
            bw.write("Média dessa matéria: " + mediaNome);
            bw.newLine();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void ordemDecrescente(String[][] mat, String materiaNome, String path){
        DecimalFormat formatador = new DecimalFormat("0.00");
        File mediasDecre = new File(path, "médiasDecrescente.txt");
        double[] notas = new double[mat[0].length];
        String[] nomes = new String[mat[1].length];
        String mediaNome;
        double aux, soma = 0, media;
        boolean trocado;
        for(int i = 0; i<mat[0].length; i++){
            notas[i] = Double.valueOf(mat[0][i]);
        }
        do{
            trocado = false;
            for(int i = 0; i<notas.length - 1; i++){
                if(notas[i] < notas[i+1]){
                    aux = notas[i];
                    notas[i] = notas[i+1];
                    notas[i+1] = aux;
                    trocado = true;
                }
            }
        }while(trocado);
        for(int i = 0; i<notas.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(notas[i] == Double.valueOf(mat[0][j])){
                    nomes[i] = mat[1][j];
                }
            }
        }
        for(int i = 0; i<notas.length; i++){
            mat[0][i] = String.valueOf(notas[i]);
            mat[1][i] = nomes[i];
            soma += notas[i];
        }
        media = soma/notas.length;
        mediaNome = formatador.format(media);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(mediasDecre, true))){
            int v = 0;
            bw.write(materiaNome);
            bw.newLine();
            while(v != nomes.length){
                bw.write(mat[0][v] + "\t" + mat[1][v]);
                bw.newLine();
                v++;
            }
            bw.write("Média dessa matéria: " + mediaNome);
            bw.newLine();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void gabarito(String nome, String path, Scanner sc){
        File gabarito = new File(path, "gabarito" + nome + ".txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(gabarito))){
            System.out.print("Digite o gabarito dessa matéria: ");
            String g = sc.next();
            bw.write(g);
        }
        catch(IOException e){
            System.out.println(e.getMessage());;
        }
    }
}
