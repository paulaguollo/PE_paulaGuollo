package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.lerFicheiroParaMatriz;

public class BibliotecaADM {

    /**
     * Função para validar Login
     * @param usernameInput - username
     * @param passwordInput - senha
     * @return Validação para seguir para o Menu de escolhas
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static boolean validarLogin(String usernameInput, String passwordInput) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        String[][] matrizAdmin = lerFicheiroParaMatriz("Ficheiros/Festival_AdminLogin.csv", ";");

        boolean valido = false;

        for (int i = 0; i < matrizAdmin.length; i++) {

            if (matrizAdmin[i].length >= 2) {

                if (usernameInput.equals(matrizAdmin[i][0]) && passwordInput.equals(matrizAdmin[i][1])) {

                    String usernameMatriz = matrizAdmin[i][0];
                    String passwordMatriz = matrizAdmin[i][1];

                    if (usernameInput.equals(usernameMatriz) && passwordInput.equals(passwordMatriz)) {
                        valido = true;
                    }

                }
            }
        }
        return valido;
    }
}
