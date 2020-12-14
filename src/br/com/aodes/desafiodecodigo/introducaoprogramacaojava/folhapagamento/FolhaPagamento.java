package br.com.aodes.desafiodecodigo.introducaoprogramacaojava.folhapagamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FolhaPagamento {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int numero = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int horas = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double salario = Double.parseDouble(st.nextToken());

        double resultado = horas * salario;
        System.out.println("NUMBER = " + numero);
        System.out.printf("SALARY = U$ %.2f %n", resultado);
    }
}
