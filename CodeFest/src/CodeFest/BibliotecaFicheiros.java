package CodeFest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BibliotecaFicheiros {
    /**
     * Função que conta o número de linhas de um ficheiro
     *
     * @param caminhoFicheiro Caminho para o ficheiro
     * @return Número de linhas totais
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static int contarLinhasFicheiro(String caminhoFicheiro) throws FileNotFoundException {

        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        int contagemLinhas = 0;

        // Enquanto o Scanner tiver uma linha para a frente
        while (sc.hasNextLine()) {
            // Avançamos a linha atual
            sc.nextLine();

            // Contamos +1
            contagemLinhas++;
        }

        return contagemLinhas;

    }

    /**
     * Função para contar as colunas para uma matriz
     * @param caminhoFicheiro
     * @param delimitador
     * @return Matriz completa
     * @throws FileNotFoundException
     */
    public static int contarColunasFicheiro(String caminhoFicheiro, String delimitador) throws FileNotFoundException {

        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        String linha = sc.nextLine();
        String[] linhaSeparada = linha.split(delimitador);

        int contagemColunas = linhaSeparada.length;

        return contagemColunas;
    }

    /**
     * Função para ler um ficheiro para Matriz
     * @param caminhoFicheiro
     * @param delimitador
     * @param temCabecalho
     * @return matriz completa com ou sem cabeçalho
     * @throws FileNotFoundException
     */
    public static String[][] lerFicheiroParaMatriz(String caminhoFicheiro, String delimitador, boolean temCabecalho) throws FileNotFoundException {

        int numeroLinhas = contarLinhasFicheiro(caminhoFicheiro);

        if(temCabecalho) {
            // Avançar o cabeçalho
           numeroLinhas--;
        }

        int numeroColunas = contarColunasFicheiro(caminhoFicheiro, delimitador);

        int linhaAtualMatriz = 0;

        String[][] matrizCompleta = new String[numeroLinhas][numeroColunas];

        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        if(temCabecalho) {
            // Avançar o cabeçalho
            sc.nextLine();
        }

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(delimitador);

//            matrizCompleta[linhaAtualMatriz][0] = linhaSeparada[0];
//            matrizCompleta[linhaAtualMatriz][1] = linhaSeparada[1];
//            matrizCompleta[linhaAtualMatriz][2] = linhaSeparada[2];
//            matrizCompleta[linhaAtualMatriz][3] = linhaSeparada[3];

            for (int i = 0; i < numeroColunas; i++) {
                matrizCompleta[linhaAtualMatriz][i] = linhaSeparada[i];
            }

            linhaAtualMatriz++;
        }

        return matrizCompleta;

    }




}
