package br.com.aodes.desafiodecodigo.resolvendo_algoritmos_java.tabuleiro_secreto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TabuleiroSecreto {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tamTab = Integer.parseInt(st.nextToken());


        int[][] tabuleiro = new int[tamTab][tamTab];


        int qtdOpe = Integer.parseInt(st.nextToken());

        for (int i = 0; i < qtdOpe; i++) {

            st = new StringTokenizer(br.readLine());
            int tipOpe = Integer.parseInt(st.nextToken());

            // Verificado
            if (tipOpe == 1) {

                int x = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken());
                for (int j = 0; j < tabuleiro.length; j++) {
                    tabuleiro[x][j] = r;
                }
            }

            // Verificado
            if (tipOpe == 2) {

                int x = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken());
                for (int j = 0; j < tabuleiro.length; j++) {
                    tabuleiro[j][x] = r;
                }
            }

            // Verificado
            if (tipOpe == 3) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                List<Integer> arrayList = new ArrayList<>();
                Map<Integer, Long> mapaNumeroQtq = new HashMap<>();
                int numeroVencedor = 0;

                for (int j = 0; j < tabuleiro.length; j++) {
                    arrayList.add(tabuleiro[x][j]);
                }

                arrayList = arrayList.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());

                for (Integer numero : arrayList.stream().distinct().collect(Collectors.toList())) {
                    mapaNumeroQtq.put(numero, arrayList.stream().filter(integer -> integer.equals(numero)).count());
                }

                for (Integer numero : arrayList.stream().distinct().collect(Collectors.toList())) {
                    long variavel = 0;

                    if (variavel < mapaNumeroQtq.get(numero)) {
                        numeroVencedor = numero;
                    }

                }
                System.out.println(numeroVencedor);

            }

            // Verificado
            if (tipOpe == 4) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                List<Integer> arrayList = new ArrayList<>();
                Map<Integer, Long> mapaNumeroQtq = new HashMap<>();
                int numeroVencedor = 0;

                for (int j = 0; j < tabuleiro.length; j++) {
                    arrayList.add(tabuleiro[j][x]);
                }
                arrayList = arrayList.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());

                for (Integer numero : arrayList.stream().distinct().collect(Collectors.toList())) {
                    mapaNumeroQtq.put(numero, arrayList.stream().filter(integer -> integer.equals(numero)).count());
                }

                for (Integer numero : arrayList.stream().distinct().collect(Collectors.toList())) {
                    long variavel = 0;

                    if (variavel < mapaNumeroQtq.get(numero)) {
                        numeroVencedor = numero;
                    }
                }
                System.out.println(numeroVencedor);
            }
        }
    }
}
