package com.datin.bulker.lattas.prod;

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
import com.datin.bulker.lattas.prod.ProdItem;

import java.util.List;


public class ListViewAdapterProd extends ArrayAdapter<ProdItem> {

    private List<ProdItem> ProdItemList;

    private Context context;

    public ListViewAdapterProd(List<ProdItem> ProdItemList, Context context) {
        super(context, R.layout.lattas_prod_list_item, ProdItemList);
        this.ProdItemList = ProdItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.lattas_prod_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        ProdItem ProdItem = ProdItemList.get(position);

        textViewJudul.setText(ProdItem.getJudul());
        textViewTahun.setText(ProdItem.getCreated_at());
        textViewTanggal.setText(ProdItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverlattas/"+ProdItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}

