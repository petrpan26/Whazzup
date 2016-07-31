package com.example.petrpan.whazzup;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web1 ;
    private final String[] web2;
    private final String[] web3;
    private final Integer[] imageId;
    public CustomList(Activity context,
                      String[] web1, Integer[] imageId, String[] web2,String[] web3) {
        super(context, R.layout.listsingle, web1);
        this.context = context;
        this.web1 = web1;
        this.web2 = web2;
        this.web3 = web3;
        this.imageId = imageId;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.listsingle, null, true);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.txt1);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.txt2);
        TextView txtTitle3 = (TextView) rowView.findViewById(R.id.txt3);
        txtTitle1.setText(web1[position]);
        txtTitle2.setText(web2[position]);
        txtTitle3.setText(web3[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}