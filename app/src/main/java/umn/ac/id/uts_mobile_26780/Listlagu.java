package umn.ac.id.uts_mobile_26780;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Listlagu extends AppCompatActivity {

    private ArrayList<Lagu> laguList;
    private RecyclerView rvLagu;
    private static final String TAG = "Listlagu";
    private android.app.AlertDialog.Builder alertDialogBuilder;

    public void pindahlagu(View view) {
        Intent i = new Intent(Listlagu.this,PlayerMusic.class);
        startActivity(i);
    }
    public void pindahlagu2(View view) {
        Intent i = new Intent(Listlagu.this,PlayerMusic2.class);
        startActivity(i);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listlagu);


        showStartDialog();
        init();
        generateData();
        setData();
    }




    private void showStartDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Selamat Datang")
                .setMessage("Alvin Aditya.\n00000026780")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();
    }



    private void init() {
        laguList = new ArrayList<>();
        rvLagu = findViewById(R.id.rv_lagu);
    }


    private void generateData() {
        laguList.add(new Lagu("Lovesick Girl","3.22"));
        laguList.add(new Lagu("The Lazy Song","3.20"));
        laguList.add(new Lagu("Love Me Harder","4.11"));
    }

    private void setData() {
        rvLagu.setLayoutManager(new LinearLayoutManager(this));
        rvLagu.setAdapter(new LaguAdapter(this, laguList));
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            startActivity(new Intent(this, Bio.class));
        } else if (item.getItemId() == R.id.setting) {
            startActivity(new Intent(this, MainActivity.class));
        }

        return true;
    }





}



