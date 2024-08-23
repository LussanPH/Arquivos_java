package files;
import java.io.*;

public class Arquivo {

    private String nome;
    private File disciplina;
    private FileWriter fw;
    private BufferedWriter bw;

    public Arquivo(String nome){
        this.nome = nome;
    }

    public void criarArquivo(){
        try {
            disciplina = new File(nome + ".txt");
            if (disciplina.createNewFile()) {  // Aqui realmente cria o arquivo e pode lançar IOException
                System.out.println("Arquivo criado: " + disciplina.getName());
                fw = new FileWriter(disciplina);
                bw = new BufferedWriter(fw);
            } else {
                System.out.println("Arquivo já existe.");
            }

        } catch(IOException e){
            System.out.println("Ocorreu um erro.");
        }
    }

    public void escrever(String nomeAluno, String respostasAluno){
        try { 
            bw.write(respostasAluno+"\t"+nomeAluno);
            bw.newLine();
        } catch(IOException e){
            System.out.println("Ocorreu um erro.");
        }
    }

    public void fecharEscritores(){
        try{
            bw.close();
            fw.close();
        } catch(IOException e){
            System.out.println("Ocorreu um erro.");
        }
    }
}
