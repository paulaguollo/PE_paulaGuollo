package CodeFest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.lerFicheiroParaMatriz;

public class BibliotecaFormatacao {


    public static void imprimirFicheiroNaConsola(String caminhoFicheiro) throws FileNotFoundException {

        File ficheiro = new File(caminhoFicheiro);
        Scanner fileScanner = new Scanner(ficheiro);

        while (fileScanner.hasNextLine()) {
            String linha = fileScanner.nextLine();
            System.out.println(linha);
        }

    }

    public static void primaEnter() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nPrima enter para voltar ao menu");
        input.nextLine();
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
    }

    public static void copyright() throws FileNotFoundException {
        imprimirFicheiroNaConsola("CodeFest/data/Festival_Copyright.txt");
    }


    }

