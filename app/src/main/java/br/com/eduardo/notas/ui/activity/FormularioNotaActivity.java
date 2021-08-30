package br.com.eduardo.notas.ui.activity;

import static br.com.eduardo.notas.ui.activity.NotaActivityNotasConstantes.CHAVE_NOTA;
import static br.com.eduardo.notas.ui.activity.NotaActivityNotasConstantes.CODIGO_RESULTADO_NOTA_CRIADA;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import br.com.eduardo.notas.R;
import br.com.eduardo.notas.model.Nota;

public class FormularioNotaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_nota);
        setTitle("Insere nota");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario_nota_salva, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(ehMenuSalvaNota(item)){
            Nota notaCriada = criaNota();
            retornaNota(notaCriada);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void retornaNota(Nota nota) {
        Intent resultadoInsercao = new Intent();
        resultadoInsercao.putExtra(CHAVE_NOTA, nota);
        setResult(CODIGO_RESULTADO_NOTA_CRIADA, resultadoInsercao);
    }

    @NonNull
    private Nota criaNota() {
        TextView titulo = findViewById(R.id.formulario_nota_titulo);
        TextView descricao = findViewById(R.id.formulario_nota_descricao);
        return new Nota(titulo.getText().toString(),
                descricao.getText().toString());

    }

    private boolean ehMenuSalvaNota(@NonNull MenuItem item) {
        return item.getItemId() == R.id.menu_formulario_nota_ic_salva;
    }
}