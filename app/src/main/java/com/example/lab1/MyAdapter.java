package com.example.lab1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Item> {
    private LayoutInflater inflater;
    private int layout;
    private List<Item> numbers;

    public MyAdapter(Context context, int resource, List<Item> numbers) {
        super(context, resource, numbers);
        this.numbers = numbers;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        ImageView flagView = view.findViewById(R.id.listImage);
        TextView nameView = view.findViewById(R.id.item_txt);
        Item number = numbers.get(position);
        flagView.setImageResource(number.getPicResource());
        nameView.setText(number.getNumber());
        (view.findViewById(R.id.l_item)).setBackgroundColor(number.getColor());


        return view;
    }
}