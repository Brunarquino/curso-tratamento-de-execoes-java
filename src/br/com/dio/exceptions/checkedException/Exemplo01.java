package br.com.dio.exceptions.checkedException;

import javax.swing.*;
import java.io.*;

public class Exemplo01 {
    //Implimir um arquivo no console

    public static void main(String[] args) {

        String nomeDoArquivo = "romances-blake-crouch.txt";
        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Revise o nome do arquivo");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado! entre em contato com o suporte!");
            e.printStackTrace();
        }finally {
            System.out.println("Chegou no finally");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");

    }

    private static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException { //Lançando essa exception

        File file = new File(nomeDoArquivo); // iiciando um objeto do tipo file

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        /*Padrão decorator, através da clase BufferedReader
         para criar um buffin com esse documento que quero imprimir no console
        */
        String line = br.readLine(); //Lendo linha por linha, que esta neste bunffer de cima

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));//Imprimindo no console
        //fluxo de saida do console

        //lendo cada linha
        do {
            bw.write(line);
            bw.newLine();
            line=br.readLine();
        }while (line != null); //Continua até não ter mais nada a ser lido no documento

        bw.flush(); //Descarregar esse metodo flash
        br.close(); //Fechar arquivo
        //bw.close(); // se fechar o fluxo de saida do console, fechei o fluxo de saída do console

    }

}
