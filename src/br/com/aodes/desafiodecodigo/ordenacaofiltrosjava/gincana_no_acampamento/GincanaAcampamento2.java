package br.com.aodes.desafiodecodigo.ordenacaofiltrosjava.gincana_no_acampamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GincanaAcampamento2 {
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
            int index = 0;
            int indexRemove = 0;
            int ficha = arrayAlunos.get(0).getFicha();

            for (int i = 0; i < qtdAlunos - 1; i++) {

                if (ficha % 2 == 0) {
                    indexRemove = (arrayAlunos.size() - (ficha % arrayAlunos.size()) + index) % arrayAlunos.size();

                } else if (ficha % 2 != 0){
                    indexRemove = (ficha % arrayAlunos.size() + index) % arrayAlunos.size();
                }

                ficha = arrayAlunos.get(indexRemove).getFicha();
                arrayAlunos.remove(indexRemove);


                index = (ficha % 2 == 0) ?
                        ((indexRemove <= arrayAlunos.size() - 1) ?
                                indexRemove : 0):
                        ((indexRemove == 0) ?
                                (arrayAlunos.size() - 1):(indexRemove - 1));

            }

            System.out.println("Vencedor(a): " + arrayAlunos.get(0).getNome());

            arrayAlunos.clear();

            // *** Capturando o próximo caso de teste com a quantidade de alunos
            st = new StringTokenizer(br.readLine());
            qtdAlunos = Integer.parseInt(st.nextToken());
        }
    }
}
class AlunoGincana {

    String nome;
    Integer ficha;

    public AlunoGincana(String nome, Integer ficha) {
        this.nome = nome;
        this.ficha = ficha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFicha() {
        return ficha;
    }

    public void setFicha(Integer ficha) {
        this.ficha = ficha;
    }
}