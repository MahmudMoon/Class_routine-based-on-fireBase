package com.example.moonc.cse_ru_3_1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Edit_Data extends AppCompatActivity {


    Sql_helper_for_routin sql_helper_for_routin ;

    EditText et_1,et_2,et_3,et_4,et_5;
    EditText ec_1,ec_2,ec_3,ec_4,ec_5;


    String str_time;
    String str_class;
    String FileName = "";

    ObjectCreator objectCreator ;

    String[] Time_ = new String[100];
    String[] Class_ = new String[100];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__data);

        Intent intent = getIntent();
       FileName  = intent.getStringExtra("filename");
         setTitle(FileName);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        et_1 = (EditText)findViewById(R.id.at_class_time);
        et_2 = (EditText)findViewById(R.id.bt_class_time);
        et_3 = (EditText)findViewById(R.id.ct_class_time);
        et_4 = (EditText)findViewById(R.id.dt_class_time);
        et_5 = (EditText)findViewById(R.id.et_class_time);



        ec_1 = (EditText)findViewById(R.id.ast_class);
        ec_2 = (EditText)findViewById(R.id.bst_class);
        ec_3 = (EditText)findViewById(R.id.cst_class);
        ec_4 = (EditText)findViewById(R.id.dst_class);
        ec_5 = (EditText)findViewById(R.id.est_class);

       showMessage();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
          getMenuInflater().inflate(R.menu.menu_edit_data,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.save_data)
        {
            saved();
        }

        return super.onOptionsItemSelected(item);
    }

    /////////// to display the current routine
    private void showMessage() {

        int i = 0;
        sql_helper_for_routin = new Sql_helper_for_routin(this);

        Cursor cursor = sql_helper_for_routin.show(FileName);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext())

            {
                Time_[i] = cursor.getString(0);
                Class_[i] = cursor.getString(1);
                i++;

            }
        }


        for (int j = 0; j < Time_.length; j++) {
            String time = Time_[j];
            String class_name = Class_[j];

            switch (j) {
                case 0: {
                    et_1.setText(time);
                    ec_1.setText(class_name);
                    break;
                }
                case 1: {
                    et_2.setText(time);
                    ec_2.setText(class_name);
                    break;
                }
                case 2: {
                    et_3.setText(time);
                    ec_3.setText(class_name);
                    break;
                }
                case 3: {
                    et_4.setText(time);
                    ec_4.setText(class_name);
                    break;
                }
                case 4: {
                    et_5.setText(time);
                    ec_5.setText(class_name);
                    break;
                }
                default:
                    break;

            }


        }
    }



    /////save the routune

    public void saved() {
        sql_helper_for_routin = new Sql_helper_for_routin(this);
        sql_helper_for_routin.drop(FileName);

        String ast_detail = et_1.getText().toString();
        String ast_class = ec_1.getText().toString();
        if(!ast_detail.equals("Time") && !ast_class.equals("Class") && !ast_class.isEmpty() && !ast_detail.isEmpty())
                   sql_helper_for_routin.add(ast_detail, ast_class,FileName);

        String bst_detail = et_2.getText().toString();
        String bst_class = ec_2.getText().toString();
        if(!bst_detail.equals("Time") && !bst_class.equals("Class") && !bst_class.isEmpty() && !bst_detail.isEmpty())
                  sql_helper_for_routin.add(bst_detail, bst_class,FileName);

        String cst_detail = et_3.getText().toString();
        String cst_class = ec_3.getText().toString();
        if(!cst_detail.equals("Time") && !cst_class.equals("Class") && !cst_class.isEmpty() && !cst_detail.isEmpty())
                 sql_helper_for_routin.add(cst_detail, cst_class,FileName);

        String dst_detail = et_4.getText().toString();
        String dst_class = ec_4.getText().toString();
        if(!dst_detail.equals("Time") && !dst_class.equals("Class") && !dst_class.isEmpty() && !dst_detail.isEmpty())
                   sql_helper_for_routin.add(dst_detail, dst_class,FileName);

        String est_detail = et_5.getText().toString();
        String est_class = ec_5.getText().toString();
        if(!est_detail.equals("Time") && !est_class.equals("Class") && !est_class.isEmpty() && !est_detail.isEmpty())
                  sql_helper_for_routin.add(est_detail, est_class,FileName);

        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
    }

}
