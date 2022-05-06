package br.com.dio.exceptions.uncheckedException;

import javax.swing.*;

public class Exemplo01{
    //Fazer a divisão de números inteiros
    public static void main(String[] args) {

        boolean continueLooping = true;
        do {

            String a = JOptionPane.showInputDialog("Numerator: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try {
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;

            } catch (NumberFormatException e) { // " e " é um objeto - herda os métodos dessa exeption aqui
                //Caso entre uma string que não de para converter
                JOptionPane.showMessageDialog(null, "Entrada inválida, informe um número inteiro!" +  e.getMessage());
                // e.printStackTrace(); //Imprimir a exeption
            }catch (ArithmeticException e){
                //Caso o usuario tente divir por 0
                JOptionPane.showMessageDialog(null, "Impossivel dividir um número por zero por 0! ");
            }
            finally {
                //Opcional
                System.out.println("chegou no finally!");
            }

        }while (continueLooping);


        System.out.println("Caso der tudo certo, o código continua...");
    }

    private static int dividir(int a, int b) {
        return a/ b;
    }
}
