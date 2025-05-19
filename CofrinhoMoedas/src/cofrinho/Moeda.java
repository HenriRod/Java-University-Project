/*
Trabalho de Programação Orientada a Objetos
Aluno: Henrique Rodrigues da Luz
RU: 4840748
*/

package cofrinho;

// Classe abstrata para representar moedas genéricas
public abstract class Moeda {
    protected double valor; // Valor da moeda

    // Construtor que valida se o valor não é zero ou negativo
    public Moeda(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da moeda não pode ser zero ou negativo.");
        }
        this.valor = valor;
    }

    // Método abstrato para conversão do valor da moeda
    public abstract double converter();

    // Método abstrato para retornar as informações da moeda
    public abstract String informacoes();
}