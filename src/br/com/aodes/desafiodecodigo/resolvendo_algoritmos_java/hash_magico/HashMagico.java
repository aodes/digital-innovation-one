package br.com.aodes.desafiodecodigo.resolvendo_algoritmos_java.hash_magico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class HashMagico {
    public static void main(String[] args) throws IOException {

        List<String> alfabeto = new ArrayList(Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer qtdTestes = Integer.parseInt(st.nextToken());
        Integer somaTotal = 0;
        Integer calculoLetra = 0;
        Integer calculoPalavra = 0;
        Integer elementoEntrada = 0;
        Integer posicaoAlfabeto = 0;
        Integer posicaoElemento = 0;

        for (int i = 0; i < qtdTestes; i++) {

            st = new StringTokenizer(br.readLine());
            Integer qtdPalavras = Integer.parseInt(st.nextToken());

            for (int j = 0; j < qtdPalavras; j++) {

                List<String> palavra = new ArrayList(Arrays.asList(br.readLine().split("")));

                for (int k = 0; k < palavra.size(); k++) {

                    posicaoAlfabeto = alfabeto.indexOf(palavra.get(k));
                    elementoEntrada = j;
                    posicaoElemento = k;

                    calculoLetra = posicaoAlfabeto + elementoEntrada + posicaoElemento;
                    calculoPalavra = calculoPalavra + calculoLetra;
                }

                somaTotal = somaTotal + calculoPalavra;
                calculoPalavra = 0;
                palavra.clear();
            }
            System.out.println(somaTotal);
            somaTotal = 0;
        }

    }
}
