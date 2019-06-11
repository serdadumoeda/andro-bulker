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
import com.datin.bulker.penta.TenagaKerjaAsingItem;
import com.datin.bulker.penta.TenagaKerjaAsingItem;

import java.util.List;


public class ListViewAdapterTka extends ArrayAdapter<TenagaKerjaAsingItem> {

    private List<TenagaKerjaAsingItem> TenagaKerjaAsingItemList;

    private Context context;

    public ListViewAdapterTka(List<TenagaKerjaAsingItem> TenagaKerjaAsingItemList, Context context) {
        super(context, R.layout.penta_tenaga_kerja_asing_list_item, TenagaKerjaAsingItemList);
        this.TenagaKerjaAsingItemList = TenagaKerjaAsingItemList;
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


        TenagaKerjaAsingItem TenagaKerjaAsingItem = TenagaKerjaAsingItemList.get(position);

        textViewJudul.setText(TenagaKerjaAsingItem.getJudul());
        textViewTahun.setText(TenagaKerjaAsingItem.getCreated_at());
        textViewTanggal.setText(TenagaKerjaAsingItem.getTh_id());
        textViewTanggal.setText(TenagaKerjaAsingItem.getFile());
        Glide.with(context).load(TenagaKerjaAsingItem.getCover()).into(imgVIew);

        return listViewItem;
    }
}