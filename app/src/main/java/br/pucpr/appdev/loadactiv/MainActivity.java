package br.pucpr.appdev.loadactiv;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Atividades");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void btnLoadOnClick(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Sair");
                alert.setMessage("Deseja Sair?");
                alert.setIcon(android.R.drawable.ic_dialog_info);
                alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                            finish();

                    }




                });

                alert.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity, this, "Que bom que vc ficou", Toast.LENGTH_LONG.show());
                    }
                });

                alert.show();
                break;

            case R.id.mnuNext:

                EditText txtName = (EditText) findViewById(R.id.txtNome);
                Intent intent = new Intent(this, ThirdActivity.class);
                intent.putExtra("nome", txtName.getText().toString());
                startActivityForResult(intent, 1);



                break;
            case R.id.MnuAbout:
                AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
                alert2.setTitle("Sobre");
                alert2.setMessage("Mensagem do Alert!");
                alert2.setIcon(android.R.drawable.ic_dialog_alert);
                alert2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert2.show();
                break;
        }
        return true;



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){

            if (resultCode == RESULT_OK){

                Toast.makeText(
                        this,
                        data.getStringExtra("mensagem"),
                        Toast.LENGTH_LONG

                ).show();

            }

        }
    }
}
