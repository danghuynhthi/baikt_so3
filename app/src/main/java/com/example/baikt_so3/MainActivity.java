package com.example.baikt_so3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtname, edtpass;
    Button login, change;
    String tk =null;
    String mk =null;
    String data=null;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        loadData();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((edtname.getText().toString().equals(tk)) && (edtpass.getText().toString().equals(mk))) {
                    Toast.makeText(MainActivity.this, "đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                   startActivity(intent);

                }
                else {
                    Toast.makeText(MainActivity.this, "đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getdata();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("dulieu",data);
                startActivity(intent);

            }
        });

    }
    private void anhxa() {
        edtname = findViewById(R.id.idedtname);
        edtpass = findViewById(R.id.idedtpass);
        login = findViewById(R.id.idbuttonlogin);
        change = findViewById(R.id.idchangepass);
    }



    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("dangnhap", MODE_PRIVATE);
        tk = sharedPreferences.getString("taikhoan", "danghuynhthi");
        mk = sharedPreferences.getString("matkhau", "123456");
    }
    public void getdata() {
        SharedPreferences sharedPreferences = getSharedPreferences("dangnhap", MODE_PRIVATE);
        data =sharedPreferences.getString("matkhau", "123456");

    }
}
