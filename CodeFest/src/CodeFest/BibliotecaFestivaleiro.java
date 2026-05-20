package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFormatacao.*;

public class BibliotecaFestivaleiro {

    /**
     * Função que mostra detalhes do festival por genero musical
     *
     * @param matrizCartaz
     * @param generoPesquisar
     */
    public static void pesquisarPorGenero(String[][] matrizCartaz, String generoPesquisar) {
        boolean encontrou = false;

        System.out.println("\n***** CONCERTOS DE " + generoPesquisar.toUpperCase() + " *****");
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
     * Função para imprimir na consola o ficheiro txt com os palcos do evento
     *
     * @throws FileNotFoundException
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
                    imprimirFicheiroNaConsola("CodeFest/data/Palco_Main.txt");
                    break;
                case "2":
                    imprimirFicheiroNaConsola("CodeFest/data/Palco_Java.txt");
                    break;
                case "3":
                    imprimirFicheiroNaConsola("CodeFest/data/Palco_Main.txt");
                    break;
                case "0":
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
     * Função para ver mais informações do festival filtrando pelo dia
     * @param matrizCartaz
     * @param dia
     */
    public static void pesquisaPorDia(String[][] matrizCartaz, String dia) {
        boolean encontrou = false;

        System.out.println("\n***** CONCERTOS No DIA DE " + dia.toUpperCase() + " *****");
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
     * Função para ter as informações do concerto mais longo. Pode aparecer mais de um se tiverem a mesma duração
     * @param matrizCartaz
     */
    public static void concertoMaisLongo(String[][] matrizCartaz) {

        int maxDuracao = 0;
        for (int linha = 0; linha < matrizCartaz.length; linha++) {
            int duracao = Integer.parseInt(matrizCartaz[linha][6]);
            if (duracao > maxDuracao) {
                maxDuracao = duracao;
            }
        }

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
     * Função que mostra todos os artistas do cartaz sem repetir
     * @param matrizCartaz
     */
    public static void imprimirCartazArtistas(String[][] matrizCartaz) {
        System.out.println("\n***** CARTAZ DO FESTIVAL *****");

        for (int linha = 0; linha < matrizCartaz.length; linha++) {
            boolean duplicado = false;
            // verifica para nao ser duplicado
            for (int j = 0; j < linha; j++) {
                if (matrizCartaz[j][4].equalsIgnoreCase(matrizCartaz[linha][4])) {
                    duplicado = true;
                    break;
                }
            }

            if (!duplicado) {
                //coluna 4 é a do artista
                System.out.println(matrizCartaz[linha][4]);
            }
        }
        System.out.println();
    }

    /**
     * Função para realizar login-novo registro de festivaleiro
     * @param matrizBilhetes
     * @param nome
     * @param contacto
     * @param email
     */
    public static void novoRegisto(String[][] matrizBilhetes, String nome, String contacto, String email) {

        // encontra o maior idCliente existente para gerar o novo id
        int maiorId = 0;
        for (int linha = 0; linha < matrizBilhetes.length; linha++) {
            int idAtual = Integer.parseInt(matrizBilhetes[linha][1]);
            if (idAtual > maiorId) {
                maiorId = idAtual;
            }
        }
        int novoId = maiorId + 1;
    }

    /**
     * Função para fazer um quiz interativo com o festivaleiro
     * @param matrizQuiz
     * @param input de numero inteiro como resposta a escolher
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

            if (resposta.equals(matrizQuiz[linha][5])) {
                System.out.println("Resposta correta!");
                corretas++;
            } else {
                System.out.println("Resposta errada! A resposta correta era: " + matrizQuiz[linha][5]);
            }
        }

        System.out.println("\nQuiz Terminado\n");
        System.out.println("Respostas Corretas: " + corretas + "/" + matrizQuiz.length); //pontuação
    }

    /**
     * Função para saber os lugares de compismo disponíveis
     * A considerar que os lugares vao até 300
     * A disponibilidade são todos os números triangulares múltiplos de 5
     */
    public static void lugaresCampismo() {
        System.out.println("\n***** LUGARES DE CAMPISMO DISPONÍVEIS *****");

        int triangular = 0;
        int n = 1;

        while (triangular <= 300) {
            triangular = triangular + n; // soma os naturais consecutivos
            n++;

            if (triangular <= 300 && triangular % 5 == 0) { // a considerar que precisa ser multiplo de 5
                System.out.println("Lugar: " + triangular);
            }
        }
        System.out.println();
    }


}

