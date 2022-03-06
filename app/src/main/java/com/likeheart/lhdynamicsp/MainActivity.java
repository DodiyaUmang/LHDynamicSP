package com.likeheart.lhdynamicsp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CheckBox cb_like,cb_heart;
    Button btn_add,btn_data;
    RecyclerView recyclerView;
    myAdapter adapter;
    ArrayList<DataModel> list = new ArrayList<DataModel>();
    boolean like,heart;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        cb_heart = findViewById(R.id.cb_heart);
        cb_like = findViewById(R.id.cb_like);
        btn_add = findViewById(R.id.btn_add);
        btn_data = findViewById(R.id.btn_data);
        recyclerView = findViewById(R.id.recyclerView);

        cb_heart.setChecked(true);
        cb_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_heart.isChecked()){
                    cb_heart.setChecked(true);
                    cb_like.setChecked(false);
                } else {
                    cb_heart.setChecked(false);
                    cb_like.setChecked(true);
                }
            }
        });

        cb_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_like.isChecked()){
                    cb_like.setChecked(true);
                    cb_heart.setChecked(false);
                } else {
                    cb_like.setChecked(false);
                    cb_heart.setChecked(true);
                }
            }
        });


        adapter = new myAdapter(list,this,2);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

   /*     cb_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=i+1;

                like = cb_like.isChecked();
                heart = cb_heart.isChecked();

                DataModel mLog = new DataModel();
                mLog.setCb_like(like);
                mLog.setCb_heart(heart);
                mLog.setId(String.valueOf(i));
                list.add(mLog);
                saveData();

                adapter = new myAdapter(list,MainActivity.this,2);
                recyclerView.setAdapter(adapter);
            }
        });

        btn_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,allData.class);
                startActivity(i);
            }
        });
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString("courses", json);
        editor.apply();
        Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("courses", null);
        Type type = new TypeToken<ArrayList<DataModel>>() {}.getType();
        list = gson.fromJson(json, type);
        if (list == null) {
            list = new ArrayList<>();
        }
    }
}