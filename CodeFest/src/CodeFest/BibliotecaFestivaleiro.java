package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFormatacao.*;

/**
 * Biblioteca de funções para o menu do Festivaleiro do CodeFest.
 * Contém métodos para pesquisa no cartaz, quiz musical, registo de festivaleiros,
 * lugares de campismo e apresentação de palcos gráficos.
 */
public class BibliotecaFestivaleiro {

    /**
     * Pesquisa e imprime todos os concertos de um determinado género musical.
     * Caso não existam concertos desse género, informa o utilizador.
     *
     * @param matrizCartaz    Matriz com os dados do cartaz (sem cabeçalho)
     * @param generoPesquisar Género musical a pesquisar (ex: "Rock", "Pop")
     */
    public static void pesquisarPorGenero(String[][] matrizCartaz, String generoPesquisar) {
        boolean encontrou = false;

        System.out.println("\n***** CONCERTOS DE " + generoPesquisar.toUpperCase() + " *****");

        // Percorre o cartaz e filtra pela coluna 5 (género)
        for (int linha = 0; linha < matrizCartaz.length; linha++) {
            if (matrizCartaz[linha][5].equalsIgnoreCase(generoPesquisar)) {
                // [4]=artista, [1]=dia, [2]=hora, [3]=palco, [6]=duracao
                System.out.println(matrizCartaz[linha][4] + " | " + matrizCartaz[linha][1] + " | " + matrizCartaz[linha][2] + " | " + matrizCartaz[linha][3] + " | " + matrizCartaz[linha][6] + " min");
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum concerto encontrado do género: " + generoPesquisar);
        }
    }

    /**
     * Apresenta um submenu com os palcos disponíveis e imprime na consola
     * o conteúdo do ficheiro .txt correspondente ao palco escolhido.
     *
     * @throws FileNotFoundException Caso algum dos ficheiros de palco não exista
     */
    public static void menuImprimePalco() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        String opcao;
        do {
            System.out.println("\n-------------------------------");
            System.out.println("----- Qual palco queres ver?-----\n");
            System.out.println("1. Palco Main :)");
            System.out.println("2. Palco Java <3");
            System.out.println("3. Palco Commit o/");
            System.out.println("0. Nenhum destes. Quero Sair");

            System.out.print("Escolha a Opção: ");
            opcao = input.next();

            System.out.println();

            switch (opcao) {
                case "1":
                    // Imprime o conteúdo gráfico ASCII do Palco Main
                    imprimirFicheiroNaConsola("CodeFest/data/Palco_Main.txt");
                    break;
                case "2":
                    // Imprime o conteúdo gráfico ASCII do Palco Java
                    imprimirFicheiroNaConsola("CodeFest/data/Palco_Java.txt");
                    break;
                case "3":
                    // Imprime o conteúdo gráfico ASCII do Palco Commit
                    imprimirFicheiroNaConsola("CodeFest/data/Palco_Commit.txt");
                    break;
                case "0":
                    // Ao sair, mostra o copyright do festival
                    copyright();
                    primaEnter();
                    break;
                default:
                    System.out.println("Opção Inválida: " + opcao + " Tenta um dos nossos 3 palcos");
                    break;
            }

        } while (!opcao.equals("0"));
    }

