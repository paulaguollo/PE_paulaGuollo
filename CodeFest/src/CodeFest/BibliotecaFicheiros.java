package CodeFest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Biblioteca de utilitários para leitura de ficheiros.
 * Fornece métodos para contar linhas/colunas e carregar ficheiros CSV para matrizes de Strings.
 */
public class BibliotecaFicheiros {

    /**
     * Conta o número total de linhas de um ficheiro.
     *
     * @param caminhoFicheiro Caminho relativo ou absoluto para o ficheiro
     * @return Número total de linhas encontradas
     * @throws FileNotFoundException Caso o ficheiro não exista no caminho indicado
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
     * Conta o número de colunas de um ficheiro com base no delimitador indicado.
     * Utiliza a primeira linha do ficheiro para determinar o número de colunas.
     *
     * @param caminhoFicheiro Caminho relativo ou absoluto para o ficheiro
     * @param delimitador     Separador de colunas (ex: ";", ",")
     * @return Número de colunas encontradas na primeira linha
     * @throws FileNotFoundException Caso o ficheiro não exista no caminho indicado
     */
    public static int contarColunasFicheiro(String caminhoFicheiro, String delimitador) throws FileNotFoundException {

        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        // Lê a primeira linha e divide pelo delimitador para contar as colunas
        String linha = sc.nextLine();
        String[] linhaSeparada = linha.split(delimitador);

        int contagemColunas = linhaSeparada.length;

        return contagemColunas;
    }

    /**
     * Lê um ficheiro CSV e carrega o seu conteúdo para uma matriz de Strings bidimensional.
     * Permite opcionalmente saltar o cabeçalho (primeira linha).
     *
     * @param caminhoFicheiro Caminho relativo ou absoluto para o ficheiro
     * @param delimitador     Separador de colunas (ex: ";", ",")
     * @param temCabecalho    Se verdadeiro, a primeira linha (cabeçalho) é ignorada
     * @return Matriz String[][] com o conteúdo do ficheiro
     * @throws FileNotFoundException Caso o ficheiro não exista no caminho indicado
     */
    public static String[][] lerFicheiroParaMatriz(String caminhoFicheiro, String delimitador, boolean temCabecalho) throws FileNotFoundException {

        int numeroLinhas = contarLinhasFicheiro(caminhoFicheiro);

        // Se tem cabeçalho, descontamos uma linha para não incluí-lo nos dados
        if(temCabecalho) {
            // Avançar o cabeçalho
           numeroLinhas--;
        }

        int numeroColunas = contarColunasFicheiro(caminhoFicheiro, delimitador);

        int linhaAtualMatriz = 0;

        String[][] matrizCompleta = new String[numeroLinhas][numeroColunas];

        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        // Salta o cabeçalho, se necessário
        if(temCabecalho) {
            sc.nextLine();
        }

        // Preenche a matriz linha a linha, dividindo cada linha pelo delimitador
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
