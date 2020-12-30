package br.com.aodes.desafiodecodigo.ordenacaofiltrosjava.uniforme_final_ano;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class UniformeFinalAno {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer qtdUniformes = Integer.parseInt(st.nextToken());

        List<Uniforme> listUniformes = new ArrayList<>();


        for (int i = 0; i < qtdUniformes; i++) {

            String nome = br.readLine();
            st = new StringTokenizer(br.readLine());
            String cor = st.nextToken();
            String tamanho = st.nextToken();

            Uniforme uniforme = new Uniforme(nome , cor , tamanho);

            listUniformes.add(uniforme);
        }

        listUniformes = listUniformes.stream().sorted(Comparator.comparing(Uniforme::getNome)).collect(Collectors.toList());
        listUniformes = listUniformes.stream().sorted(Comparator.comparing(Uniforme::getTamanho).reversed()).collect(Collectors.toList());
        listUniformes = listUniformes.stream().sorted(Comparator.comparing(Uniforme::getCor)).collect(Collectors.toList());

        for (Uniforme uniforme: listUniformes) {
            System.out.println(uniforme);
        }

    }
}

class Uniforme{

    String nome;
    String cor;
    String tamanho;

    public Uniforme(String nome, String cor, String tamanho) {
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return cor + " " + tamanho + " " + nome;
    }
}
