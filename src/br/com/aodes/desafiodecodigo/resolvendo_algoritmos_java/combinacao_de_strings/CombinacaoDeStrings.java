package br.com.aodes.desafiodecodigo.resolvendo_algoritmos_java.combinacao_de_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombinacaoDeStrings {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer qtdCasos = Integer.parseInt(st.nextToken());

        for (int i = 0; i < qtdCasos; i++) {



        st = new StringTokenizer(br.readLine());
        String texto1[] = st.nextToken().split("");
        String texto2[] = st.nextToken().split("");

        String textoFinal = "";

        if(texto1.length >= texto2.length){

            int aux = texto2.length;
            int resto = texto1.length - texto2.length;

            for (int k = 0; k < texto2.length; k++) {

                textoFinal = textoFinal + texto1[k];
                textoFinal = textoFinal + texto2[k];
            }

            for (int j = 0; j < resto; j++) {
                textoFinal = textoFinal + texto1[j + aux];
            }
        }

            if(texto2.length > texto1.length){

                int aux = texto1.length;
                int resto = texto2.length - texto1.length;

                for (int k = 0; k < texto1.length; k++) {

                    textoFinal = textoFinal + texto1[k];
                    textoFinal = textoFinal + texto2[k];
                }

                for (int j = 0; j < resto; j++) {
                    textoFinal = textoFinal + texto2[j + aux];
                }
            }

        System.out.println(textoFinal);
        }
    }
}
