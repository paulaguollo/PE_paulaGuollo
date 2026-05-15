package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaFestivaleiro.*;
import static CodeFest.BibliotecaFormatacao.*;
import static CodeFest.Menus.*;

public class MenuFestivaleiro {

    /**
     * Função para o Menu do Cliente/Festivaleiro
     * @param matrizBilhetes
     * @param matrizCartaz
     * @param matrizQuiz
     * @param matrizAdmin
     * @throws FileNotFoundException
     */
    public static void menuCliente(String[][] matrizBilhetes, String[][] matrizCartaz, String[][] matrizQuiz, String[][] matrizAdmin) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- Menu de Festivaleiro :) -----");
            System.out.println("1. Novo Registro");
            System.out.println("2. Procurar lugares de Campismo");
            System.out.println("3. Imprimir Cartaz");
            System.out.println("4. Imprimir Palcos Gráficos");
            System.out.println("5. Imprimir Concerto mais longo");
            System.out.println("6. Imprimir Cartaz por dia");
            System.out.println("7. Imprimir Cartaz por Género Musical");
            System.out.println("8. Quiz musical");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println("\n----------------------------------------");

            switch (opcao) {
                case 1:
                    System.out.println("----------Novo Registro----------");
                    break;

                case 2:
                    System.out.println("-----Procurar lugares de Campismo------");
                    break;

                case 3:
                    System.out.println("----------Imprimir Cartaz----------");
                    break;

                case 4:
                    System.out.println("------Imprimir Palcos Gráficos-----");
                    break;

                case 5:
                    System.out.println("-----Imprimir Concerto mais longo-----");
                    break;

                case 6:
                    System.out.println("-----Imprimir Cartaz por dia-----");
                    break;

                case 7:
                    System.out.println("----Imprimir Cartaz por Género Musical----");
                    break;

                case 8:
                    System.out.println("------Quiz musical-----");
                    break;

                case 0:
                    System.out.println("----------Sair----------");
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