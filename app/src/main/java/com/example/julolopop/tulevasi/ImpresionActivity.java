package com.example.julolopop.tulevasi;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.julolopop.tulevasi.adapter.PedidosAdapter;
import com.example.julolopop.tulevasi.pojo.Ticked;

import java.util.ArrayList;
import java.util.Collection;

public class ImpresionActivity extends AppCompatActivity {

    ListView listView;
    PedidosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresion);
        listView = findViewById(android.R.id.list);
        adapter = new PedidosAdapter(this);




        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            ArrayList<Ticked> tickeds =  bundle.getParcelableArrayList("impresion");
            adapter.addAll(tickeds);
        }

        listView.setAdapter(adapter);
    }
}
