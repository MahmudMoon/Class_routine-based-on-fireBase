package com.example.moonc.cse_ru_3_1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotiActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ObjectCreatorForNotifications> arrayList;
    Custom_Notification custom_notifications;
    Sql_helper_for_notifications sql_helper_for_notifications ;
    ObjectCreatorForNotifications object_creator_for_notifications;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);
        listView = (ListView)findViewById(R.id.list);
        arrayList = new ArrayList<ObjectCreatorForNotifications>();
        sql_helper_for_notifications = new Sql_helper_for_notifications(this);



        Cursor cursor = sql_helper_for_notifications.showData();
        if(cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                String title = cursor.getString(0);
                String message = cursor.getString(1);
                object_creator_for_notifications = new ObjectCreatorForNotifications(title,message);
                arrayList.add(object_creator_for_notifications);
            }
        }



        custom_notifications = new Custom_Notification(NotiActivity.this,arrayList);
        listView.setAdapter(custom_notifications);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu1) {
        getMenuInflater().inflate(R.menu.menu_notifications,menu1);
        return super.onCreateOptionsMenu(menu1);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NotiActivity.this,MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.noti)
        {
            if(isNetWorkAvailable()) {



                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference().child("Notifications");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        sql_helper_for_notifications.drop();
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child : children) {

                            String val1 = "";
                            String title = "";
                            String message = "";
                            val1 = child.getValue().toString();
                            int x = 0;
                            for (int j = 0; j < val1.length(); j++) {
                                if (val1.charAt(j) != '@') {
                                    if (x == 0) {
                                        title += val1.charAt(j);
                                    } else
                                        message += val1.charAt(j);
                                } else
                                    x = 1;
                            }

                            sql_helper_for_notifications.add(title, message);
                        }
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(NotiActivity.this,NotiActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }else
                Toast.makeText(getApplicationContext(),"Check Internet Connection",Toast.LENGTH_SHORT).show();
        }

        else if(id==R.id.refresh_notification)
        {
            Intent intent = new Intent(NotiActivity.this,NotiActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


    private boolean isNetWorkAvailable() {

        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }



}
