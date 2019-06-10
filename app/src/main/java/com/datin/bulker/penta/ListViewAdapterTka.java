package com.datin.bulker.penta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.datin.bulker.R;

import java.util.List;


public class ListViewAdapterTka extends ArrayAdapter<TenagaKerjaAsingItem> {

    private List<TenagaKerjaAsingItem> TenagaKerjaAsingItemList;

    private Context context;

    public ListViewAdapterTka(List<TenagaKerjaAsingItem> TenagaKerjaAsingItemList, Context context) {
        super(context, R.layout.penta_pasar_kerja_list_item, TenagaKerjaAsingItemList);
        this.TenagaKerjaAsingItemList = TenagaKerjaAsingItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.penta_pasar_kerja_list_item, null, true);

        TextView textViewNo = listViewItem.findViewById(R.id.textViewNo);
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewPosition = listViewItem.findViewById(R.id.textViewPosition);
        TextView textViewBirth_date = listViewItem.findViewById(R.id.textViewBirthDate);
        ImageView imgVIew = listViewItem.findViewById(R.id.Poster);


        TenagaKerjaAsingItem TenagaKerjaAsingItem = TenagaKerjaAsingItemList.get(position);

        textViewNo.setText(TenagaKerjaAsingItem.getNo());
        textViewName.setText(TenagaKerjaAsingItem.getName());
        textViewBirth_date.setText(TenagaKerjaAsingItem.getBirth_date());
        textViewPosition.setText(TenagaKerjaAsingItem.getPosition());

        Glide.with(context).load(TenagaKerjaAsingItem.getPoster()).into(imgVIew);

        return listViewItem;
    }
}