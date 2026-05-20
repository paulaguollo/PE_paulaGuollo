package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;
import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaFormatacao.*;

/**
 * Biblioteca de funções administrativas do festival CodeFest.
 * Contém métodos para validação de login, consulta de ficheiros,
 * análise de bilhetes, pesquisa de festivaleiros e relatórios de receitas.
 */
public class BibliotecaADM {

    /**
     * Valida as credenciais de login do administrador comparando com os dados
     * carregados do ficheiro Festival_AdminLogin.csv.
     *
     * @param usernameInput  Username introduzido pelo utilizador
     * @param passwordInput  Password introduzida pelo utilizador
     * @param matrizAdmin    Matriz com as credenciais válidas (username;password)
     * @return true se as credenciais forem válidas, false caso contrário
     * @throws FileNotFoundException Caso o ficheiro de admin não exista
     */
    public static boolean validarLogin(String usernameInput, String passwordInput, String[][] matrizAdmin) throws FileNotFoundException {

        // Percorre todas as linhas da matriz de credenciais
        for (int i = 0; i < matrizAdmin.length; i++) {

            // Garante que a linha tem pelo menos username e password
            if (matrizAdmin[i].length >= 2) {

                // Compara directamente username e password com os valores do ficheiro
                if (usernameInput.equals(matrizAdmin[i][0]) && passwordInput.equals(matrizAdmin[i][1])) {

                    String usernameMatriz = matrizAdmin[i][0];
                    String passwordMatriz = matrizAdmin[i][1];


                    if (usernameInput.equals(usernameMatriz) && passwordInput.equals(passwordMatriz)) {
                        return true; // Credenciais válidas
                    }
                }
            }
        }
        return false;
    }

