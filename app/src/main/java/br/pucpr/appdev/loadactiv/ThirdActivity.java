package br.pucpr.appdev.loadactiv;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by PUCPR on 23/07/16.
 */
public class ThirdActivity extends ListActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String name = getIntent().getStringExtra("nome");
        Toast.makeText(this, name + ", escolha a sua cidade destino", Toast.LENGTH_LONG).show();


        String itens[] = {

                "Curitiba", "Cuiabá", "Porto Alegre", "Manaus", "Florianopolis"
        };

        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(
                                                                    this,
                                                                    android.R.layout.simple_list_item_activated_1,
                                                                    itens

        );

        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent();
        switch (position){
            case 0:
                intent.putExtra("mensagem", "Você selecionou Curitiba");
                break;
            case 1:
                intent.putExtra("mensagem", "Você selecionou Cuiabá");
                break;
            case 2:
                intent.putExtra("mensagem", "Você selecionou Porto Alegre");
                break;
            case 3:
                intent.putExtra("mensagem", "Você selecionou Manaus");
                break;
            case 4:
                intent.putExtra("mensagem", "Você selecionou Florianópolis");
                break;

        }

        setResult(RESULT_OK, intent);

        finish();

    }
}
