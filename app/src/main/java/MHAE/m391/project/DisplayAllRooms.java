package MHAE.m391.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import MHAE.m391.project.DataBase.Data;
import MHAE.m391.project.DataBase.Room;

public class DisplayAllRooms extends AppCompatActivity {

    ArrayList<Room>Rooms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_rooms);
        Data x=new Data(this);
        Rooms=x.Get();
        ListView view=findViewById(R.id.mylistview);
        add y=new add(Rooms);
         view.setAdapter(y);

    }
    class  add extends BaseAdapter{
        ArrayList<Room>l=new ArrayList<>();

        public add(ArrayList<Room> l) {
            this.l = l;
        }


        @Override
        public int getCount() {
            return l.size();
        }

        @Override
        public Object getItem(int position) {
            return l.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater ly=getLayoutInflater();
            convertView =ly.inflate(R.layout.display,null);
            TextView id = convertView.findViewById(R.id.textView);
            TextView name= convertView.findViewById(R.id.textView3);
            TextView price = convertView.findViewById(R.id.textView4);
            TextView Take = convertView.findViewById(R.id.textView5);
            TextView Num = convertView.findViewById(R.id.textView6);
            TextView Total = convertView.findViewById(R.id.textView7);
            TextView dis = convertView.findViewById(R.id.textView8);
            id.setText(l.get(position).getId()+"");
            name.setText(l.get(position).getName()+"");
            price.setText(l.get(position).getPrice()+"");
            Take.setText(l.get(position).getPrice()+"");
            Num.setText(l.get(position).getNumberOfRaters()+"");
            Total.setText(l.get(position).getTotalRating()+"");
            dis.setText(l.get(position).getDescription()+"");
            return convertView;
        }
    }
}