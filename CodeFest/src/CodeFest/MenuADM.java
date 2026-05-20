package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.*;
import static CodeFest.BibliotecaADM.*;
import static CodeFest.BibliotecaFormatacao.*;
import static CodeFest.Menus.*;

/**
 * Classe responsável pelo menu principal do Administrador.
 * Apresenta as opções disponíveis em loop até o utilizador escolher sair,
 * delegando cada funcionalidade para os métodos da BibliotecaADM.
 */
public class MenuADM {

    /**
     * Exibe e gere o menu do administrador em loop até o utilizador escolher sair (opção 0).
     * Cada opção chama o método correspondente da BibliotecaADM.
     *
     * @param matrizBilhetes Matriz com os dados dos bilhetes (sem cabeçalho)
     * @param matrizCartaz   Matriz com os dados do cartaz (sem cabeçalho)
     * @param matrizQuiz     Matriz com as perguntas do quiz (sem cabeçalho)
     * @param matrizAdmin    Matriz com as credenciais de admin (sem cabeçalho)
     * @throws FileNotFoundException Caso algum ficheiro referenciado não exista
     */
public static void menuAdmin(String[][] matrizBilhetes, String[][] matrizCartaz, String[][] matrizQuiz,  String[][] matrizAdmin) throws FileNotFoundException {
    Scanner input = new Scanner(System.in);

    String opcao;
    do {
        System.out.println("\n------------------------------------------------");
        System.out.println("                  Menu do Admin                   ");
        System.out.println("------------------------------------------------\n");
        System.out.println("1. Consulta de Ficheiros");
        System.out.println("2. Total de Bilhetes Vendidos");
        System.out.println("3. Pesquisa de Festivaleiro");
        System.out.println("4. Bilhete Mais Caro");
        System.out.println("5. Melhores Festivaleiros");
        System.out.println("6. Pesquisa de Bilhetes por Dia");
        System.out.println("7. Receita por tipo de Bilhete");
        System.out.println("8. Receita por dia do Festival");
        System.out.println("0. Sair");

        System.out.print("\nEscolha a Opção: ");
        opcao = input.next();


        System.out.println("\n------------------------------------------------");

        switch (opcao) {
            case "1":
                // Submenu para escolha e visualização de ficheiros CSV
                menuConsultaFicheiro();
                break;

            case "2":
                // Mostra o total de bilhetes vendidos e valor faturado
                totalBilhetesVendidos(matrizBilhetes);
                break;

            case "3":
                // Pesquisa um festivaleiro pelo ID de cliente
                System.out.print("Por favor informe o Id do Festivaleiro: ");
                String idCliente = input.next();
                pesquisaFestivaleiro(matrizBilhetes, idCliente);
                break;

            case "4":
                // Mostra o(s) bilhete(s) com maior valor
                bilheteMaiscaro(matrizBilhetes);
                break;

            case "5":
                // Mostra o(s) festivaleiro(s) com maior gasto total
                melhoresFestivaleiros(matrizBilhetes);
                break;

            case "6":
                // Lista todos os bilhetes vendidos para um dia específico
                System.out.print("Qual é o dia que queres pesquisar? sexta, sábado ou domingo: ");
                String dia = input.next();
                pesquisaBilhetesPorDia(matrizBilhetes, dia);
                break;

            case "7":
                // Receita filtrada por tipo de bilhete (Diário, VIP, Backstage)
                System.out.print("Qual é o tipo de bilhete que queres pesquisar? backstage, vip ou diário: ");
                String tipo = input.next();
                receitaPorTipoBilhete(matrizBilhetes, tipo);
                break;

            case "8":
                // Receita total por cada dia do festival
                receitaPorDia(matrizBilhetes);
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
