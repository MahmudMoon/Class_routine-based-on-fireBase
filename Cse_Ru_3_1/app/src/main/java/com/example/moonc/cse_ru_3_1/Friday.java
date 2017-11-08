package com.example.moonc.cse_ru_3_1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by moonc on 10/10/2017.
 */

public class Friday extends Fragment {

    View view;
    ImageView imageView;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.friday,container,false);
        imageView = (ImageView)view.findViewById(R.id.image1);
        return view;
    }
}
