package com.example.demo_AppDocBao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.model.Item;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    private Context context;
    private String link;
    private List<Item> list;
    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;

    public MyAsyncTask(Context context, String link, RecyclerView recyclerView) {
        this.context = context;
        this.link = link;
        this.recyclerView = recyclerView;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        try{
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            // doc
            InputStream is = connection.getInputStream();
            list = MySaxParser.xmlParser(is);
        }catch (Exception e){

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        adapter = new RecycleViewAdapter(context, list);
        LinearLayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
