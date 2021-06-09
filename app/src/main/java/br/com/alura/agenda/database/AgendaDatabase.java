package br.com.alura.agenda.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.alura.agenda.database.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 2, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {
    public abstract AlunoDAO getRoomAlunoDAO(); // a classe AlunoDAO deve ter a anotação DAO
    private static final String NOME_BANCO_DE_DADOS = "agenda.db";
    private static AgendaDatabase instance; // utilizando singleton

    // synchronized static permite que apenas uma Thread execute o método por vez,
    // assim não gera instâncias diferentes do database se duas Threads tentarem acessar ao mesmo tempo o método
    public synchronized static AgendaDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                    .allowMainThreadQueries() // não recomendado, apenas para testar
                    .build();
        }
        return instance;
    }
}

