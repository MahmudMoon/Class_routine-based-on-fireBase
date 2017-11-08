package com.example.moonc.cse_ru_3_1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class CT_update extends AppCompatActivity {

    Button button_update;
    EditText ct_xm;
    String time_;
    String xm_;
    ObjectCreatorForCt objectCreatorForCt;
    String Warning = "";
    //DatePicker datePicker;
    String DATE ;
    Button button;
    int Dial_id = 0;
    int year_,month_,day_;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_update);
        ct_xm = (EditText)findViewById(R.id.edit_ct);
        button = (Button)findViewById(R.id.edit_ct_time);


        Calendar calendar = Calendar.getInstance();
          day_  = calendar.get(Calendar.DAY_OF_MONTH);
         month_  = calendar.get(Calendar.MONTH);
         year_  = calendar.get(Calendar.YEAR);

    }

    public void clicked(View view)
    {

        showDialog(Dial_id);

    }


    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==Dial_id)
        {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,datePickerlistener,year_,month_,day_);
            return datePickerDialog;
        }else
        return null;
    }


     DatePickerDialog.OnDateSetListener datePickerlistener = new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
             day_ = dayOfMonth;
             month_ = month;
             year_ = year;

             DATE = Integer.toString(dayOfMonth)+"/"+ Integer.toString(month_)+"/"+Integer.toString(year);
             button.setText(DATE);
         }
     };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.save)
        {


            time_ = DATE;
            xm_ = ct_xm.getText().toString();

            if(!time_.isEmpty() && !xm_.isEmpty()) {

                   SQLite_Helper sqLite_helper = new SQLite_Helper(this);
                  boolean result =  sqLite_helper.add(time_,xm_);
                  if(result){
                      Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(CT_update.this, Ct_REminder.class);
                      startActivity(intent);
                  }else {
                      Toast.makeText(getApplicationContext(),"Not saved",Toast.LENGTH_SHORT).show();
                  }
            }else
            {
                Toast.makeText(getApplicationContext(),"Insert date and xm",Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }


    public void Helper()
    {
        Intent intent = new Intent(CT_update.this,Ct_REminder.class);
        startActivity(intent);
    }
}
