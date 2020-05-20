package com.example.lab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView countriesList;
    private List<Item> numbers = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        setInitialData();
        countriesList = findViewById(R.id.countriesList);
        MyAdapter mAdapter = new MyAdapter(this, R.layout.list_item, numbers);
        countriesList.setAdapter(mAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Item selectedNumber = (Item) parent.getItemAtPosition(position);
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }

    private void setInitialData() {
        for (int i = 1; i <= 1000000; i++) {
            if (i % 2 == 0) {
                numbers.add(new Item(NumberToWord.fromIntToString(i), R.drawable.catt, 0xFFCCCCCC));
            } else {
                numbers.add(new Item(NumberToWord.fromIntToString(i), R.drawable.catt, 0xFFFFFFFF));
            }
        }
    }
}