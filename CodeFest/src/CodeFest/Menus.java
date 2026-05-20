package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaADM.*;
import static CodeFest.BibliotecaFormatacao.*;
import static CodeFest.MenuADM.*;
import static CodeFest.MenuFestivaleiro.*;

public class Menus {

    /**
     * Função do menu de login inicial
     * @param matrizBilhetes
     * @param matrizCartaz
     * @param matrizQuiz
     * @param matrizAdmin
     * @throws FileNotFoundException
     */
        public static void menuLogin( String[][] matrizBilhetes,String[][] matrizCartaz, String[][] matrizQuiz, String[][] matrizAdmin ) throws FileNotFoundException {
            Scanner input = new Scanner(System.in);

            // int opcao;
            String opcao;
            do {
                System.out.println("\n----------- Bem-vindo ao CodeFest :) -----------\n");
                System.out.println("1. Admin");
                System.out.println("2. Festivaleiro");
                System.out.println("0. Sair");

                System.out.print("\nEscolha a Opção: ");
                opcao = input.next();

                System.out.println("\n------------------------------------------");


                switch (opcao) {
                    case "1": // ADM — validação
                        System.out.print("Username: ");
                        input.nextLine();
                        String usernameInput = input.nextLine();

                        System.out.print("Password: ");
                        String passwordInput = input.nextLine();

                        // Valida pelo ficheiro Festival_AdminLogin.csv
                        if (validarLogin(usernameInput, passwordInput, matrizAdmin)) {
                            System.out.println("Login realizado com sucesso! Bem-vindo :)");
                            menuAdmin(matrizBilhetes, matrizCartaz, matrizQuiz, matrizAdmin);
                        } else {
                            System.out.println("Username ou password incorretos. Tente novamente.");
                        }
                        break;

                    case "2": // FESTIVALEIRO
                        menuCliente(matrizBilhetes, matrizCartaz, matrizQuiz, matrizAdmin);
                        break;

                    case "0":
                        System.out.println("\nEspero que se divirta no nossa festival! Até jazz :)\n");
                        copyright();
                        primaEnter();
                        break;

                    default:
                        System.out.println("Opção Inválida: " + opcao);
                        break;
                }

            } while (!opcao.equals("0"));
        }

    /**
     * Função main para rodar o programar a ler os ficheiros
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        String[][] matrizBilhetes = lerFicheiroParaMatriz("CodeFest/data/Festival_Bilhetes.csv", ";", true);
        String[][] matrizCartaz  = lerFicheiroParaMatriz("CodeFest/data/Festival_Cartaz.csv", ";", true);
        String[][] matrizQuiz = lerFicheiroParaMatriz("CodeFest/data/Festival_Quiz.csv", ";", true);
        String[][] matrizAdmin = lerFicheiroParaMatriz("CodeFest/data/Festival_AdminLogin.csv", ";", false);

        menuLogin(matrizBilhetes, matrizCartaz, matrizQuiz, matrizAdmin);
    }
}


