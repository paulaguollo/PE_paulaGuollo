package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaADM.*;
import static CodeFest.BibliotecaFormatacao.*;
import static CodeFest.Menus.*;

public class MenuADM {

    /**
     * Função do menu do Admin
      * @param matrizBilhetes
     * @param matrizCartaz
     * @param matrizQuiz
     * @param matrizAdmin
     * @throws FileNotFoundException
     */
public static void menuAdmin(String[][] matrizBilhetes, String[][] matrizCartaz, String[][] matrizQuiz,  String[][] matrizAdmin) throws FileNotFoundException {
    Scanner input = new Scanner(System.in);

    int opcao;
    do {
        System.out.println("\n------------------------------------------------");
        System.out.println("----- Menu de Análise de Playlists - Admin -------");
        System.out.println("\n------------------------------------------------");
        System.out.println("1. Consulta de Ficheiros");
        System.out.println("2. Total de Bilhetes Vendidos");
        System.out.println("3. Pesquisa de Festivaleiro");
        System.out.println("4. Bilhete Mais Caro");
        System.out.println("5. Melhores Festivaleiros");
        System.out.println("6. Pesquisa de Bilhetes por Dia");
        System.out.println("7. Receita por tipo de Bilhete");
        System.out.println("8. Receita por dia do Festival");
        System.out.println("0. Sair");

        System.out.print("Opção: ");
        opcao = input.nextInt();

        System.out.println("\n------------------------------------------------");

        switch (opcao) {
            case 1:
                menuConsultaFicheiro();
                break;

            case 2:
                totalBilhetesVendidos(matrizBilhetes);
                break;

            case 3:
                System.out.println("------Pesquisa de Festivaleiro------");
                System.out.print("Por favor informe o Id do Festivaleiro: ");
                String idCliente = input.next();

                break;

            case 4:
                System.out.println("------Bilhete Mais Caro------");

                break;

            case 5:
                System.out.println("------Melhores Festivaleiros------");

                break;

            case 6:
                System.out.println("------Pesquisa de Bilhetes por Dia------");

                break;

            case 7:
                System.out.println("------Receita por tipo de Bilhete------");

                break;

            case 8:
                System.out.println("------Receita por dia do Festival------");

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
}
