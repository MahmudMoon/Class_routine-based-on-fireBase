package com.example.moonc.cse_ru_3_1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by moonc on 10/16/2017.
 */

public class DatePicking extends DialogFragment{


    int day_,month_,year_;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePicker = new DatePickerDialog(getActivity(),null,year,month,date);
        return  datePicker;
    }


    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = Integer.toString(dayOfMonth)+"/" + Integer.toString(month) +"/" + Integer.toString(year);
    }
}
