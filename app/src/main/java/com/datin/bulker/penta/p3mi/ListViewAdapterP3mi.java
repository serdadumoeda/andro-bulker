package com.datin.bulker.penta.p3mi;

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
import com.datin.bulker.penta.p3mi.P3miItem;
import com.datin.bulker.penta.p3mi.P3miItem;

import java.util.List;


public class ListViewAdapterP3mi extends ArrayAdapter<P3miItem> {

    private List<P3miItem> P3miItemList;

    private Context context;

    public ListViewAdapterP3mi(List<P3miItem> P3miItemList, Context context) {
        super(context, R.layout.activity_penta_p3mi_list_item, P3miItemList);
        this.P3miItemList = P3miItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.activity_penta_p3mi_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        P3miItem P3miItem = P3miItemList.get(position);

        textViewJudul.setText(P3miItem.getJudul());
        textViewTahun.setText(P3miItem.getCreated_at());
        textViewTanggal.setText(P3miItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverpenta/"+P3miItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}