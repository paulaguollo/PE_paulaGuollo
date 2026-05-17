package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaFormatacao.*;

public class BibliotecaADM {

    /**
     * Função para validar Login
     *
     * @param usernameInput - username
     * @param passwordInput - senha
     * @return Validação para seguir para o Menu de escolhas
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static boolean validarLogin(String usernameInput, String passwordInput, String[][] matrizAdmin) throws FileNotFoundException {


        for (int i = 0; i < matrizAdmin.length; i++) {

            if (matrizAdmin[i].length >= 2) {

                if (usernameInput.equals(matrizAdmin[i][0]) && passwordInput.equals(matrizAdmin[i][1])) {

                    String usernameMatriz = matrizAdmin[i][0];
                    String passwordMatriz = matrizAdmin[i][1];


                    if (usernameInput.equals(usernameMatriz) && passwordInput.equals(passwordMatriz)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Função com o menu para escolha de ficheiros
     * @throws FileNotFoundException
     */
    public static void menuConsultaFicheiro() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n------------------------------------------------");
            System.out.println("----- Escolha o Ficheiro que quer consultar -----");
            System.out.println("1. Bilhetes");
            System.out.println("2. Cartaz");
            System.out.println("3. Login do Admin");
            System.out.println("4. Quiz");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println("\n------------------------------------------------");

