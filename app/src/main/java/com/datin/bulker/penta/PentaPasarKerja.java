package com.datin.bulker.penta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.datin.bulker.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PentaPasarKerja extends AppCompatActivity {
    private static final String JSON_URL = "https://azharsaepudin.github.io/FootBallPlayer/AllPlayer.json";


    ListView listView;
    private List<PasarKerjaItem> playerItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penta_pasar_kerja);

        listView =  findViewById(R.id.listView);
    }


    private void loadPlayer() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray playerArray = obj.getJSONArray("result");

                            for (int i = 0; i < playerArray.length(); i++) {

                                JSONObject playerObject = playerArray.getJSONObject(i);


                                PasarKerjaItem playerItem = new PasarKerjaItem(playerObject.getString("no"),
                                        playerObject.getString("name"),
                                        playerObject.getString("Position"),
                                        playerObject.getString("birth_date"),
                                        playerObject.getString("Poster"));

                                playerItemList.add(playerItem);
                            }

                            ListViewAdapter adapter = new ListViewAdapter(playerItemList, getApplicationContext());

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
