package com.datin.bulker.k3;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datin.bulker.R;
import com.datin.bulker.k3.K3Item;

import java.util.List;


public class ListViewAdapterK3 extends ArrayAdapter<K3Item> {

    private List<K3Item> K3ItemList;

    private Context context;

    public ListViewAdapterK3(List<K3Item> K3ItemList, Context context) {
        super(context, R.layout.k3_list_item, K3ItemList);
        this.K3ItemList = K3ItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.k3_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        K3Item K3Item = K3ItemList.get(position);

        textViewJudul.setText(K3Item.getJudul());
        textViewTahun.setText(K3Item.getCreated_at());
        textViewTanggal.setText(K3Item.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverpenta/"+K3Item.getFile()).into(imgVIew);

        return listViewItem;
    }
}