package com.datin.bulker.ku;

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
import com.datin.bulker.ku.KuItem;

import java.util.List;


public class ListViewAdapterKu extends ArrayAdapter<KuItem> {

    private List<KuItem> KuItemList;

    private Context context;

    public ListViewAdapterKu(List<KuItem> KuItemList, Context context) {
        super(context, R.layout.ku_list_item, KuItemList);
        this.KuItemList = KuItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.ku_list_item, null, true);

        TextView textViewJudul = listViewItem.findViewById(R.id.textViewJudul);
        TextView textViewTahun = listViewItem.findViewById(R.id.textViewTahun);
        TextView textViewTanggal = listViewItem.findViewById(R.id.textViewTanggal);
        ImageView imgVIew = listViewItem.findViewById(R.id.imgVIew);


        KuItem KuItem = KuItemList.get(position);

        textViewJudul.setText(KuItem.getJudul());
        textViewTahun.setText(KuItem.getCreated_at());
        textViewTanggal.setText(KuItem.getTh_id());
        Glide.with(context).load("https://buletinnaker.kemnaker.go.id/storage/coverpenta/"+KuItem.getFile()).into(imgVIew);

        return listViewItem;
    }
}