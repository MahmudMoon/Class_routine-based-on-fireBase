package com.example.moonc.cse_ru_3_1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by moonc on 10/30/2017.
 */

public class Custom_Notification extends BaseAdapter {
    Activity context;
    TextView time_detail;
    TextView class_detail;


    ArrayList arrayList ;
    ObjectCreatorForNotifications objectCreatorForNotifications;
    private static LayoutInflater inflater = null;

    public Custom_Notification(Activity context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
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

    public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            view = inflater.inflate(R.layout.layout_notifications,null);
            time_detail = (TextView)view.findViewById(R.id.textView4);
            class_detail = (TextView)view.findViewById(R.id.textView5);

        objectCreatorForNotifications = (ObjectCreatorForNotifications) arrayList.get(position);
        time_detail.setText(objectCreatorForNotifications.getTitle());
        class_detail.setText(objectCreatorForNotifications.getMessage());

        return view;
    }
}
