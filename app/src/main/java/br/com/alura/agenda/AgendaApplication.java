package br.com.alura.agenda;

import android.app.Application;

import androidx.room.Room;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.database.AgendaDatabase;
import br.com.alura.agenda.database.dao.RoomAlunoDAO;
import br.com.alura.agenda.model.Aluno;

@SuppressWarnings("unused")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        //AlunoDAO dao = new AlunoDAO();
        AgendaDatabase database = Room.databaseBuilder(this, AgendaDatabase.class, "agenda.db")
                .allowMainThreadQueries() // não recomendado, apenas para testar
                .build();
        // para funcionar essa linha tem que implementar o método que retorna o DAO na AgendaDatabase
        RoomAlunoDAO dao = database.getRoomAlunoDAO();
        dao.salva(new Aluno("Diogo", "112233", "diogo@tecno.com.br"));
        dao.salva(new Aluno("Ândrea", "998800", "andrea@gmail.com"));
    }
}
