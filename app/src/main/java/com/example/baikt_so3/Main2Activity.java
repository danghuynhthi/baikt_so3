package com.example.baikt_so3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText matkhaucu, matkhaumoi;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        matkhaucu = findViewById(R.id.idmatkhaucu);
        matkhaumoi = findViewById(R.id.idmatkhaumoi);
        button=findViewById(R.id.idchange1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String noidung = intent.getStringExtra("dulieu");
                if ((matkhaucu.getText().toString().equals(noidung))) {
                    saveData();
                    Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(intent1);

                } else
                    Toast.makeText(Main2Activity.this, "mat khau cu sai", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("dangnhap", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("matkhau", matkhaumoi.getText().toString());
        editor.apply();

    }

}
