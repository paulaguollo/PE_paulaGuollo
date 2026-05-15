package CodeFest;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static CodeFest.BibliotecaFicheiros.lerFicheiroParaMatriz;

public class BibliotecaADM {

    /**
     * Função para validar Login
     *
     * @param usernameInput - username
     * @param passwordInput - senha
     * @return Validação para seguir para o Menu de escolhas
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static boolean validarLogin(String usernameInput, String passwordInput) throws FileNotFoundException {

        String[][] matrizAdmin = lerFicheiroParaMatriz("CodeFest/data/Festival_AdminLogin.csv", ";");
        int i = 0;

        if (matrizAdmin[i].length >= 2) {

            if (usernameInput.trim().equals(matrizAdmin[i][0].trim()) &&
                    passwordInput.trim().equals(matrizAdmin[i][1].trim())) {

                String usernameMatriz = matrizAdmin[i][0];
                String passwordMatriz = matrizAdmin[i][1];

                if (usernameInput.trim().equals(usernameMatriz.trim()) &&
                        passwordInput.trim().equals(passwordMatriz.trim())) {
                    return true;
                }
            }
        }
        return false;
    }
}
