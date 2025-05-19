/*
Trabalho de Programação Orientada a Objetos
Estudante: Henrique Rodrigues da Luz
RU: 4840748
*/

package cofrinho;

import java.util.ArrayList;
import java.util.Scanner;

// Classe principal que simboliza o Cofrinho
public class Cofrinho {
    private ArrayList<Moeda> moedas = new ArrayList<>(); // Coleção para armazenar as moedas adicionadas

    // Construtor vazio
    public Cofrinho() { 
    }

    // Método para inserir uma moeda no cofrinho
    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda); // Insere a moeda na coleção
    }

    // Método para excluir uma moeda do cofrinho
    public void removerMoeda(String tipo, double valor) {
        // Exclui uma moeda específica com base no tipo e valor
        moedas.removeIf(m -> m.informacoes().equalsIgnoreCase(tipo + " - " + valor));
    }

    // Método para exibir todas as moedas no cofrinho
    public void listarMoedas() {
        System.out.println("\nMoedas no cofrinho:");
        if (moedas.isEmpty()) {
            System.out.println("Nenhuma moeda foi adicionada.");
        } else {
            for (Moeda moeda : moedas) {
                System.out.println(moeda.informacoes());
            }
        }
    }

    // Método para calcular o total de todas as moedas convertidas para reais
    public double calcularTotalConvertido() {
        return moedas.stream().mapToDouble(Moeda::converter).sum();
    }

    // Método auxiliar para escolher o tipo de moeda
    private static String selecionarTipoMoeda(Scanner scanner) {
        System.out.print("\nEscolha o tipo de moeda:\n1. Real\n2. Dólar\n3. Euro\nDigite o número correspondente: ");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1: return "real";
            case 2: return "dólar";
            case 3: return "euro";
            default:
                System.out.println("Opção inválida.");
                return null;
        }
    }

    // Método auxiliar para capturar o valor da moeda
    private static double capturarValor(Scanner scanner) {
        System.out.print("\nInforme o valor: ");
        double valor = scanner.nextDouble();
        if (valor <= 0) {
            System.out.println("Digite um valor válido.");
            return -1;
        }
        return valor;
    }

    // Método principal que apresenta o menu e permite interagir com o cofrinho
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho(); // Instancia um novo cofrinho
        Scanner scanner = new Scanner(System.in); // Scanner para capturar a entrada do usuário

        while (true) { // Loop contínuo para manter o menu ativo até o usuário decidir sair
            // Apresenta o menu de opções
            System.out.print("\nCofrinho de moedas:\n1. Inserir moeda\n2. Excluir moeda\n3. Exibir moedas\n4. Calcular total convertido para Real\n5. Sair\nEscolha uma opção: ");
            int opcao = scanner.nextInt(); // Captura a opção escolhida pelo usuário

            switch (opcao) {
                case 1: // Inserir moeda
                    String tipoAdicionar = selecionarTipoMoeda(scanner); // Escolhe o tipo de moeda
                    if (tipoAdicionar == null) break;

                    double valorAdicionar = capturarValor(scanner); // Captura o valor da moeda
                    if (valorAdicionar <= 0) break;

                    switch (tipoAdicionar) {
                        case "real": cofrinho.adicionarMoeda(new Real(valorAdicionar)); break;
                        case "dólar": cofrinho.adicionarMoeda(new Dolar(valorAdicionar)); break;
                        case "euro": cofrinho.adicionarMoeda(new Euro(valorAdicionar)); break;
                    }
                    break;

                case 2: // Excluir moeda
                    String tipoRemover = selecionarTipoMoeda(scanner); // Escolhe o tipo de moeda para exclusão
                    if (tipoRemover == null) break;

                    double valorRemover = capturarValor(scanner); // Captura o valor da moeda a ser excluída
                    if (valorRemover <= 0) break;

                    cofrinho.removerMoeda(tipoRemover, valorRemover); // Remove a moeda do cofrinho
                    break;

                case 3: // Exibir moedas
                    cofrinho.listarMoedas(); // Mostra todas as moedas no cofrinho
                    break;

                case 4: // Calcular total convertido
                    // Mostra o total de todas as moedas convertidas para reais
                    System.out.println("\nTotal convertido para Real: R$ " + cofrinho.calcularTotalConvertido());
                    break;

                case 5: // Sair do programa
                    System.out.println("\nObrigado por utilizar nosso sistema :-)"); // Mensagem de despedida
                    scanner.close(); // Fecha o scanner
                    return; // Encerra o programa

                default: // Caso o usuário digite uma opção inválida
                    System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        }
    }
}