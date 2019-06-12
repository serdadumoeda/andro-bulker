package com.datin.bulker.lattas.bnsp;


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
import com.datin.bulker.lattas.bnsp.BnspItem;

import java.util.List;


public class ListViewAdapterBnsp extends ArrayAdapter<BnspItem> {

    private List<BnspItem> BnspItemList;

    private Context context;

    public ListViewAdapterBnsp(List<BnspItem> BnspItemList, Context context) {
        super(context, R.layout.lattas_bnsp_list_item, BnspItemList);
        this.BnspItemList = BnspItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.lattas_bnsp_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        BnspItem BnspItem = BnspItemList.get(position);

        textViewJudul.setText(BnspItem.getJudul());
        textViewTahun.setText(BnspItem.getCreated_at());
        textViewTanggal.setText(BnspItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverpenta/"+BnspItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}
