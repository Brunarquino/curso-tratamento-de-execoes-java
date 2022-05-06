package br.com.dio.exceptions.exceptionPersonalizada;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.*;

public class Exemplo01 {
    public static void main(String[] args) {
        String nomeDoArquivo = JOptionPane.showInputDialog("Nome do arquivo a ser exibido: ");

        imprimirArquivoNoConsole(nomeDoArquivo);
        System.out.println("\nPrograma Continua...");
    }

    //Tratamento da exeção dentro do método
    private static void imprimirArquivoNoConsole(String nomeDoArquivo) {

        try {
            BufferedReader br = lerArquivo(nomeDoArquivo);
            String line = br.readLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            do {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }while (line != null);
            bw.flush();
            br.close();
        } catch (ImpossivelAberturaDeArquivoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado! entre em contato com o suporte!");
            e.printStackTrace();
        }
    }

    //leitura de um arquivo
    private static BufferedReader lerArquivo(String nomeDoArquivo) throws ImpossivelAberturaDeArquivoException {

        /*try(BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo))){

        }finally {

        }*/ //add void

        File file = new File(nomeDoArquivo);
        try {
            return new BufferedReader(new FileReader(nomeDoArquivo));
        } catch (FileNotFoundException e) {
            throw new ImpossivelAberturaDeArquivoException(file.getName(), file.getPath());
        }
    }


}

class ImpossivelAberturaDeArquivoException extends Exception{

    //Quero saber o nome do arquivo
    private String nomeDoArquivo;
    //Diretorio do arquivo
    private String diretorio;

    public ImpossivelAberturaDeArquivoException(String nomeDoArquivo, String diretorio) {
        super("O arquivo " +  nomeDoArquivo + " não foi encontrado no diretorio " + diretorio);
        this.nomeDoArquivo = nomeDoArquivo;
        this.diretorio = diretorio;
    }

    @Override
    public String toString() {
        return "ImpossivelAberturaDeArquivoException{" +
                "nomeDoArquivo='" + nomeDoArquivo + '\'' +
                ", diretorio='" + diretorio + '\'' +
                '}';
    }
}
