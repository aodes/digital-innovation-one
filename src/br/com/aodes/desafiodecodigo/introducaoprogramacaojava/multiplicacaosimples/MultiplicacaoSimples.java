package br.com.aodes.desafiodecodigo.introducaoprogramacaojava.multiplicacaosimples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MultiplicacaoSimples {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int valor1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int valor2 = Integer.parseInt(st.nextToken());
        int resultado = valor1 * valor2;
        System.out.println("PROD = " + resultado);
    }
}
