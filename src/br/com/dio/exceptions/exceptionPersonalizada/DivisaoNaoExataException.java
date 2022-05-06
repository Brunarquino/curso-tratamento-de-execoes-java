package br.com.dio.exceptions.exceptionPersonalizada;

public class DivisaoNaoExataException extends Exception{
    private int numerador;
    private int Denominador;

    public DivisaoNaoExataException(String message, int numerador, int denominador) {
        super(message);
        this.numerador = numerador;
        this.Denominador = denominador;
    }

    public DivisaoNaoExataException(int numerador, int denominador) {
        this.numerador = numerador;
        Denominador = denominador;
    }

    @Override
    public String toString() {
        return "DivisaoNaoExataException{" +
                "numerador=" + numerador +
                ", Denominador=" + Denominador +
                '}';
    }
}
