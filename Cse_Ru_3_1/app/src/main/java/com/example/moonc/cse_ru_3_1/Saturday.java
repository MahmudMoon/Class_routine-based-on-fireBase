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

public class Saturday extends Fragment {


     View view;
    ImageView imageView;
//    TextView class_detail;
//    String Message;
//    String str_time;
//    String str_class;
//    ObjectCreator objectCreator;
//    ListView listView ;
//    TextView et_1,et_2,et_3,et_4,et_5;
//    TextView ec_1,ec_2,ec_3,ec_4,ec_5;

    /// i want to show an image on the screen and say its holyday...



//    ArrayList<ObjectCreator> arrayList;

    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.saturday, container, false);
       imageView = (ImageView)view.findViewById(R.id.imageView2);
        return view;

//        arrayList = new ArrayList<>();
//
//        et_1 = (TextView) view.findViewById(R.id.at_class_time);
//        et_2 = (TextView) view.findViewById(R.id.bt_class_time);
//        et_3 = (TextView) view.findViewById(R.id.ct_class_time);
//        et_4 = (TextView) view.findViewById(R.id.dt_class_time);
//        et_5 = (TextView) view.findViewById(R.id.et_class_time);
//
//
//
//        ec_1 = (TextView) view.findViewById(R.id.ast_class);
//        ec_2 = (TextView) view.findViewById(R.id.bst_class);
//        ec_3 = (TextView) view.findViewById(R.id.cst_class);
//        ec_4 = (TextView) view.findViewById(R.id.dst_class);
//        ec_5 = (TextView) view.findViewById(R.id.est_class);
//
//
//        String state = Environment.getExternalStorageState();
//        if(Environment.MEDIA_MOUNTED.equals(state))
//        {
//            File root = Environment.getExternalStorageDirectory();
//            File dir = new File(root.getAbsolutePath()+ "/Routine");
//            if(dir.exists())
//            {
//                File file = new File(dir,"sat_routine.txt");
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
//                            str_time = "";
//
//                            for(int i = 0;i<Message.length();i++) {
//
//                                if (Message.charAt(i) == '@') {
//                                    flag = 1;
//                                } else {
//                                    if (flag == 0) {
//                                        str_time = str_time + Message.charAt(i);
//                                    }
//                                    if (flag == 1) {
//                                        str_class = str_class + Message.charAt(i);
//                                    }
//                                }
//                            }
//
//                            objectCreator = new ObjectCreator(str_time,str_class);
//                            arrayList.add(objectCreator);
//
//                        }
//
//
//
//                        //implemented adopter
////                        custom cus = new custom(getActivity(),arrayList);
////                        listView.setAdapter(cus);
//
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
//                   //      print data in the saturday.xlm
//
//
//
//
////                        String[] time_d =  {"Time    class"};
////
////                         for(int i = 1; i < arrayList.size();i++)
////                         {
////                             objectCreator =  arrayList.get(i);
////                             time_d[i] = objectCreator.getTime() + "   " + objectCreator.getClass_name();
////                         }
////
////                        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,arrayList);
////                        listView.setAdapter(arrayAdapter);
////
////
////                         /// adapter is being used here ...
////
////
////
////
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


    }

}
