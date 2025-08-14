package com.example.customlistviewapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int layoutId;
    ArrayList<Phone> myList;

    public MyArrayAdapter(Activity context, int layoutId, ArrayList<Phone> myList) {
        super(context, layoutId, myList);
        this.context = context;
        this.layoutId = layoutId;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);

        Phone phone = myList.get(position);

        ImageView img = convertView.findViewById(R.id.imgphone);
        TextView name = convertView.findViewById(R.id.txtnamephone);
        TextView price = convertView.findViewById(R.id.txtpricephone);

        img.setImageResource(phone.getImagephone());
        name.setText(phone.getNamephone());
        price.setText(phone.getPricephone());

        return convertView;
    }
}
