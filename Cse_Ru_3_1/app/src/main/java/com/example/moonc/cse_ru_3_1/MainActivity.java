package com.example.moonc.cse_ru_3_1;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int position = -1;
    Sql_helper_for_routin sql_helper_for_routine;
    Sql_helper_for_notifications sql_helper_for_notifications;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        sql_helper_for_routine = new Sql_helper_for_routin(this);
        sql_helper_for_routine.CreatingTable();

        // boolean result = CheckTheFolder();


        //Check for Notifications
       // notifications();

        Calendar calendar = Calendar.getInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        int date = calendar.get(Calendar.DAY_OF_WEEK);
        switch (date){
            case 7:
                Saturday saturday = new Saturday();
                position = 7;
                fragmentManager.beginTransaction().replace(R.id.content_main,new Saturday()).commit();
                break;
            case 1:
                Sunday sunday = new Sunday();
                position = 1;
                fragmentManager.beginTransaction().replace(R.id.content_main,new Sunday()).commit();
                break;
            case 2:
                Monday monday = new Monday();
                position = 2;
                fragmentManager.beginTransaction().replace(R.id.content_main,new Monday()).commit();
                break;
            case 3:
                Tuesday tuesday = new Tuesday();
                position = 3;
                fragmentManager.beginTransaction().replace(R.id.content_main,new Tuesday()).commit();
                break;
            case 4:
                Wednesday wednesday = new Wednesday();
                position = 4;
                fragmentManager.beginTransaction().replace(R.id.content_main,new Wednesday()).commit();
                break;
            case 5:
                Thursday thursday = new Thursday();
                 position = 5;
                fragmentManager.beginTransaction().replace(R.id.content_main,new Thursday()).commit();
                break;
            case 6:
                Friday friday = new Friday();
                 position = 6;
                fragmentManager.beginTransaction().replace(R.id.content_main,new Friday()).commit();
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//    private void notifications() {
//
//        if(isNetWorkAvailable()) {
//
//           // sql_helper_for_notifications.drop();
//
//            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//            DatabaseReference databaseReference = firebaseDatabase.getReference().child("Notifications");
//            databaseReference.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                   // int count = 0;
//                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();
//                    for (DataSnapshot child : children) {
//
//                        String val1 = "";
//                        String title = "";
//                        String message = "";
//                        val1 = child.getValue().toString();
//                        int x = 0;
//                        for (int j = 0; j < val1.length(); j++) {
//                            if (val1.charAt(j) != '@') {
//                                if (x == 0) {
//                                    title += val1.charAt(j);
//                                } else
//                                    message += val1.charAt(j);
//                            } else
//                                x = 1;
//                        }
//                        sql_helper_for_notifications.add(title,message);
//                       // boolean b  = sql_helper_for_notifications.check(title,message);
////                        if(b)
////                        {
////                            count++;
////                        }
//                    }
//                    //if(count>0)
//                    Toast.makeText(getApplicationContext(),"Check Notifications",Toast.LENGTH_SHORT).show();
//
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//        }else
//            Toast.makeText(getApplicationContext(),"Check Internet Connection",Toast.LENGTH_SHORT).show();
//    }

    private void tableCreation() {


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            /// exit the program ...
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("CLose Routine");
            builder.setMessage("Want to close routine.");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.create();
            builder.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this,Edit_Data.class);

            if(position != 7 || position != 6) {

                if(position == 1)
                {
                    intent.putExtra("filename", "Sunday");
                    startActivity(intent);
                }
                if(position == 2)
                {
                    intent.putExtra("filename", "Monday");
                    startActivity(intent);
                }
                if(position == 3) {

                    intent.putExtra("filename", "Tuesday");
                    startActivity(intent);
                }

                if(position == 4) {
                    intent.putExtra("filename", "Wednesday");
                    startActivity(intent);
                }

                if(position == 5) {
                    intent.putExtra("filename", "Thursday");
                    startActivity(intent);
                }

            }else {

                Toast.makeText(getApplicationContext(),"Can't edit routine",Toast.LENGTH_SHORT).show();
            }

            return true;
        }else if(id == R.id.refresh)
        {
            switch (position){
                case 7:
                    Saturday saturday = new Saturday();
                    position = 7;
                    fragmentManager.beginTransaction().replace(R.id.content_main,new Saturday()).commit();
                    break;
                case 1:
                    Sunday sunday = new Sunday();
                    position = 1;
                    fragmentManager.beginTransaction().replace(R.id.content_main,new Sunday()).commit();
                    break;
                case 2:
                    Monday monday = new Monday();
                    position = 2;
                    fragmentManager.beginTransaction().replace(R.id.content_main,new Monday()).commit();
                    break;
                case 3:
                    Tuesday tuesday = new Tuesday();
                    position = 3;
                    fragmentManager.beginTransaction().replace(R.id.content_main,new Tuesday()).commit();
                    break;
                case 4:
                    Wednesday wednesday = new Wednesday();
                    position = 4;
                    fragmentManager.beginTransaction().replace(R.id.content_main,new Wednesday()).commit();
                    break;
                case 5:
                    Thursday thursday = new Thursday();
                    position = 5;
                    fragmentManager.beginTransaction().replace(R.id.content_main,new Thursday()).commit();
                    break;
                case 6:
                    Friday friday = new Friday();
                    position = 6;
                    fragmentManager.beginTransaction().replace(R.id.content_main,new Friday()).commit();
                    break;

            }
            Toast.makeText(getApplicationContext(),"Refreshed",Toast.LENGTH_SHORT).show();
        }

        else if(id==R.id.update)
        {

           boolean res =  isNetWorkAvailable();
            if(res) {


                sql_helper_for_routine.drop("Sunday");
                sql_helper_for_routine.drop("Monday");
                sql_helper_for_routine.drop("Tuesday");
                sql_helper_for_routine.drop("Wednesday");
                sql_helper_for_routine.drop("Thursday");

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference Sun_data = firebaseDatabase.getReference().child("Sunday");
                Sun_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child : children) {

                            String val1 = "";
                            String time = "";
                            String class_ = "";
                            val1 = child.getValue().toString();
                            int x = 0;
                            for (int j = 0; j < val1.length(); j++) {
                                if (val1.charAt(j) != '@') {
                                    if (x == 0) {
                                        time += val1.charAt(j);
                                    } else
                                        class_ += val1.charAt(j);
                                } else
                                    x = 1;
                            }

                            sql_helper_for_routine.add(time, class_, "Sunday");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                DatabaseReference Mon_data = firebaseDatabase.getReference().child("Monday");
                Mon_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child : children) {

                            String val1 = "";
                            String time = "";
                            String class_ = "";
                            val1 = child.getValue().toString();
                            int x = 0;
                            for (int j = 0; j < val1.length(); j++) {
                                if (val1.charAt(j) != '@') {
                                    if (x == 0) {
                                        time += val1.charAt(j);
                                    } else
                                        class_ += val1.charAt(j);
                                } else
                                    x = 1;
                            }

                            sql_helper_for_routine.add(time, class_, "Monday");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                DatabaseReference Tue_data = firebaseDatabase.getReference().child("Tuesday");
                Tue_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child : children) {

                            String val1 = "";
                            String time = "";
                            String class_ = "";
                            val1 = child.getValue().toString();
                            int x = 0;
                            for (int j = 0; j < val1.length(); j++) {
                                if (val1.charAt(j) != '@') {
                                    if (x == 0) {
                                        time += val1.charAt(j);
                                    } else
                                        class_ += val1.charAt(j);
                                } else
                                    x = 1;
                            }

                            sql_helper_for_routine.add(time, class_, "Tuesday");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                DatabaseReference Wed_data = firebaseDatabase.getReference().child("Wednesday");
                Wed_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child : children) {

                            String val1 = "";
                            String time = "";
                            String class_ = "";
                            val1 = child.getValue().toString();
                            int x = 0;
                            for (int j = 0; j < val1.length(); j++) {
                                if (val1.charAt(j) != '@') {
                                    if (x == 0) {
                                        time += val1.charAt(j);
                                    } else
                                        class_ += val1.charAt(j);
                                } else
                                    x = 1;
                            }

                            sql_helper_for_routine.add(time, class_, "Wednesday");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                DatabaseReference Thu_data = firebaseDatabase.getReference().child("Thursday");
                Thu_data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child : children) {

                            String val1 = "";
                            String time = "";
                            String class_ = "";
                            val1 = child.getValue().toString();
                            int x = 0;
                            for (int j = 0; j < val1.length(); j++) {
                                if (val1.charAt(j) != '@') {
                                    if (x == 0) {
                                        time += val1.charAt(j);
                                    } else
                                        class_ += val1.charAt(j);
                                } else
                                    x = 1;
                            }

                            sql_helper_for_routine.add(time, class_, "Thursday");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();

            }else
                Toast.makeText(getApplicationContext(),"Check Internet Connection",Toast.LENGTH_SHORT).show();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (id == R.id.saturday) {
            fragmentManager.beginTransaction().replace(R.id.content_main,new Saturday()).commit();
            position = 7;


        } else if (id == R.id.sunday) {
            fragmentManager.beginTransaction().replace(R.id.content_main,new Sunday()).commit();
            position = 1;



        } else if (id == R.id.monday) {
            fragmentManager.beginTransaction().replace(R.id.content_main,new Monday()).commit();
            position = 2;


        } else if (id == R.id.tuesday) {
            fragmentManager.beginTransaction().replace(R.id.content_main,new Tuesday()).commit();
            position = 3;


        } else if (id == R.id.wednesday) {

            fragmentManager.beginTransaction().replace(R.id.content_main,new Wednesday()).commit();
            position = 4;


        } else if (id == R.id.thursday) {

            fragmentManager.beginTransaction().replace(R.id.content_main,new Thursday()).commit();
             position = 5;


        }

        else if (id == R.id.friday) {

            fragmentManager.beginTransaction().replace(R.id.content_main,new Friday()).commit();
             position = 6;


        }

        else if (id == R.id.ct_reminder)
           {
               Intent intent = new Intent(MainActivity.this,Ct_REminder.class);
               startActivity(intent);
           }
        else if(id==R.id.notificatin)
        {
            Intent intent = new Intent(MainActivity.this,NotiActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
