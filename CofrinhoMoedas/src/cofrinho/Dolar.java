/*
Trabalho de Programação Orientada a Objetos
Aluno: Henrique Rodrigues da Luz
RU: 4840748
*/

package cofrinho;

// Classe para representar o Dólar (moeda americana)
public class Dolar extends Moeda {
    // Taxa de conversão do Dólar para Reais (valor fictício para o exemplo)
    private static final double TAXA_CONVERSAO = 5.8;

    // Construtor da classe Dólar
    public Dolar(double valor) {
        super(valor); // Chama o construtor da classe mãe (Moeda) para inicializar o valor
    }

    // Método para converter o valor do Dólar para Reais
    @Override
    public double converter() {
        return valor * TAXA_CONVERSAO; // Multiplica o valor do Dólar pela taxa de conversão
    }

    // Método para retornar as informações do Dólar
    @Override
    public String informacoes() {
        return "Dólar - " + valor; // Retorna uma string formatada com o tipo de moeda e seu valor
    }
}