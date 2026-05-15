package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaFormatacao.copyright;
import static CodeFest.BibliotecaFormatacao.primaEnter;

public class BibliotecaADM {

    /**
     * Função para validar Login
     *
     * @param usernameInput - username
     * @param passwordInput - senha
     * @return Validação para seguir para o Menu de escolhas
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static boolean validarLogin(String usernameInput, String passwordInput, String[][] matrizAdmin) throws FileNotFoundException {


        for (int i = 0; i < matrizAdmin.length; i++) {

            if (matrizAdmin[i].length >= 2) {

                if (usernameInput.equals(matrizAdmin[i][0]) && passwordInput.equals(matrizAdmin[i][1])) {

                    String usernameMatriz = matrizAdmin[i][0];
                    String passwordMatriz = matrizAdmin[i][1];


                    if (usernameInput.equals(usernameMatriz) && passwordInput.equals(passwordMatriz)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void menuConsultaFicheiro() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n------------------------------------------------");
            System.out.println("----- Escolha o Ficheiro que quer consultar -----");
            System.out.println("1. Bilhetes");
            System.out.println("2. Cartaz");
            System.out.println("3. Login do Admin");
            System.out.println("4. Quiz");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println("\n------------------------------------------------");

            switch (opcao) {
                case 1:
                    System.out.println("------Ficheiro dos Bilhetes------");
                    lerFicheiroParaMatriz("CodeFest/data/Festival_Bilhetes.csv", ";", true);
                    break;

                case 2:
                    System.out.println("------Ficheiro do Cartaz------");
                    lerFicheiroParaMatriz("CodeFest/data/Festival_Cartaz.csv", ";", true);
                    break;

                case 3:
                    System.out.println("------Ficheiro de Login do Admin------");
                    lerFicheiroParaMatriz("CodeFest/data/Festival_AdminLogin.csv", ";", false);
                    break;

                case 4:
                    System.out.println("------Ficheiro do Quiz------");
                    lerFicheiroParaMatriz("CodeFest/data/Festival_Quiz.csv", ";", true);
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

    public static void totalBilhetesVendidos() throws FileNotFoundException {


        int totalBilhetes = contarLinhasFicheiro("CodeFest/data/Festival_Bilhetes.csv");
        String [][] matrizBilhetes = lerFicheiroParaMatriz("CodeFest/data/Festival_Bilhetes.csv", ";", true);
        double valorTotal = 0;

            for (int i = 0; i < matrizBilhetes.length; i++) {
                valorTotal += Double.parseDouble(matrizBilhetes[i][7]);
            }
            System.out.println("A quantidade de bilhetes vendidos é: " + totalBilhetes);
            System.out.println("O Valor total faturado com os bilhetes é: " + valorTotal);
    }
}