    /**
     * Pesquisa e imprime todos os concertos de um determinado dia do festival.
     * A comparação é feita de forma insensível a maiúsculas/minúsculas.
     *
     * @param matrizCartaz Matriz com os dados do cartaz (sem cabeçalho)
     * @param dia          Dia a pesquisar (ex: "Sexta", "Sábado", "Domingo")
     */
    public static void pesquisaPorDia(String[][] matrizCartaz, String dia) {
        boolean encontrou = false;

        System.out.println("\n***** CONCERTOS NO DIA DE " + dia.toUpperCase() + " *****");

        // Percorre o cartaz e filtra pela coluna 1 (dia)
        for (int linha = 0; linha < matrizCartaz.length; linha++) {
            if (matrizCartaz[linha][1].equalsIgnoreCase(dia)) {
                // [2]=hora, [3]=palco, [4]=artista, [5]=genero, [6]=duracao
                System.out.println(matrizCartaz[linha][2] + " | " + matrizCartaz[linha][3] + " | " + matrizCartaz[linha][4] + " | " + matrizCartaz[linha][5] + " | " + matrizCartaz[linha][6] + " min");
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum concerto encontrado para o dia de " + dia);
        }

    }

    /**
     * Encontra e imprime o(s) concerto(s) com maior duração no cartaz do festival.
     * Caso haja empate, todos os concertos com a mesma duração máxima são apresentados.
     *
     * @param matrizCartaz Matriz com os dados do cartaz (sem cabeçalho)
     */
    public static void concertoMaisLongo(String[][] matrizCartaz) {

        int maxDuracao = 0;
        // Encontra a duração máxima (coluna 6)
        for (int linha = 0; linha < matrizCartaz.length; linha++) {
            int duracao = Integer.parseInt(matrizCartaz[linha][6]);
            if (duracao > maxDuracao) {
                maxDuracao = duracao;
            }
        }

        //Imprime todos os concertos com essa duração máxima
        System.out.println("\n*****CONCERTO MAIS LONGO*****");
        for (int linha = 0; linha < matrizCartaz.length; linha++) {
            int duracao = Integer.parseInt(matrizCartaz[linha][6]);
            if (duracao == maxDuracao) {
                // [4]=artista, [1]=dia, [2]=hora, [3]=palco, [5]=genero, [6]=duracao
                System.out.println(matrizCartaz[linha][4] + " | " + matrizCartaz[linha][1] + " | " + matrizCartaz[linha][2] + " | " + matrizCartaz[linha][3] + " | " + matrizCartaz[linha][5] + " | " + matrizCartaz[linha][6] + " min");
            }
        }
    }

    /**
     * Imprime todos os artistas presentes no cartaz do festival, sem duplicados.
     * Um artista é considerado duplicado se o seu nome (coluna 4) já tiver aparecido antes.
     *
     * @param matrizCartaz Matriz com os dados do cartaz (sem cabeçalho)
     */
    public static void imprimirCartazArtistas(String[][] matrizCartaz) {
        System.out.println("\n***** CARTAZ DO FESTIVAL *****");

        for (int linha = 0; linha < matrizCartaz.length; linha++) {
            boolean duplicado = false;
            // Verifica se este artista já apareceu em linhas anteriores
            for (int j = 0; j < linha; j++) {
                if (matrizCartaz[j][4].equalsIgnoreCase(matrizCartaz[linha][4])) {
                    duplicado = true;
                    break;
                }
            }

            if (!duplicado) {
                //Só imprime se não for duplicado (coluna 4 = artista)
                System.out.println(matrizCartaz[linha][4]);
            }
        }
        System.out.println();
    }

    /**
     * Simula o registo de um novo festivaleiro.
     * Gera automaticamente um novo ID de cliente com base no maior ID existente.
     * Nota: este método é auxiliar — a confirmação e impressão são feitas no menu.
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (para calcular o novo ID)
     * @param nome           Nome do novo festivaleiro
     * @param contacto       Contacto telefónico do novo festivaleiro
     * @param email          Email do novo festivaleiro
     */
    public static void novoRegisto(String[][] matrizBilhetes, String nome, String contacto, String email) {

        // Encontra o maior idCliente existente para gerar o novo id
        int maiorId = 0;
        for (int linha = 0; linha < matrizBilhetes.length; linha++) {
            int idAtual = Integer.parseInt(matrizBilhetes[linha][1]);
            if (idAtual > maiorId) {
                maiorId = idAtual;
            }
        }
        // O novo ID seria maiorId + 1 (registo apenas simulado em memória)
        int novoId = maiorId + 1;
    }

    /**
     * Implementa um quiz musical interativo com base no ficheiro Festival_Quiz.csv.
     * Para cada pergunta, apresenta as quatro opções e valida a resposta do utilizador.
     * No final, apresenta a pontuação obtida.
     *
     * @param matrizQuiz Matriz com as perguntas e respostas do quiz (sem cabeçalho)
     *                   Colunas: pergunta | opcao1 | opcao2 | opcao3 | opcao4 | resposta_correta
     * @param input      Scanner partilhado para leitura de input do utilizador
     */
    public static void quizMusical(String[][] matrizQuiz, Scanner input) {
        System.out.println("\n***** QUIZ MUSICAL *****");
        int corretas = 0;

        for (int linha = 0; linha < matrizQuiz.length; linha++) {
            System.out.println("\nPergunta " + (linha + 1) + ":");
            System.out.println(matrizQuiz[linha][0]); //pergunta
            System.out.println("1. " + matrizQuiz[linha][1]); //opção 1
            System.out.println("2. " + matrizQuiz[linha][2]); //opção 2
            System.out.println("3. " + matrizQuiz[linha][3]); //opção 3
            System.out.println("4. " + matrizQuiz[linha][4]); //opção 4

            System.out.print("Digite a sua Resposta? ");
            String resposta = input.nextLine();

            // Compara a resposta do utilizador com a resposta correta (coluna 5)
            if (resposta.equals(matrizQuiz[linha][5])) {
                System.out.println("Resposta correta!");
                corretas++;
            } else {
                System.out.println("Resposta errada! A resposta correta era: " + matrizQuiz[linha][5]);
            }
        }

        // Apresenta a pontuação final
        System.out.println("\nQuiz Terminado\n");
        System.out.println("Respostas Corretas: " + corretas + "/" + matrizQuiz.length); //pontuação
    }

    /**
     * Calcula e imprime os lugares de campismo disponíveis no festival.
     * Os lugares disponíveis são os números triangulares múltiplos de 5 entre 1 e 300.
     *
     * Um número triangular T(n) = 1 + 2 + 3 + ... + n = n*(n+1)/2
     * Exemplos: 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
     * Apenas são apresentados os que são múltiplos de 5 e não ultrapassam 300.
     */
    public static void lugaresCampismo() {
        System.out.println("\n***** LUGARES DE CAMPISMO DISPONÍVEIS *****");

        int triangular = 0;
        int n = 1;

        while (triangular <= 300) {
            triangular = triangular + n; // Soma os naturais consecutivos
            n++;

            if (triangular <= 300 && triangular % 5 == 0) { // A considerar que precisa ser multiplo de 5
                System.out.println("Lugar: " + triangular);
            }
        }
        System.out.println();
    }


}

