/*
Trabalho de Programação Orientada a Objetos
Aluno: Henrique Rodrigues da Luz
RU: 4840748
*/

package cofrinho;

// Classe para representar o Real (moeda brasileira)
public class Real extends Moeda {
    public Real(double valor) {
        super(valor); // Usa o construtor da classe mãe
    }

    @Override
    public double converter() {
        return valor; // foi pedido no enunciado que o valor do Real não deve ser convertido
    }

    @Override
    public String informacoes() {
        return "Real - " + valor; // Informação formatada para o Real
    }
}