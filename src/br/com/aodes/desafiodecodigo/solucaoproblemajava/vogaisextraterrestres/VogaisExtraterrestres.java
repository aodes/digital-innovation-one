package br.com.aodes.desafiodecodigo.solucaoproblemajava.vogaisextraterrestres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VogaisExtraterrestres {
    public static void main(String[] args) throws IOException {

        boolean valid = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String texto1 = br.readLine();
        String texto2 = br.readLine();

        while (valid) {

            char[] vogaisAlienigenas = texto1.toCharArray();
            char[] fraseFormadaLetrasDoMesmoAlfabeto = texto2.toCharArray();

            int contador = 0;

            for (char vogal : vogaisAlienigenas) {

                for (char letra : fraseFormadaLetrasDoMesmoAlfabeto) {

                    if (vogal == letra) {
                        contador = contador + 1;
                    }

                }

            }

            System.out.println(contador);
            contador = 0;

            texto1 = br.readLine();
            texto2 = br.readLine();

            if (texto1 == null) {
                valid = false;
            }
        }
    }
}
