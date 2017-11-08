package com.example.moonc.cse_ru_3_1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ct_REminder extends AppCompatActivity {

    ListView listView;
    Button button;
    custom custom_adapter;
    ObjectCreatorForCt objectCreatorForCt;
    ArrayList<ObjectCreatorForCt> arrayList;
    String Entire_record="" ;
    SQLite_Helper sqLite_helper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct__reminder);
        showingDb();

    }

    public void showingDb() {

        listView = (ListView)findViewById(R.id.listView);

        arrayList = new ArrayList<ObjectCreatorForCt>();

        sqLite_helper = new SQLite_Helper(this);

        Cursor cursor = sqLite_helper.showData();


        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                String date = cursor.getString(0);
                String detail = cursor.getString(1);
                objectCreatorForCt = new ObjectCreatorForCt(date,detail);
                arrayList.add(objectCreatorForCt);
            }
        }else {
            Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_SHORT).show();
        }


        custom_adapter = new custom(Ct_REminder.this,arrayList);
        custom_adapter.notifyDataSetChanged();
        listView.setAdapter(custom_adapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Ct_REminder.this,MainActivity.class);
        startActivity(intent);
        //super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.add)
        {
            Intent intent = new Intent(Ct_REminder.this,CT_update.class);
            startActivity(intent);
        }
        else if(id==R.id.redresh_update_pz)
        {
            refresh();
        }

        return super.onOptionsItemSelected(item);
    }

    public void refresh() {
        Intent intent = new Intent(Ct_REminder.this,Ct_REminder.class);
        startActivity(intent);
    }

}
