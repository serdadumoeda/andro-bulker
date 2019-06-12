package com.datin.bulker.penta;

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
import com.datin.bulker.penta.PasarKerjaItem;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter<PasarKerjaItem> {

    private List<PasarKerjaItem> PasarKerjaItemList;

    private Context context;

    public ListViewAdapter(List<PasarKerjaItem> PasarKerjaItemList, Context context) {
        super(context, R.layout.penta_pasar_kerja_list_item, PasarKerjaItemList);
        this.PasarKerjaItemList = PasarKerjaItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.penta_pasar_kerja_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        PasarKerjaItem PasarKerjaItem = PasarKerjaItemList.get(position);

        textViewJudul.setText(PasarKerjaItem.getJudul());
        textViewTahun.setText(PasarKerjaItem.getCreated_at());
        textViewTanggal.setText(PasarKerjaItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverpenta/"+PasarKerjaItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}