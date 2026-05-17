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

        int opcao;
        do {
            System.out.println("\n-------------------------------");
            System.out.println("----- Qual palco queres ver?-----");
            System.out.println("1. Palco Main :)");
            System.out.println("2. Palco Java <3");
            System.out.println("3. Palco Commit o/");
            System.out.println("0. Nenhum destes. Quero Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println("\n------------------------------------------------");

            switch (opcao) {
                case 1:
                    imprimirFicheiroNaConsola("CodeFest/data/Palco_Main.txt");
                    break;
                case 2:
                    imprimirFicheiroNaConsola("CodeFest/data/Palco_Java.txt");
                    break;
                case 3:
                    imprimirFicheiroNaConsola("CodeFest/data/Palco_Main.txt");
                    break;
                case 0:
                    copyright();
                    primaEnter();
                    break;
                default:
                    System.out.println("Opção Inválida: " + opcao + "Tenta um dos nossos 3 palcos");
                    break;
            }

        } while (opcao != 0);
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

       /*
            System.out.println("1. Novo Registro");
            System.out.println("2. Procurar lugares de Campismo");
            System.out.println("8. Quiz musical");
           */
}

