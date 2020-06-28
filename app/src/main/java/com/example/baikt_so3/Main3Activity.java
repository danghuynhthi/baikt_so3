package com.example.baikt_so3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
Spinner spinner;
EditText noidung;
Button button;
TextView textView;
String chuoi;
    String data=null;
    String datasave=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        spinner=findViewById(R.id.idspiner);
        noidung=findViewById(R.id.idnoidung);
        button=findViewById(R.id.idgui);
        textView=findViewById(R.id.idtxtnoidung);
        final ArrayList<String>arrayList=new ArrayList<String>();
        arrayList.add("khoa DIEN DIEN TU");
        arrayList.add("Phong dao tao");
        arrayList.add("TS VA CTTS");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,arrayList);
        spinner.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
                 data=datasave+noidung.getText().toString()+"___"+spinner.getSelectedItem().toString();
               textView.append(data);
               saveData();

            }
        });
    }
    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       if (item.getItemId()==R.id.idout)
       {
           Intent intent1 = new Intent(Main3Activity.this, MainActivity.class);
           startActivity(intent1);
       }
           return super.onOptionsItemSelected(item);
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("dangnhap", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("luudata", data);
        editor.apply();

    }
    public void getdata() {
        SharedPreferences sharedPreferences = getSharedPreferences("dangnhap", MODE_PRIVATE);
        datasave =sharedPreferences.getString("luudata", "");

    }
}
