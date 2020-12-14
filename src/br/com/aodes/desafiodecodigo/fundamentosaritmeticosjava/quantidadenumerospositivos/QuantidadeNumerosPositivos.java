package br.com.aodes.desafiodecodigo.fundamentosaritmeticosjava.quantidadenumerospositivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuantidadeNumerosPositivos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int contador = 0;
        double[] lista = {0, 0, 0, 0, 0, 0};

        lista[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 6 ; i++) {
            st = new StringTokenizer(br.readLine());
            lista[i] = Double.parseDouble(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            if(lista[i] > 0){
                contador = contador + 1;
            }
        }

        System.out.println(contador + " valores positivos");
    }
}
