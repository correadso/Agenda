package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaId();
    }

    private void atualizaId() {
        contadorDeIds++;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos); // retorna uma cópia
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);
        if (alunoEncontrado != null) {
            alunos.set(alunos.indexOf(alunoEncontrado), aluno);
        }
    }

    private Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public void remove(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);
        if (alunoEncontrado != null)
            alunos.remove(alunoEncontrado);
    }
}
