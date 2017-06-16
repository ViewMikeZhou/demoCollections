package com.zhou.androidDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Myadatper.OnItemClick {

    private Myadatper mAdapter;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyview = (RecyclerView) findViewById(R.id.recyview);
        recyview.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList();
        mList.add("第一个demo");
        mAdapter = new Myadatper(mList);
        mAdapter.setOnItemClick(this);
        recyview.setAdapter(mAdapter);
}

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    public void click(int positon) {
        Toast.makeText(this,"position" +positon,Toast.LENGTH_SHORT).show();
    }
}
