package br.com.aodes.desafiodecodigo.ordenacaofiltrosjava.gincana_no_acampamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GincanaAcampamento {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer qtdAlunos = Integer.parseInt(st.nextToken());

        while (qtdAlunos != 0) {
            // *** Inicio ***

            // criando o array de alunos
            List<AlunoGincana> arrayAlunos = new ArrayList<>();
            for (int i = 0; i < qtdAlunos; i++) {
                st = new StringTokenizer(br.readLine());
                String nome = st.nextToken();
                int ficha = Integer.parseInt(st.nextToken());
                AlunoGincana obj = new AlunoGincana(nome, ficha);
                arrayAlunos.add(obj);
            }

            // *** ***
            int ficha = arrayAlunos.get(0).getFicha();
            int tamanhoArray = arrayAlunos.size();
            int index = 0;

            // ********************* ficha inicial impar ou par *********************
            if (ficha % 2 != 0) {
                index = 1;
            } else if (ficha % 2 == 0) {
                index = arrayAlunos.size() - 1;
            }

            // **********************************************************************
            while (tamanhoArray > 1) {

                if (ficha % 2 != 0) {

                    while (ficha > 0) {

                        index = index + 1;
                        if (index == tamanhoArray) {
                            index = 0;
                        }
                        ficha = ficha - 1;
                    }


                } else if (ficha % 2 == 0) {

                    while (ficha > 0) {

                        index = index - 1;
                        if (index == -1) {
                            index = arrayAlunos.size();
                        }
                        ficha = ficha - 1;
                    }
                }

                ficha = arrayAlunos.get(index).getFicha();
                arrayAlunos.remove(index);

                tamanhoArray = arrayAlunos.size();

                if(ficha % 2 != 0){
                    index = index - 1;
                }

            }

            System.out.println("Vencedor(a): " + arrayAlunos.get(0).getNome());


            // *** Capturando o próximo caso de teste com a quantidade de alunos
            st = new StringTokenizer(br.readLine());
            qtdAlunos = Integer.parseInt(st.nextToken());
        }
    }
}


