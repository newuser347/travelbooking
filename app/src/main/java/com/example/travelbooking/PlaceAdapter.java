package com.example.travelbooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends BaseAdapter {
    private ArrayList<Place> placeList;
    private LayoutInflater inflater;
    public PlaceAdapter(Context context, ArrayList<Place> placeList){
        this.placeList = placeList;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return placeList.size();
    }

    @Override
    public Object getItem(int i) {
        return placeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view ==null) {
            view = inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();
            holder.name = view.findViewById(R.id.tvplace);
            holder.price = view.findViewById(R.id.tvprice);
            holder.img = view.findViewById(R.id.imageView);
            view.setTag(holder);
        }
        else
            holder = (ViewHolder) view.getTag();

        holder.name.setText(placeList.get(i).getpName());
        holder.price.setText(String.valueOf(placeList.get(i).getpPrice()));
        int imgID = view.getResources().getIdentifier(placeList.get(i).getpImage(),"mipmap",inflater.getContext().getPackageName());
        holder.img.setImageResource(imgID);

        return view;

    }
    static class ViewHolder{
        //create attributes according to the objects in the list_row XML file
        private TextView name;
        private TextView price;
        private ImageView img;
    }
}
