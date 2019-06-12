package com.datin.bulker.lattas.intala;

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
import com.datin.bulker.lattas.intala.IntalaItem;

import java.util.List;


public class ListViewAdapterIntala extends ArrayAdapter<IntalaItem> {

    private List<IntalaItem> IntalaItemList;

    private Context context;

    public ListViewAdapterIntala(List<IntalaItem> IntalaItemList, Context context) {
        super(context, R.layout.lattas_intala_list_item, IntalaItemList);
        this.IntalaItemList = IntalaItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.lattas_intala_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        IntalaItem IntalaItem = IntalaItemList.get(position);

        textViewJudul.setText(IntalaItem.getJudul());
        textViewTahun.setText(IntalaItem.getCreated_at());
        textViewTanggal.setText(IntalaItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverlattas/"+IntalaItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}
