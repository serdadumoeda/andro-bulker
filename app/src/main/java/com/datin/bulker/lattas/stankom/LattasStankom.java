package com.datin.bulker.lattas.stankom;

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
import com.datin.bulker.lattas.stankom.DetailStankom;
import com.datin.bulker.lattas.stankom.StankomItem;
import com.datin.bulker.lattas.stankom.ListViewAdapterStankom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LattasStankom extends AppCompatActivity {
    private static final String JSON_URL = "https://buletinnaker.kemnaker.go.id/api/stankom";
    ListView listView;
    private List<StankomItem> StankomItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lattas_stankom);

        listView =  findViewById(R.id.listView);
        StankomItemList = new ArrayList<>();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                StankomItem StankomItem = StankomItemList.get(position);

                Intent i = new Intent(getApplicationContext(), DetailStankom.class);
                i.putExtra(DetailStankom.EXTRA_PLAYER, StankomItem);
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


                                StankomItem StankomItem = new StankomItem(
                                        playerObject.getString("judul"),
                                        playerObject.getString("deskripsi"),
                                        playerObject.getString("th_id"),
                                        playerObject.getString("created_at"),
                                        playerObject.getString("file"),
                                        playerObject.getString("cover"));

                                StankomItemList.add(StankomItem);
                            }

                            ListViewAdapterStankom adapter = new ListViewAdapterStankom(StankomItemList, getApplicationContext());

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




