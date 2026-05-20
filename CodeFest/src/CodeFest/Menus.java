package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaADM.*;
import static CodeFest.BibliotecaFormatacao.*;
import static CodeFest.MenuADM.*;
import static CodeFest.MenuFestivaleiro.*;

/**
 * Classe principal do sistema CodeFest.
 * Contém o menu de entrada (escolha de tipo de utilizador) e o método main,
 * que carrega todos os ficheiros de dados e inicia a aplicação.
 */
public class Menus {

    /**
     * Apresenta o menu inicial de seleção de tipo de utilizador.
     * Permite escolher entre Admin (com autenticação) e Festivaleiro (acesso direto).
     * O menu repete até o utilizador escolher sair (opção 0).
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes
     * @param matrizCartaz   Matriz com os dados do cartaz
     * @param matrizQuiz     Matriz com as perguntas do quiz
     * @param matrizAdmin    Matriz com as credenciais de administrador
     * @throws FileNotFoundException Caso algum ficheiro referenciado não exista
     */
        public static void menuLogin( String[][] matrizBilhetes,String[][] matrizCartaz, String[][] matrizQuiz, String[][] matrizAdmin ) throws FileNotFoundException {
            Scanner input = new Scanner(System.in);

            String opcao;
            //Ecrã de boas-vindas
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
                        input.nextLine(); // limpa o buffer após input.next()
                        String usernameInput = input.nextLine();

                        System.out.print("Password: ");
                        String passwordInput = input.nextLine();

                        // Valida as credenciais pelo ficheiro Festival_AdminLogin.csv
                        if (validarLogin(usernameInput, passwordInput, matrizAdmin)) {
                            System.out.println("Login realizado com sucesso! Bem-vindo, " +usernameInput + ":)");
                            menuAdmin(matrizBilhetes, matrizCartaz, matrizQuiz, matrizAdmin);
                        } else {
                            System.out.println("Username ou password incorretos. Tente novamente.");
                        }
                        break;

                    case "2": // Acesso festivaleiro: sem autenticação, vai diretamente para o menu
                        menuCliente(matrizBilhetes, matrizCartaz, matrizQuiz, matrizAdmin);
                        break;

                    case "0":
                        // Mensagem de despedida e copyright ao sair do programa
                        System.out.println("\nEspero que se divirta no nossa festival! Até jazz :)\n");
                        copyright();
                        primaEnter();
                        break;

                    default:
                        // Input inválido: informa e repete o menu
                        System.out.println("Opção Inválida: " + opcao);
                        break;
                }

            } while (!opcao.equals("0"));
        }


    /**
     * Ponto de entrada da aplicação CodeFest.
     * Carrega todos os ficheiros de dados para matrizes e inicia o menu de login.
     *
     * Ficheiros carregados:
     * - Festival_Bilhetes.csv    → bilhetes vendidos (com cabeçalho)
     * - Festival_Cartaz.csv      → programação musical (com cabeçalho)
     * - Festival_Quiz.csv        → perguntas do quiz (com cabeçalho)
     * - Festival_AdminLogin.csv  → credenciais de admin (sem cabeçalho)
     *
     * @param args Argumentos da linha de comandos (não utilizados)
     * @throws FileNotFoundException Caso algum dos ficheiros de dados não seja encontrado
     */
    public static void main(String[] args) throws FileNotFoundException {

        // Carrega todos os ficheiros CSV para matrizes
        String[][] matrizBilhetes = lerFicheiroParaMatriz("CodeFest/data/Festival_Bilhetes.csv", ";", true);
        String[][] matrizCartaz  = lerFicheiroParaMatriz("CodeFest/data/Festival_Cartaz.csv", ";", true);
        String[][] matrizQuiz = lerFicheiroParaMatriz("CodeFest/data/Festival_Quiz.csv", ";", true);
        String[][] matrizAdmin = lerFicheiroParaMatriz("CodeFest/data/Festival_AdminLogin.csv", ";", false); // sem cabeçalho

        // Inicia o menu principal
        menuLogin(matrizBilhetes, matrizCartaz, matrizQuiz, matrizAdmin);
    }
}


