package com.example.moonc.cse_ru_3_1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by moonc on 10/10/2017.
 */

public class Thursday extends Fragment {

    View view;
    TextView class_detail;
    String Message;
    String str_time_thu;
    String str_class;
    ObjectCreator objectCreator;
    ListView listView ;
    TextView et_1,et_2,et_3,et_4,et_5;
    TextView ec_1,ec_2,ec_3,ec_4,ec_5;
    ArrayList<ObjectCreator> arrayList;
    Sql_helper_for_routin sql_helper_for_routin;
    String[] Time_ = new String[100];
    String[] Class_ = new String[100];
    int i;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.thursday,container,false);




        et_1 = (TextView) view.findViewById(R.id.at_class_time_thu);
        et_2 = (TextView) view.findViewById(R.id.bt_class_time_thu);
        et_3 = (TextView) view.findViewById(R.id.ct_class_time_thu);
        et_4 = (TextView) view.findViewById(R.id.dt_class_time_thu);
        et_5 = (TextView) view.findViewById(R.id.et_class_time_thu);



        ec_1 = (TextView) view.findViewById(R.id.ast_class_thu);
        ec_2 = (TextView) view.findViewById(R.id.bst_class_thu);
        ec_3 = (TextView) view.findViewById(R.id.cst_class_thu);
        ec_4 = (TextView) view.findViewById(R.id.dst_class_thu);
        ec_5 = (TextView) view.findViewById(R.id.est_class_thu);

        sql_helper_for_routin = new Sql_helper_for_routin(this.getContext());

       Cursor cursor =  sql_helper_for_routin.show("Thursday");

        if(cursor.getCount()>0)
        {
           // Toast.makeText(getContext(),"Done",Toast.LENGTH_SHORT).show();
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
        }else
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






//
//        String state = Environment.getExternalStorageState();
//        if(Environment.MEDIA_MOUNTED.equals(state))
//        {
//            File root = Environment.getExternalStorageDirectory();
//            File dir = new File(root.getAbsolutePath()+ "/Routine");
//            if(dir.exists())
//            {
//                File file = new File(dir,"thu_routine.txt");
//                if(file.exists())
//                {
//                    try {
//                        FileInputStream fileInputStream = new FileInputStream(file);
//                        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                        StringBuffer stringBuffer = new StringBuffer();
//                        String Message;
//                        while ((Message=bufferedReader.readLine())!=null)
//                        {
//                            int flag = 0;
//                            str_class = "";
//                            str_time_thu = "";
//
//                            for(int i = 0;i<Message.length();i++) {
//
//                                if (Message.charAt(i) == '@') {
//                                    flag = 1;
//                                } else {
//                                    if (flag == 0) {
//                                        str_time_thu = str_time_thu + Message.charAt(i);
//                                    }
//                                    if (flag == 1) {
//                                        str_class = str_class + Message.charAt(i);
//                                    }
//                                }
//                            }
//
//                            objectCreator = new ObjectCreator(str_time_thu,str_class);
//                            arrayList.add(objectCreator);
//
//                        }
//
//                        if(!arrayList.isEmpty())
//                        {
//                            ObjectCreator objectCreator = new ObjectCreator();
//                            for(int i = 0; i < arrayList.size();i++)
//                            {
//                                objectCreator = arrayList.get(i);
//                                String time  = objectCreator.getTime();
//                                String class_name  = objectCreator.getClass_name();
//
//                                switch (i)
//                                {
//                                    case 0:
//                                    {
//                                        et_1.setText(time);
//                                        ec_1.setText(class_name);
//                                        break;
//                                    }
//                                    case 1:
//                                    {
//                                        et_2.setText(time);
//                                        ec_2.setText(class_name);
//                                        break;
//                                    }
//                                    case 2:
//                                    {
//                                        et_3.setText(time);
//                                        ec_3.setText(class_name);
//                                        break;
//                                    }
//                                    case 3:
//                                    {
//                                        et_4.setText(time);
//                                        ec_4.setText(class_name);
//                                        break;
//                                    }
//                                    case 4:
//                                    {
//                                        et_5.setText(time);
//                                        ec_5.setText(class_name);
//                                        break;
//                                    }
//                                    default:
//                                        break;
//
//                                }
//
//
//                            }
//                        }
//
//
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                        Log.i("test","error!!!");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        Log.i("test","error  1  !!!");
//                    }
//
//                }else
//                {
//                    Toast.makeText(null,"File not Found",Toast.LENGTH_SHORT).show();
//                }
//
//            }else
//            {
//                Toast.makeText(null,"Folder not found",Toast.LENGTH_SHORT).show();
//            }
//
//        }else {
//            Toast.makeText(null,"SD card not found",Toast.LENGTH_SHORT).show();
//        }
//


        return view;
    }
}