    /**
     * Apresenta um submenu que permite ao admin escolher e visualizar
     * o conteúdo de um dos ficheiros CSV do sistema.
     *
     * @throws FileNotFoundException Caso algum dos ficheiros CSV não exista
     */
    public static void menuConsultaFicheiro() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        String opcao;
        do {
            System.out.println("\nEscolha o Ficheiro que quer consultar\n");
            System.out.println("1. Bilhetes");
            System.out.println("2. Cartaz");
            System.out.println("3. Login do Admin");
            System.out.println("4. Quiz");
            System.out.println("0. Sair");

            System.out.print("\nEscolha a Opção: ");
            opcao = input.next();

            System.out.println();

            switch (opcao) {
                case "1":
                    // Imprime o ficheiro de bilhetes com cabeçalho (false = não salta cabeçalho)
                    System.out.println("\n---------------------Ficheiro dos Bilhetes---------------------\n");
                    String[][] matrizBilhete = lerFicheiroParaMatriz("CodeFest/data/Festival_Bilhetes.csv", ";", false); //tem cabeçalho mas eu quero imprimir ele então coloquei false
                    for (int i = 0; i < matrizBilhete.length; i++) {
                        System.out.println(matrizBilhete[i][0] + " | " + matrizBilhete[i][1]+ " | " + matrizBilhete[i][2]+ " | " + matrizBilhete[i][3]+ " | " + matrizBilhete[i][4]+ " | " + matrizBilhete[i][5]+ " | " + matrizBilhete[i][6]+ " | " + matrizBilhete[i][7]);
                    }
                    break;

                case "2":
                    System.out.println("\n---------------------Ficheiro do Cartaz---------------------\n");
                    String[][] matrizCartaz = lerFicheiroParaMatriz("CodeFest/data/Festival_Cartaz.csv", ";", false);
                    for (int i = 0; i < matrizCartaz.length; i++) {
                        System.out.println(matrizCartaz[i][0] + " | " + matrizCartaz[i][1]+ " | " + matrizCartaz[i][2]+ " | " + matrizCartaz[i][3]+ " | " + matrizCartaz[i][4]+ " | " + matrizCartaz[i][5]+ " | " + matrizCartaz[i][6]);
                    }
                    break;

                case "3":
                    System.out.println("\n---------------------Ficheiro de Login do Admin---------------------\n");
                    String[][] matrizLoginAdmin = lerFicheiroParaMatriz("CodeFest/data/Festival_AdminLogin.csv", ";", false);
                    for (int i = 0; i < matrizLoginAdmin.length; i++) {
                        System.out.println(matrizLoginAdmin[i][0] + " | " + matrizLoginAdmin[i][1]);
                    }
                    break;

                case "4":
                    System.out.println("\n---------------------Ficheiro do Quiz---------------------\n");
                    String[][] matrizQuiz = lerFicheiroParaMatriz("CodeFest/data/Festival_Quiz.csv", ";", false);
                    for (int i = 0; i < matrizQuiz.length; i++) {
                        System.out.println(matrizQuiz[i][0] + " | " + matrizQuiz[i][1] + " | " + matrizQuiz[i][2] + " | " + matrizQuiz[i][3] + " | " + matrizQuiz[i][4] + " | " + matrizQuiz[i][5]);
                    }
                    break;


                case "0":
                    // Ao sair do submenu, mostra copyright e aguarda Enter
                    copyright();
                    primaEnter();
                    break;

                default:
                    System.out.println("Opção Inválida: " + opcao);
                    break;
            }

        } while (!opcao.equals("0"));
    }

    /**
     * Calcula e imprime o número total de bilhetes vendidos e o valor total faturado pelo festival.
     * Percorre toda a matriz de bilhetes e soma os valores da coluna 7 (valor).
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (sem cabeçalho)
     */
    public static void totalBilhetesVendidos(String[][] matrizBilhetes) throws FileNotFoundException {

        double valorTotal = 0;

            // Acumula o valor de cada bilhete (coluna 7)
            for (int i = 0; i < matrizBilhetes.length; i++) {
                valorTotal += Double.parseDouble(matrizBilhetes[i][7]);
            }
            System.out.println("A quantidade de bilhetes vendidos é: " + matrizBilhetes.length);
            System.out.println("O Valor total faturado com os bilhetes é: " + valorTotal);
    }

    /**
     * Pesquisa um festivaleiro pelo seu ID de cliente e imprime todos os bilhetes
     * associados, bem como o total gasto.
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (sem cabeçalho)
     * @param idCliente      ID do cliente a pesquisar (coluna 1)
     */
    public static void pesquisaFestivaleiro(String[][] matrizBilhetes, String idCliente) {
        boolean encontrou = false;
        double totalGasto = 0;

        for (int i = 1; i < matrizBilhetes.length; i++) { // começa em 1 para saltar o cabeçalho

            // Compara o idCliente (coluna 1) com o valor pesquisado
            if ((matrizBilhetes[i][1]).equals(idCliente)) {

                if (!encontrou) { // Imprime o cabeçalho apenas na primeira ocorrência
                    System.out.println("\n***** FESTIVALEIRO ENCONTRADO *****");
                    System.out.println("Nome: "      + matrizBilhetes[i][2]);
                    System.out.println("Contacto: "  + matrizBilhetes[i][3]);
                    System.out.println("Email: "     + matrizBilhetes[i][4]);
                    System.out.println("\nBilhetes adquiridos:");
                    encontrou = true;
                }
                // Adiciona o valor deste bilhete ao total gasto
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
     * Encontra e imprime o(s) bilhete(s) com o maior valor registado no ficheiro.
     * Caso haja empate no valor máximo, todos os bilhetes empatados são apresentados.
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (sem cabeçalho)
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

    // imprime todos os bilhetes com esse valor máximo
    System.out.println("\n***** BILHETE MAIS CARO *****");
    for (int i = 0; i < matrizBilhetes.length; i++) {
        double valor = Double.parseDouble(matrizBilhetes[i][7]);
        if (valor == maiorValor) {
            System.out.println(matrizBilhetes[i][5] + " | " + matrizBilhetes[i][6] + " | " + valor + " €");
        }
    }

}

    /**
     * Identifica e imprime o(s) festivaleiro(s) que mais dinheiro gastaram no festival.
     * Se houver empate no total gasto, todos os festivaleiros empatados são apresentados.
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (sem cabeçalho)
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

        // Controla quais os clientes já foram impressos (evita repetição)
        boolean[] jaImprimiu = new boolean[matrizBilhetes.length];

        //Imprime os clientes cujo total corresponde ao máximo
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

                    // Lista todos os bilhetes deste cliente e marca-os como já impressos
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
     * Imprime todos os bilhetes vendidos para um determinado dia do festival.
     * A comparação é feita de forma insensível a maiúsculas/minúsculas.
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (sem cabeçalho)
     * @param dia            Dia a pesquisar (ex: "Sexta", "Sábado", "Domingo")
     */
    public static void pesquisaBilhetesPorDia(String[][] matrizBilhetes, String dia) {
        boolean encontrou = false;

        System.out.println("\n***** BILHETES PARA " + dia.toUpperCase() + " *****");

        // Percorre todos os bilhetes e filtra pelo dia (coluna 5)
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
     * Calcula e imprime a quantidade de bilhetes vendidos e o total faturado
     * para um tipo de bilhete específico.
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (sem cabeçalho)
     * @param tipoBilhete    Tipo de bilhete a filtrar (ex: "Diário", "VIP", "Backstage")
     */
    public static void receitaPorTipoBilhete(String[][] matrizBilhetes, String tipoBilhete) {
        int quantidade = 0;
        double total = 0;

        // Percorre os bilhetes e acumula os do tipo indicado (coluna 6)
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
     * Calcula e imprime a receita total obtida em cada dia do festival
     * (Sexta, Sábado e Domingo), incluindo a quantidade de bilhetes vendidos por dia.
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (sem cabeçalho)
     */
    public static void receitaPorDia(String[][] matrizBilhetes) {
        String[] dias = {"Sexta", "Sábado", "Domingo"};

        System.out.println("\n***** RECEITA POR DIA *****");

        for (int i = 0; i < dias.length; i++) {
            int quantidade = 0;
            double total = 0;

            // Filtra os bilhetes do dia atual e acumula quantidade e valor
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



