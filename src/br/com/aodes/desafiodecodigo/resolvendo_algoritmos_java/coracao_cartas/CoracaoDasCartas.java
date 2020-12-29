package br.com.aodes.desafiodecodigo.resolvendo_algoritmos_java.coracao_cartas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CoracaoDasCartas {


    static Map<String, Integer> mapa = new HashMap<String, Integer>();

    private static Boolean jogando(List<List<Integer>> pilhaDeCartas, int a, int b, int c) {

        Integer limitador = pilhaDeCartas.size();
        String chaveMapa = "" + a + b + c;

        if (a == b && b == c && c == limitador) {

            mapa.putIfAbsent(chaveMapa, 1);
            return true;
        }

        int valor = mapa.getOrDefault(chaveMapa, 0);

        if (valor > 0) return (valor == 1? true : false);

        Integer cartaA = 0;
        Integer cartaB = 0;
        Integer cartaC = 0;

        if (a < limitador) {
            cartaA = pilhaDeCartas.get(a).get(0);
        }
        if (b < limitador) {
            cartaB = pilhaDeCartas.get(b).get(1);
        }
        if (c < limitador) {
            cartaC = pilhaDeCartas.get(c).get(2);
        }

        Integer somaABC = cartaA + cartaB + cartaC;
        if (a < limitador && b < limitador && c < limitador) {
            if (somaABC % 3 == 0 && jogando(pilhaDeCartas, a + 1, b + 1, c + 1)) {
                mapa.putIfAbsent(chaveMapa, 1);
                return true;
            }
        }

        Integer somaAB = cartaA + cartaB;
        if (a < limitador && b < limitador) {
            if (somaAB % 3 == 0 && jogando(pilhaDeCartas, a + 1, b + 1, c)) {
                mapa.putIfAbsent(chaveMapa, 1);
                return true;
            }
        }

        Integer somaBC = cartaB + cartaC;
        if (b < limitador && c < limitador) {
            if (somaBC % 3 == 0 && jogando(pilhaDeCartas, a, b + 1, c + 1)) {
                mapa.putIfAbsent(chaveMapa, 1);
                return true;
            }
        }

        Integer somaAC = cartaA + cartaC;
        if (a < limitador && c < limitador) {
            if (somaAC % 3 == 0 && jogando(pilhaDeCartas, a + 1, b, c + 1)) {
                mapa.putIfAbsent(chaveMapa, 1);
                return true;
            }
        }

        if (c < limitador) {
            if (cartaC % 3 == 0 && jogando(pilhaDeCartas, a, b, c + 1)) {
                mapa.putIfAbsent(chaveMapa, 1);
                return true;
            }
        }

        if (b < limitador) {
            if (cartaB % 3 == 0 && jogando(pilhaDeCartas, a, b + 1, c)) {
                mapa.putIfAbsent(chaveMapa, 1);
                return true;
            }
        }

        if (a < limitador) {
            if (cartaA % 3 == 0 && jogando(pilhaDeCartas, a + 1, b, c)) {
                mapa.putIfAbsent(chaveMapa, 1);
                return true;
            }
        }
        mapa.putIfAbsent(chaveMapa, 2);
        return false;
    }


    //
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer qtdCartas = Integer.parseInt(st.nextToken());
        Boolean valid = true;

        while (qtdCartas > 0) {

            List<List<Integer>> pilhaDeCartas = new ArrayList<>();


            while (qtdCartas > 0) {

                List<Integer> filaDeCartas = new ArrayList<>();

                st = new StringTokenizer(br.readLine());

                Integer cartaA = Integer.parseInt(st.nextToken());
                Integer cartaB = Integer.parseInt(st.nextToken());
                Integer cartaC = Integer.parseInt(st.nextToken());

                filaDeCartas.add(cartaA);
                filaDeCartas.add(cartaB);
                filaDeCartas.add(cartaC);

                pilhaDeCartas.add(filaDeCartas);

                qtdCartas = qtdCartas - 1;
            }

            valid = jogando(pilhaDeCartas, 0, 0, 0);

            if (valid) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

            st = new StringTokenizer(br.readLine());
            qtdCartas = Integer.parseInt(st.nextToken());
            mapa.clear();
        }
    }
}
