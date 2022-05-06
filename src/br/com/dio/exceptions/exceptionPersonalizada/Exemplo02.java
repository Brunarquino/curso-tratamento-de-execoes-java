package br.com.dio.exceptions.exceptionPersonalizada;

import javax.swing.*;

public class Exemplo02 {
    public static void main(String[] args) {
        int[] numerador = {4, 5, 8, 10}; //Por ultimo vai extourar um exeption porque vou tentar dividir por um número inexistente ou tentar dividir o número por zero
        int[] denominador = {1, 4, 0, 2, 8};

        for (int i = 0;i < denominador.length;i++) {

            try {
                if(numerador[i] % 2 != 0)
                    throw new DivisaoNaoExataException("Divisão não Exata", numerador[i], denominador[i]);

                int resultado = numerador[i] / denominador[i];
                System.out.println(resultado);

            }catch (ArithmeticException e){
                //Caso o usuario tente divir por 0
                JOptionPane.showMessageDialog(null, "Impossivel dividir um número por zero por 0! ");
            }catch (ArrayIndexOutOfBoundsException e){
                //Caso o usuario tente divir por um número inexistente
                JOptionPane.showMessageDialog(null, "Não existe um numerador para dividir ");
            }catch (DivisaoNaoExataException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,  e.getMessage());
            }



//            try {
//                if(numerador[i] % 2 != 0)
//                    throw new DivisaoNaoExataException("Divisão não Exata", numerador[i], denominador[i]);
//                try {
//                    int resultado = numerador[i] / denominador[i];
//                    System.out.println(resultado);
//
//                }catch (ArithmeticException e){
//                    //Caso o usuario tente divir por 0
//                    JOptionPane.showMessageDialog(null, "Impossivel dividir um número por zero por 0! ");
//                }catch (ArrayIndexOutOfBoundsException e){
//                    //Caso o usuario tente divir por um número inexistente
//                    JOptionPane.showMessageDialog(null, "Não existe um numerador para dividir ");
//                }
//            } catch (DivisaoNaoExataException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null,  e.getMessage());
//            }
        }

        System.out.println("Programa Continua...");
    }
}
