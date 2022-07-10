package com.example.demo_AppDocBao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.demo.R;
import com.example.demo_AppDocBao.MyAsyncTask;

//Thom
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        String link = "https://vnexpress.net/rss/suc-khoe.rss";
        MyAsyncTask myAsyncTask = new MyAsyncTask(MainActivity.this, link, recyclerView);
        myAsyncTask.execute();
    }
}