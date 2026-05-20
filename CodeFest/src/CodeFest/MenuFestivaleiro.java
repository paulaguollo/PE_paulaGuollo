package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaADM.pesquisaBilhetesPorDia;
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
        String opcao;

        do {
            System.out.println("\n------------------------------------------------");
            System.out.println("             Menu de Festivaleiro :)            ");
            System.out.println("------------------------------------------------");
            System.out.println("1. Novo Registro");
            System.out.println("2. Procurar lugares de Campismo");
            System.out.println("3. Imprimir Cartaz");
            System.out.println("4. Imprimir Palcos Gráficos");
            System.out.println("5. Imprimir Concerto mais longo");
            System.out.println("6. Imprimir Cartaz por dia");
            System.out.println("7. Imprimir Cartaz por Género Musical");
            System.out.println("8. Quiz musical");
            System.out.println("0. Sair");

            System.out.print("\nEscolha a Opção: ");
            opcao = input.next();

            System.out.println("\n------------------------------------------");

            switch (opcao) {
                case "1":
                    System.out.println("---------------Novo Registro---------------");
                    System.out.print("Insira Nome: \n");
                    String nome = input.nextLine();
                    System.out.print("Insira Contacto: \n");
                    String contacto = input.nextLine();
                    System.out.print("Insira Email: \n");
                    String email = input.nextLine();
                    System.out.println("Festivaleiro Inserido com Sucesso: " + nome + " | " + contacto + " | " + email);
                    novoRegisto(matrizBilhetes, nome, contacto, email);
                    break;


                case "2":
                    lugaresCampismo();
                    break;

                case "3":
                    imprimirCartazArtistas(matrizCartaz);
                    break;

                case "4":
                    menuImprimePalco();
                    break;

                case "5":
                    concertoMaisLongo(matrizCartaz);
                    break;

                case "6":
                    System.out.print("O festival vai acontecer sexta, sábado e domingo\n");
                    System.out.print("\nQual é o dia que queres pesquisar? ");
                    String dia = input.next();
                    pesquisaPorDia(matrizCartaz, dia);
                    break;

                case "7":
                    System.out.print("Temos todos estes géneros musicais no CodeFest\n");
                    System.out.println("Podes escolher Coro\n" +
                            "Rancho\n" +
                            "Pimba\n" +
                            "Popular\n" +
                            "Pop\n" +
                            "R&B\n" +
                            "Eletrónica\n" +
                            "Pop Alternativo\n" +
                            "Rock\n" +
                            "Rock Clássico\n" +
                            "Hard Rock\n" +
                            "Heavy Metal\n" +
                            "Metal Industrial\n" +
                            "Rock Alternativo");
                    System.out.print("\nQual queres pesquisar? ");
                    String genero = input.next();
                    pesquisarPorGenero(matrizCartaz, genero);
                    break;

                case "8":
                    quizMusical(matrizQuiz, input);
                    break;

                case "0":
                    copyright();
                    primaEnter();
                    break;

                default:
                    System.out.println("Opção Inválida: " + opcao);
                    break;
            }

        } while (!opcao.equals("0"));

    }
}