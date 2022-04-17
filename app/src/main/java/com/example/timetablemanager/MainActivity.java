package com.example.timetablemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;

import androidx.appcompat.widget.Toolbar;



public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();
        initToolbar();
        setupListView();

    }
    private void setupUIViews(){
        toolbar= (Toolbar) findViewById(R.id.ToolbarMain);
        listView= (ListView) findViewById(R.id.lvMain);

    }

    private void initToolbar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Timetable App");

    }

    private void setupListView(){
        String[] title = getResources().getStringArray(R.array.Main);
        String[] description = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title,description);
        listView.setAdapter(simpleAdapter);
    }

    public class  SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;


        public SimpleAdapter(Context context, String[] title, String[] description){
            mContext = context;
            titleArray= title;
            descriptionArray= description;
            layoutInflater= LayoutInflater.from(context);
        }


        @Override
        public int getCount() {

            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {

            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView=layoutInflater.inflate(R.layout.main_activity_single_item, null);
            }
            title=(TextView)convertView.findViewById(R.id.tvMain);
            description=(TextView) convertView.findViewById(R.id.tvDescription);
            imageView=(ImageView) convertView.findViewById(R.id.ivMain);
            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if (titleArray[position].equalsIgnoreCase("Timetable")){
                imageView.setImageResource(R.drawable.calendar);
            } else if (titleArray[position].equalsIgnoreCase("Subjects")){
                imageView.setImageResource(R.drawable.abtme);
            }else if (titleArray[position].equalsIgnoreCase("Faculty") ){
                imageView.setImageResource(R.drawable.department);
            }else {
                imageView.setImageResource(R.drawable.menu);
            }
            return convertView;

        }

        public String[] getDescriptionArray() {
            return descriptionArray;
        }

    }


}