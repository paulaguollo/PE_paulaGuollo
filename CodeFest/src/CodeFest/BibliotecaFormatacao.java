package CodeFest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BibliotecaFormatacao {

    /**
     * Função para imprimir o ficheiro na consola
     * @param caminhoFicheiro
     * @throws FileNotFoundException
     */
    public static void imprimirFicheiroNaConsola(String caminhoFicheiro) throws FileNotFoundException {

        File ficheiro = new File(caminhoFicheiro);
        Scanner fileScanner = new Scanner(ficheiro);

        while (fileScanner.hasNextLine()) {
            String linha = fileScanner.nextLine();
            System.out.println(linha);
        }

    }

    /**
     * Função para aparecer o copyright depois de escolher a opção de sair do menu
     * @throws FileNotFoundException
     */
    public static void copyright() throws FileNotFoundException {
        imprimirFicheiroNaConsola("CodeFest/data/Festival_Copyright.txt");
    }

    /**
     * Função para primar entender depois do copyright para voltar ao menu
     */
    public static void primaEnter() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nPrima enter para voltar ao menu");
        input.nextLine();
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
    }

    }

