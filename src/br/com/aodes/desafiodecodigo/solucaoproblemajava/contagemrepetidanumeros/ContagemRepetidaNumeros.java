package br.com.aodes.desafiodecodigo.solucaoproblemajava.contagemrepetidanumeros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ContagemRepetidaNumeros {

    public static void main(String[] args) throws IOException {

        List<Integer> listaNumeros = new ArrayList<>();
        Set<Integer> setNumeros = new LinkedHashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int qtdNumeros = Integer.parseInt(st.nextToken());

        for (int i = 0; i < qtdNumeros; i++) {
            listaNumeros.add(Integer.parseInt(br.readLine()));
        }

        listaNumeros = listaNumeros.stream().sorted().collect(Collectors.toList());


        for (Integer numero: listaNumeros) {
            setNumeros.add(numero);
        }

        for (Integer numberSet: setNumeros) {

            int contador = 0;

            for (Integer numberArray: listaNumeros) {

                if (numberSet == numberArray){

                    contador = contador + 1;

                }


            }
            System.out.println(numberSet + " aparece " + contador + " vez(es)");
        }

    }
}
