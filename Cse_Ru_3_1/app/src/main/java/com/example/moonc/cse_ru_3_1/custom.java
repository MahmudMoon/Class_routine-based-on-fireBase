package com.example.moonc.cse_ru_3_1;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by moonc on 10/12/2017.
 */


public class custom extends BaseAdapter {

    Activity context;
    TextView time_detail;
    TextView class_detail;
    ImageView imageView;


    ArrayList arrayList ;
    ObjectCreatorForCt objectCreatorForCt;
    private static LayoutInflater inflater = null;
    SQLite_Helper sqLite_helper ;


    public custom(Activity context,ArrayList arrayList ) {
        this.arrayList = arrayList;
        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
          View view = convertView;
                  view = inflater.inflate(R.layout.layout_cutom,null);
            time_detail = (TextView)view.findViewById(R.id.time_);
            class_detail = (TextView)view.findViewById(R.id.Class);
            imageView = (ImageView)view.findViewById(R.id.delete_btn);



        objectCreatorForCt = (ObjectCreatorForCt) arrayList.get(position);
        time_detail.setText(objectCreatorForCt.getCt_time());
        class_detail.setText(objectCreatorForCt.getCt_xm());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Delete");
                builder.setMessage("Want to delete ");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         dialog.cancel();
                      }
                    }
                  );

                AlertDialog.Builder builder1 = builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sqLite_helper = new SQLite_Helper(v.getContext());
                        boolean resul = sqLite_helper.delete(objectCreatorForCt.getCt_xm());
                        if (resul) {
                            Toast.makeText(v.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(v.getContext(), "Could not delete", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.show();

            }
        });

        return view;
    }



}
