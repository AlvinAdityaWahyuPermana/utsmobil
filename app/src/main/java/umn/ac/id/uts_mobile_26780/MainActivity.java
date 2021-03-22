package umn.ac.id.uts_mobile_26780;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public void pindahprofil(View view) {
        Intent i = new Intent(MainActivity.this,Bio.class);
        startActivity(i);
    }

    public void pindahlogin(View view) {
        Intent i = new Intent(MainActivity.this,login.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}