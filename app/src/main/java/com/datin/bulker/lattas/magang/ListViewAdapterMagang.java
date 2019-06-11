package com.datin.bulker.lattas.magang;

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
import com.datin.bulker.lattas.magang.MagangItem;

import java.util.List;


public class ListViewAdapterMagang extends ArrayAdapter<MagangItem> {

    private List<MagangItem> MagangItemList;

    private Context context;

    public ListViewAdapterMagang(List<MagangItem> MagangItemList, Context context) {
        super(context, R.layout.lattas_magang_list_item, MagangItemList);
        this.MagangItemList = MagangItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.lattas_magang_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.Cover);


        MagangItem MagangItem = MagangItemList.get(position);

        textViewJudul.setText(MagangItem.getJudul());
        textViewTahun.setText(MagangItem.getCreated_at());
        textViewTanggal.setText(MagangItem.getTh_id());
        textViewTanggal.setText(MagangItem.getFile());
        Glide.with(context).load(MagangItem.getCover()).into(imgVIew);

        return listViewItem;
    }
}


