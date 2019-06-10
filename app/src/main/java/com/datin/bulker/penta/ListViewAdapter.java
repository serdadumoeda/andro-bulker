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


public class ListViewAdapter extends ArrayAdapter<PasarKerjaItem> {

    private List<PasarKerjaItem> playerItemList;

    private Context context;

    public ListViewAdapter(List<PasarKerjaItem> playerItemList, Context context) {
        super(context, R.layout.penta_pasar_kerja_list_item, playerItemList);
        this.playerItemList = playerItemList;
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


        PasarKerjaItem PasarKerjaItem = playerItemList.get(position);

        textViewNo.setText(PasarKerjaItem.getNo());
        textViewName.setText(PasarKerjaItem.getName());
        textViewBirth_date.setText(PasarKerjaItem.getBirth_date());
        textViewPosition.setText(PasarKerjaItem.getPosition());

        Glide.with(context).load(PasarKerjaItem.getPoster()).into(imgVIew);

        return listViewItem;
    }
}
