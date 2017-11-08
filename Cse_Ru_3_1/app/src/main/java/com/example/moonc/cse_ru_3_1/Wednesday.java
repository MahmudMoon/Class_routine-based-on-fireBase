package com.example.moonc.cse_ru_3_1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by moonc on 10/10/2017.
 */

public class Wednesday extends Fragment {



    View view;

    TextView et_1,et_2,et_3,et_4,et_5;
    TextView ec_1,ec_2,ec_3,ec_4,ec_5;

    String[] Time_ = new String[10];
    String[] Class_ = new String[10];
    Sql_helper_for_routin sql_helper_for_routin;
    int i;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.wednesday,container,false);


        et_1 = (TextView) view.findViewById(R.id.at_class_time_wed);
        et_2 = (TextView) view.findViewById(R.id.bt_class_time_wed);
        et_3 = (TextView) view.findViewById(R.id.ct_class_time_wed);
        et_4 = (TextView) view.findViewById(R.id.dt_class_time_wed);
        et_5 = (TextView) view.findViewById(R.id.et_class_time_wed);



        ec_1 = (TextView) view.findViewById(R.id.ast_class_wed);
        ec_2 = (TextView) view.findViewById(R.id.bst_class_wed);
        ec_3 = (TextView) view.findViewById(R.id.cst_class_wed);
        ec_4 = (TextView) view.findViewById(R.id.dst_class_wed);
        ec_5 = (TextView) view.findViewById(R.id.est_class_wed);


        sql_helper_for_routin = new Sql_helper_for_routin(this.getContext());

        Cursor cursor =  sql_helper_for_routin.show("Wednesday");


        if(cursor.getCount()>0)
        {
            i = 0;
            while (cursor.moveToNext())

            {
                Time_[i] = cursor.getString(0);
                Class_[i] = cursor.getString(1);
                i++;

            }

            for(int j = 0; j < Time_.length;j++) {
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
        else
        {

            et_1.setText("");
            ec_1.setText("");
            et_2.setText("");
            ec_2.setText("");
            et_3.setText("");
            ec_3.setText("");
            et_4.setText("");
            ec_4.setText("");
            et_5.setText("");
            ec_5.setText("");


        }

        return view;
    }
}
