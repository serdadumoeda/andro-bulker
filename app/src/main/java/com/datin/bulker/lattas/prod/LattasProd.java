package com.datin.bulker.lattas.prod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.datin.bulker.R;
import com.datin.bulker.lattas.prod.DetailProd;
import com.datin.bulker.lattas.prod.ProdItem;
import com.datin.bulker.lattas.prod.ListViewAdapterProd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LattasProd extends AppCompatActivity {
    private static final String JSON_URL = "https://buletinnaker.kemnaker.go.id/api/produktivitas";
    ListView listView;
    private List<ProdItem> ProdItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lattas_prod);

        listView =  findViewById(R.id.listView);
        ProdItemList = new ArrayList<>();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                ProdItem ProdItem = ProdItemList.get(position);

                Intent i = new Intent(getApplicationContext(), DetailProd.class);
                i.putExtra(DetailProd.EXTRA_PLAYER, ProdItem);
                startActivity(i);


            }
        });
        loadPlayer();
    }


    private void loadPlayer() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray playerArray = obj.getJSONArray("lattas");

                            for (int i = 0; i < playerArray.length(); i++) {

                                JSONObject playerObject = playerArray.getJSONObject(i);


                                ProdItem ProdItem = new ProdItem(
                                        playerObject.getString("judul"),
                                        playerObject.getString("deskripsi"),
                                        playerObject.getString("th_id"),
                                        playerObject.getString("created_at"),
                                        playerObject.getString("file"),
                                        playerObject.getString("cover"));

                                ProdItemList.add(ProdItem);
                            }

                            ListViewAdapterProd adapter = new ListViewAdapterProd(ProdItemList, getApplicationContext());

                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}



