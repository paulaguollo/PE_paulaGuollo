package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaCliente.*;
import static CodeFest.BibliotecaADM.*;
import static CodeFest.BibliotecaFormatacao.*;

public class Menus {
        public static void menuLogin(String[][] matrizMusicas){
            Scanner input = new Scanner(System.in);

            int opcao;
            do {
                System.out.println("\n\n\n------------------------------------------------");
                System.out.println("----- Bem-vindo ao CodeFest -----");
                System.out.println("1. Cliente");
                System.out.println("2. Administrador");
                System.out.println("0. Sair");

                System.out.print("Opção: ");
                opcao = input.nextInt();

                System.out.println("\n\n\n------------------------------------------------");

                switch (opcao) {
                    case 1:
                        menuCliente(matrizMusicas);
                        break;

                    case 2:
                        System.out.print("Username: ");
                        input.nextLine();
                        String usernameInput = input.nextLine();

                        System.out.print("Password: ");
                        String passwordInput = input.nextLine();

                        if(usernameInput.equalsIgnoreCase("it") && passwordInput.equalsIgnoreCase("12345")){
                            menuAdmin(matrizMusicas);
                        }else{
                            System.out.println("\nCredenciais Inválidas");
                        }

                        break;

                    case 0:
                        System.out.println("0. Sair");
                        break;

                    default:
                        System.out.println("Opção Inválida: " + opcao);
                        break;
                }

            } while (opcao != 0);
        }


    public static void menuCliente(String[][] matrizMusicas){
        Scanner input = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n\n\n------------------------------------------------");
            System.out.println("----- Menu de Clientes -----");
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

            System.out.println("\n\n\n------------------------------------------------");

            switch (opcao) {
                case 1:
                    System.out.println("1. Novo Registro");
                    break;

                case 2:
                    System.out.println("2. Procurar lugares de Campismo");
                    break;

                case 3:
                    System.out.println("3. Imprimir Cartaz");
                    break;

                case 4:
                    System.out.println("4. Imprimir Palcos Gráficos");
                    break;

                case 5:
                    System.out.println("5. Imprimir Concerto mais longo");
                    break;

                case 6:
                    System.out.println("6. Imprimir Cartaz por dia");
                    break;

                case 7:
                    System.out.println("7. Imprimir Cartaz por Género Musical");
                    break;

                case 8:
                    System.out.println("8. Quiz musical");
                    break;

                case 0:
                    System.out.println("0. Sair");
                    break;

                default:
                    System.out.println("Opção Inválida: " + opcao);
                    break;
            }

        } while (opcao != 0);

    }

    public static void menuAdmin(String[][] matrizMusicas){
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
                    System.out.println("1. Consulta de Ficheiros");

                    break;

                case 2:
                    System.out.println("2. Total de Bilhetes Vendidos");

                    break;

                case 3:
                    System.out.println("3. Pesquisa de Festivaleiro");

                    break;

                case 4:
                    System.out.println("4. Bilhete Mais Caro");

                    break;

                case 5:
                    System.out.println("5. Melhores Festivaleiros");

                    break;

                case 6:
                    System.out.println("6. Pesquisa de Bilhetes por Dia");

                    break;

                case 7:
                    System.out.println("7. Receita por tipo de Bilhete");

                    break;

                case 8:
                    System.out.println("8. Receita por dia do Festival");

                    break;

                case 0:
                    System.out.println("0. Sair");
                    break;

                default:
                    System.out.println("Opção Inválida: " + opcao);
                    break;
            }

        } while (opcao != 0);
    }



    public static void main(String[] args) throws FileNotFoundException {

        String[][] matrizMusicas = lerFicheiroParaMatriz("Ficheiros/exercicio_09.csv",",");

        menuLogin(matrizMusicas);


    }
}

