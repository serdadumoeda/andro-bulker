package com.datin.bulker.hi;

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
import com.datin.bulker.hi.HiItem;

import java.util.List;


public class ListViewAdapterHi extends ArrayAdapter<HiItem> {

    private List<HiItem> HiItemList;

    private Context context;

    public ListViewAdapterHi(List<HiItem> HiItemList, Context context) {
        super(context, R.layout.hi_list_item, HiItemList);
        this.HiItemList = HiItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.hi_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        HiItem HiItem = HiItemList.get(position);

        textViewJudul.setText(HiItem.getJudul());
        textViewTahun.setText(HiItem.getCreated_at());
        textViewTanggal.setText(HiItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverpenta/"+HiItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}