            switch (opcao) {
                case 1:
                    System.out.println("------Ficheiro dos Bilhetes------");
                    String[][] matrizBilhete = lerFicheiroParaMatriz("CodeFest/data/Festival_Bilhetes.csv", ";", false); //tem cabeçalho mas eu quero imprimir ele então coloquei false
                    for (int i = 0; i < matrizBilhete.length; i++) {
                        System.out.println(matrizBilhete[i][0] + " | " + matrizBilhete[i][1]+ " | " + matrizBilhete[i][2]+ " | " + matrizBilhete[i][3]+ " | " + matrizBilhete[i][4]+ " | " + matrizBilhete[i][5]+ " | " + matrizBilhete[i][6]+ " | " + matrizBilhete[i][7]);
                    }
                    break;

                case 2:
                    System.out.println("------Ficheiro do Cartaz------");
                    String[][] matrizCartaz = lerFicheiroParaMatriz("CodeFest/data/Festival_Cartaz.csv", ";", false);
                    for (int i = 0; i < matrizCartaz.length; i++) {
                        System.out.println(matrizCartaz[i][0] + " | " + matrizCartaz[i][1]+ " | " + matrizCartaz[i][2]+ " | " + matrizCartaz[i][3]+ " | " + matrizCartaz[i][4]+ " | " + matrizCartaz[i][5]+ " | " + matrizCartaz[i][6]);
                    }
                    break;

                case 3:
                    System.out.println("------Ficheiro de Login do Admin------");
                    String[][] matrizLoginAdmin = lerFicheiroParaMatriz("CodeFest/data/Festival_AdminLogin.csv", ";", false);
                    for (int i = 0; i < matrizLoginAdmin.length; i++) {
                        System.out.println(matrizLoginAdmin[i][0] + " | " + matrizLoginAdmin[i][1]);
                    }
                    break;

                case 4:
                    System.out.println("------Ficheiro do Quiz------");
                    String[][] matrizQuiz = lerFicheiroParaMatriz("CodeFest/data/Festival_Quiz.csv", ";", false);
                    for (int i = 0; i < matrizQuiz.length; i++) {
                        System.out.println(matrizQuiz[i][0] + " | " + matrizQuiz[i][1] + " | " + matrizQuiz[i][2] + " | " + matrizQuiz[i][3] + " | " + matrizQuiz[i][4] + " | " + matrizQuiz[i][5]);
                    }
                    break;


                case 0:
                    copyright();
                    primaEnter();
                    break;

                default:
                    System.out.println("Opção Inválida: " + opcao);
                    break;
            }

        } while (opcao != 0);
    }

    /**
     * Função para saber a quantidade total de bilhetes vendidos e o valor faturado
     * @param matrizBilhetes
     * @throws FileNotFoundException
     */
    public static void totalBilhetesVendidos(String[][] matrizBilhetes) throws FileNotFoundException {

        double valorTotal = 0;

            for (int i = 0; i < matrizBilhetes.length; i++) {
                valorTotal += Double.parseDouble(matrizBilhetes[i][7]);
            }
            System.out.println("A quantidade de bilhetes vendidos é: " + matrizBilhetes.length);
            System.out.println("O Valor total faturado com os bilhetes é: " + valorTotal);
    }

    /**
     * Função para mostrar os dados de um festivaleiro a escolha
     * @param matrizBilhetes
     * @param idCliente
     */
    public static void pesquisaFestivaleiro(String[][] matrizBilhetes, int idCliente) {
        boolean encontrou = false;
        double totalGasto = 0;

        for (int i = 1; i < matrizBilhetes.length; i++) { // começa em 1 para saltar o cabeçalho
            if (Integer.parseInt(matrizBilhetes[i][1]) == idCliente) {
                if (!encontrou) {
                    System.out.println("\n***** FESTIVALEIRO ENCONTRADO *****");
                    System.out.println("Nome: "      + matrizBilhetes[i][2]);
                    System.out.println("Contacto: "  + matrizBilhetes[i][3]);
                    System.out.println("Email: "     + matrizBilhetes[i][4]);
                    System.out.println("\nBilhetes adquiridos:");
                    encontrou = true;
                }

                double valor = Double.parseDouble(matrizBilhetes[i][7]);
                totalGasto += valor;
                System.out.println(matrizBilhetes[i][0] + " | " + matrizBilhetes[i][5] + " | " + matrizBilhetes[i][6] + " | " + valor + " €");
            }
        }
        if (encontrou) {
            System.out.println("\nTotal gasto: " + totalGasto + " €");
        } else {
            System.out.println("Festivaleiro não encontrado.");
        }
    }

    /**
     * Função para imprimir os bilhetes mais caros
     * @param matrizBilhetes
     */
    public static void bilheteMaiscaro(String[][] matrizBilhetes) {
    double maiorValor = 0;

    // encontrar o maior valor
    for (int i = 0; i < matrizBilhetes.length; i++) {
        double valor = Double.parseDouble(matrizBilhetes[i][7]);
        if (valor > maiorValor) {
            maiorValor = valor;
        }
    }

    System.out.println("\n***** BILHETE MAIS CARO *****");
    for (int i = 0; i < matrizBilhetes.length; i++) {
        double valor = Double.parseDouble(matrizBilhetes[i][7]);
        if (valor == maiorValor) {
            System.out.println(matrizBilhetes[i][5] + " | " + matrizBilhetes[i][6] + " | " + valor + " €");
        }
    }

}

    /**
     * Função para mostrar o festivaleiro que mais gastou e os bilhetes adquiridos
     * @param matrizBilhetes
     */
    public static void melhoresFestivaleiros(String[][] matrizBilhetes) {
        double maiorTotal = 0;

        // encontrar o maior total gasto
        for (int i = 0; i < matrizBilhetes.length; i++) {
            double totalAtual = 0;
            int idAtual = Integer.parseInt(matrizBilhetes[i][1]);

            // Somar os bilhetes deste cliente
            for (int j = 0; j < matrizBilhetes.length; j++) {
                if (Integer.parseInt(matrizBilhetes[j][1]) == idAtual) {
                    totalAtual += Double.parseDouble(matrizBilhetes[j][7]);
                }
            }

            if (totalAtual > maiorTotal) {
                maiorTotal = totalAtual;
            }
        }

        System.out.println("\n***** MELHORES FESTIVALEIROS *****");
        boolean[] jaImprimiu = new boolean[matrizBilhetes.length];

        for (int i = 0; i < matrizBilhetes.length; i++) {
            if (!jaImprimiu[i]) {
                int idAtual = Integer.parseInt(matrizBilhetes[i][1]);
                double totalAtual = 0;

                for (int j = 0; j < matrizBilhetes.length; j++) {
                    if (Integer.parseInt(matrizBilhetes[j][1]) == idAtual) {
                        totalAtual += Double.parseDouble(matrizBilhetes[j][7]);
                    }
                }

                if (totalAtual == maiorTotal) {
                    System.out.println("Nome: "        + matrizBilhetes[i][2]);
                    System.out.println("Contacto: "    + matrizBilhetes[i][3]);
                    System.out.println("Email: "       + matrizBilhetes[i][4]);
                    System.out.println("Total gasto: " + totalAtual + " €");
                    System.out.println("Bilhetes:");

                    for (int j = 0; j < matrizBilhetes.length; j++) {
                        if (Integer.parseInt(matrizBilhetes[j][1]) == idAtual) {
                            System.out.println("- " + matrizBilhetes[j][0] + " | " + matrizBilhetes[j][5] + " | " + matrizBilhetes[j][6] + " | " + matrizBilhetes[j][7] + " €");
                            jaImprimiu[j] = true;
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     *Imprimir todos os bilhetes vendidos no dia a escolha
     * @param matrizBilhetes
     * @param dia
     */
    public static void pesquisaBilhetesPorDia(String[][] matrizBilhetes, String dia) {
        boolean encontrou = false;

        System.out.println("\n***** BILHETES PARA " + dia.toUpperCase() + " *****");

        for (int i = 0; i < matrizBilhetes.length; i++) {
            if (matrizBilhetes[i][5].equalsIgnoreCase(dia)) {
                System.out.println(matrizBilhetes[i][0] + " | " + matrizBilhetes[i][2] + " | " + matrizBilhetes[i][3] + " | " + matrizBilhetes[i][4] + " | " + matrizBilhetes[i][6] + " | " + matrizBilhetes[i][7] + " €");
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum bilhete encontrado para esse dia.");
        }
    }

    /**
     * Função para saber o faturamento por tipo de bilhete
     * @param matrizBilhetes
     * @param tipoBilhete
     */
    public static void receitaPorTipoBilhete(String[][] matrizBilhetes, String tipoBilhete) {
        int quantidade = 0;
        double total = 0;

        for (int i = 0; i < matrizBilhetes.length; i++) {
            if (matrizBilhetes[i][6].equalsIgnoreCase(tipoBilhete)) {
                quantidade++;
                total += Double.parseDouble(matrizBilhetes[i][7]);
            }
        }

        if (quantidade > 0) {
            System.out.println("\n***** RECEITA POR TIPO DE BILHETE *****");
            System.out.println("Tipo: " + tipoBilhete);
            System.out.println("Quantidade vendida: " + quantidade);
            System.out.println("Total faturado: " + total + " €");
        } else {
            System.out.println("Tipo de bilhete não encontrado.");
        }
    }

    /**
     * Função para o faturamento por dia do festival
     * @param matrizBilhetes
     */
    public static void receitaPorDia(String[][] matrizBilhetes) {
        String[] dias = {"Sexta", "Sábado", "Domingo"};

        System.out.println("\n***** RECEITA POR DIA *****");

        for (int i = 0; i < dias.length; i++) {
            int quantidade = 0;
            double total = 0;

            for (int j = 0; j < matrizBilhetes.length; j++) {
                if (matrizBilhetes[j][5].equalsIgnoreCase(dias[i])) {
                    quantidade++;
                    total += Double.parseDouble(matrizBilhetes[j][7]);
                }
            }

            System.out.println(dias[i] + " | " + quantidade + " bilhetes | " + total + " €");
        }
    }
}



