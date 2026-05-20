package CodeFest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Biblioteca de utilitários de formatação e apresentação.
 * Fornece métodos para imprimir ficheiros na consola, mostrar o copyright e gerir pausas de navegação.
 */
public class BibliotecaFormatacao {

    /**
     * Imprime o conteúdo de um ficheiro de texto linha a linha na consola.
     *
     * @param caminhoFicheiro Caminho relativo ou absoluto para o ficheiro .txt ou .csv
     * @throws FileNotFoundException Caso o ficheiro não exista no caminho indicado
     */
    public static void imprimirFicheiroNaConsola(String caminhoFicheiro) throws FileNotFoundException {

        File ficheiro = new File(caminhoFicheiro);
        Scanner fileScanner = new Scanner(ficheiro);

        // Lê e imprime cada linha do ficheiro
        while (fileScanner.hasNextLine()) {
            String linha = fileScanner.nextLine();
            System.out.println(linha);
        }

    }

    /**
     * Imprime o ficheiro de copyright do festival na consola.
     * Chamado automaticamente ao sair de qualquer menu.
     *
     * @throws FileNotFoundException Caso o ficheiro Festival_Copyright.txt não exista
     */
    public static void copyright() throws FileNotFoundException {
        imprimirFicheiroNaConsola("CodeFest/data/Festival_Copyright.txt");
    }

    /**
     * Aguarda que o utilizador prima Enter antes de continuar.
     * Após a confirmação, imprime linhas em branco para "limpar" a consola visualmente.
     */
    public static void primaEnter() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nPrima enter para voltar ao menu");
        input.nextLine();

        // Simula limpeza de ecrã imprimindo linhas em branco
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
    }

    }

