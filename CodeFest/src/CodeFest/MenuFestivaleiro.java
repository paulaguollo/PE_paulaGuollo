package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaADM.pesquisaBilhetesPorDia;
import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaFestivaleiro.*;
import static CodeFest.BibliotecaFormatacao.*;
import static CodeFest.Menus.*;

/**
 * Classe responsável pelo menu principal do Festivaleiro.
 * Apresenta as opções disponíveis em loop até o utilizador escolher sair,
 * delegando cada funcionalidade para os métodos da BibliotecaFestivaleiro.
 */
public class MenuFestivaleiro {

    /**
     * Exibe e gere o menu do festivaleiro em loop até o utilizador escolher sair (opção 0).
     * Cada opção chama o método correspondente da BibliotecaFestivaleiro.
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (sem cabeçalho)
     * @param matrizCartaz   Matriz com os dados do cartaz (sem cabeçalho)
     * @param matrizQuiz     Matriz com as perguntas do quiz (sem cabeçalho)
     * @param matrizAdmin    Matriz com as credenciais de admin (não utilizado neste menu)
     * @throws FileNotFoundException Caso algum ficheiro referenciado não exista
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
                    // Registo de um novo festivaleiro
                    System.out.println("---------------Novo Registro---------------");
                    input.nextLine(); // limpa o buffer após input.next()
                    System.out.print("Insira Nome: ");
                    String nome = input.nextLine();
                    System.out.print("Insira Contacto: ");
                    String contacto = input.nextLine();
                    System.out.print("Insira Email: ");
                    String email = input.nextLine();
                    System.out.println("\nFestivaleiro Inserido com Sucesso: " + nome + " | " + contacto + " | " + email);
                    novoRegisto(matrizBilhetes, nome, contacto, email);
                    break;


                case "2":
                    // Lista os lugares de campismo disponíveis (triangulares múltiplos de 5, até 300)
                    lugaresCampismo();
                    break;

                case "3":
                    // Imprime todos os artistas do cartaz sem duplicados
                    imprimirCartazArtistas(matrizCartaz);
                    break;

                case "4":
                    // Submenu para escolher e ver o conteúdo gráfico de um palco
                    menuImprimePalco();
                    break;

                case "5":
                    // Mostra o(s) concerto(s) com maior duração
                    concertoMaisLongo(matrizCartaz);
                    break;

                case "6":
                    // Filtra o cartaz por dia do festival
                    System.out.print("O festival vai acontecer sexta, sábado e domingo\n");
                    System.out.print("\nQual é o dia que queres pesquisar? ");
                    input.nextLine(); // limpa o buffer
                    String dia = input.nextLine();
                    pesquisaPorDia(matrizCartaz, dia);
                    break;

                case "7":
                    // Filtra o cartaz por género musical
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
                    input.nextLine(); // limpa o buffer para permitir géneros com espaço
                    String genero = input.nextLine();
                    pesquisarPorGenero(matrizCartaz, genero);
                    break;

                case "8":
                    // Inicia o quiz musical interativo
                    input.nextLine(); // limpa o buffer para o quiz usar nextLine()
                    quizMusical(matrizQuiz, input);
                    break;

                case "0":
                    // Ao sair, mostra o copyright do festival
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