package br.com.aodes.desafiodecodigo.resolvendo_algoritmos_java.abreviando_posts_blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AbreviandoPostBlog {

    public static void main(String[] args) throws IOException {

        List<String> arrayLetras = new ArrayList(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String texto = br.readLine().trim().toLowerCase().replaceAll("\n", " ").replaceAll("\t", " ");

        while (!texto.equals(".")) {
            if (texto.length() <= 0) continue;

            List<String> arrayListPalavras = new ArrayList(Arrays.asList(texto.split(" ")));
            Map<String, String> hashMapPalavras = new HashMap<>();
            Map<String, Map<String, Integer>> mapaComparacaoPalavras = new HashMap<>();

            for (String letra : arrayLetras) {
                hashMapPalavras.put(letra, "");
            }

            for (String letra : arrayLetras) {
                mapaComparacaoPalavras.put(letra, new HashMap<>());
            }


            for (String palavra : arrayListPalavras) {
                mapaComparacaoPalavras.get(palavra.substring(0, 1)).put(palavra, 0);
            }


            for (String palavra : arrayListPalavras) {
                int valor = mapaComparacaoPalavras.get(palavra.substring(0, 1)).get(palavra);
                valor = valor + 1;
                mapaComparacaoPalavras.get(palavra.substring(0, 1)).put(palavra, valor);
            }

            // inspecionado
            for (String letra : arrayLetras) {

                Map<String, Integer> mapaPalavrasPorLetra = mapaComparacaoPalavras.get(letra);
                List<String> keys = new ArrayList<>(mapaPalavrasPorLetra.keySet());

                int numeroCaracteres = 0;


                for (String key : keys) {
                    numeroCaracteres += mapaPalavrasPorLetra.get(key) * key.length();
                }

                int numeroCaracteresMax;
                int numeroCaracteresAux = 10000;


                for (String key : keys) {

                    numeroCaracteresMax = (numeroCaracteres - (mapaPalavrasPorLetra.get(key) * key.length())) + (mapaPalavrasPorLetra.get(key) * 2);

                    if ((numeroCaracteresAux > numeroCaracteresMax) && key.length() > 2) {

                        numeroCaracteresAux = numeroCaracteresMax;
                        hashMapPalavras.put(letra, key);

                    }

                }
            }

            String fraseFinal = arrayListPalavras
                    .stream()
                    .map(palavra -> {

                        String letraInicial = palavra.substring(0, 1);
                        return hashMapPalavras.get(letraInicial).equals(palavra) ? letraInicial + "." : palavra;

                    }).collect(Collectors.joining(" "));
            System.out.println(fraseFinal);

            int qtdAbv = 0;
            for (String letra : arrayLetras) {

                if (!hashMapPalavras.get(letra).equals("")) {
                    qtdAbv = qtdAbv + 1;
                }

            }
            System.out.println(qtdAbv);


            arrayLetras.stream().forEach(letra -> {

                if (!hashMapPalavras.get(letra).equals("")) {
                    System.out.println(letra + ". = " + hashMapPalavras.get(letra));
                }
            });

            texto = br.readLine().trim().toLowerCase().replaceAll("\n", " ").replaceAll("\t", " ");
        }
    }
}
