package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaFestivaleiro.*;
import static CodeFest.BibliotecaADM.*;
import static CodeFest.BibliotecaFormatacao.*;

public class Menus {

    //MENU INICIAL DE LOGIN

        public static void menuLogin( String[][] matrizBilhetes,String[][] matrizCartaz, String[][] matrizQuiz, String[][] matrizAdmin ) throws FileNotFoundException {
            Scanner input = new Scanner(System.in);

            int opcao;
            do {
                System.out.println("\n------ Bem-vindo ao CodeFest :) ------");
                System.out.println("1. Admin");
                System.out.println("2. Festivaleiro");
                System.out.println("0. Sair");

                System.out.print("Opção: ");
                opcao = input.nextInt();

                System.out.println("\n------------------------------------------");


                switch (opcao) {
                    case 1: // ADM — validação
                        System.out.print("Username: ");
                        input.nextLine();
                        String usernameInput = input.nextLine();

                        System.out.print("Password: ");
                        String passwordInput = input.nextLine();

                        // Valida pelo ficheiro Festival_AdminLogin.csv
                        if (validarLogin(usernameInput, passwordInput, matrizAdmin)) {
                            System.out.println("Login realizado com sucesso! Bem-vindo :)");
                            menuAdmin( matrizBilhetes, matrizCartaz, matrizQuiz);
                        } else {
                            System.out.println("Username ou password incorretos. Tente novamente.");
                        }
                        break;

                    case 2: // FESTIVALEIRO
                        menuCliente( matrizBilhetes, matrizCartaz, matrizQuiz);
                        break;

                    case 0:
                        System.out.println("0. Sair");
                        System.out.println("Espero que se divirta no nossa festival! Até jazz :)");
                        copyright();
                        primaEnter();
                        break;

                    default:
                        System.out.println("Opção Inválida: " + opcao);
                        break;
                }

            } while (opcao != 0);
        }

//MENU FESTIVALEIRO

    public static void menuCliente( String[][] matrizBilhetes, String[][] matrizCartaz, String[][] matrizQuiz) throws FileNotFoundException {
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

    //MENU ADM
    public static void menuAdmin(String[][] matrizBilhetes, String[][] matrizCartaz, String[][] matrizQuiz) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n\n\n------------------------------------------------");
            System.out.println("----- Menu de Análise de Playlists - Admin -----");
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

            System.out.println("\n\n\n------------------------------------------------");

            switch (opcao) {
                case 1:
                    System.out.println("------Consulta de Ficheiros------");

                    break;

                case 2:
                    System.out.println("------Total de Bilhetes Vendidos------");

                    break;

                case 3:
                    System.out.println("------Pesquisa de Festivaleiro------");

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
                    System.out.println("------Sair------");
                    copyright();
                    primaEnter();
                    break;

                default:
                    System.out.println("Opção Inválida: " + opcao);
                    break;
            }

        } while (opcao != 0);
    }



    public static void main(String[] args) throws FileNotFoundException {

        String[][] matrizBilhetes = lerFicheiroParaMatriz("CodeFest/data/Festival_Bilhetes.csv", ";", true);
        String[][] matrizCartaz  = lerFicheiroParaMatriz("CodeFest/data/Festival_Cartaz.csv", ";", true);
        String[][] matrizQuiz = lerFicheiroParaMatriz("CodeFest/data/Festival_Quiz.csv", ";", true);
        String[][] matrizAdmin = lerFicheiroParaMatriz("CodeFest/data/Festival_AdminLogin.csv", ";", false);

        menuLogin(matrizBilhetes, matrizCartaz, matrizQuiz, matrizAdmin);
    }
}


