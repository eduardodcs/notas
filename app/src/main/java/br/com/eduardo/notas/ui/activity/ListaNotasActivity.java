package br.com.eduardo.notas.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.eduardo.notas.R;
import br.com.eduardo.notas.dao.NotaDAO;
import br.com.eduardo.notas.model.Nota;
import br.com.eduardo.notas.ui.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaNotas = findViewById(R.id.listView);

        NotaDAO dao = new NotaDAO();
        for(int i = 1; i <= 1000; i++){
            dao.insere(new Nota("Nota " + i,
                    "Descrição " + i));
        }

        List<Nota> todasNotas = dao.todos();

        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));

    }
}