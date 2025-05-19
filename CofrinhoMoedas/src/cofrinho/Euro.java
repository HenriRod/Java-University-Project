/*
Trabalho de Programação Orientada a Objetos
Aluno: Henrique Rodrigues da Luz
RU: 4840748
*/

package cofrinho;

// Classe para representar o Euro (moeda europeia)
public class Euro extends Moeda {
    // Taxa de conversão do Euro para Reais (valor fictício para o exemplo)
    private static final double TAXA_CONVERSAO = 6.2;

    // Construtor da classe Euro
    public Euro(double valor) {
        super(valor); // Chama o construtor da classe mãe (Moeda) para inicializar o valor
    }

    // Método para converter o valor do Euro para Reais
    @Override
    public double converter() {
        return valor * TAXA_CONVERSAO; // Multiplica o valor do Euro pela taxa de conversão
    }

    // Método para retornar as informações do Euro
    @Override
    public String informacoes() {
        return "Euro - " + valor; // Retorna uma string formatada com o tipo de moeda e seu valor
    }
}