package com.datin.bulker.penta.ptkdn;

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
import com.datin.bulker.penta.ptkdn.PtkdnItem;
import com.datin.bulker.penta.ptkdn.PtkdnItem;

import java.util.List;


public class ListViewAdapterPtkdn extends ArrayAdapter<PtkdnItem> {

    private List<PtkdnItem> PtkdnItemList;

    private Context context;

    public ListViewAdapterPtkdn(List<PtkdnItem> PtkdnItemList, Context context) {
        super(context, R.layout.penta_tenaga_kerja_asing_list_item, PtkdnItemList);
        this.PtkdnItemList = PtkdnItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.penta_tenaga_kerja_asing_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.Cover);


        PtkdnItem PtkdnItem = PtkdnItemList.get(position);

        textViewJudul.setText(PtkdnItem.getJudul());
        textViewTahun.setText(PtkdnItem.getCreated_at());
        textViewTanggal.setText(PtkdnItem.getTh_id());
        textViewTanggal.setText(PtkdnItem.getFile());
        Glide.with(context).load(PtkdnItem.getCover()).into(imgVIew);

        return listViewItem;
    }
}