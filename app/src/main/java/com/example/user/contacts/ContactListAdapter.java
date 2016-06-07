package com.example.user.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/21/2016.
 */
public class ContactListAdapter extends BaseAdapter {

    private final static String TAG = ContactListAdapter.class.getSimpleName();
    Context context;
    ArrayList<contactWrapper>conList;
    LayoutInflater inflater;
    ViewHolder holder;

    public ContactListAdapter(Context context, ArrayList<contactWrapper> List) {
        this.context = context;
        this.conList = List;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return conList.size();
    }

    @Override
    public Object getItem(int position) {
        return conList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_contact_list_adapter, null);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        contactWrapper obj = conList.get(position);
        holder.nameTv.setText(obj.get_name());
        holder.numberTv.setText(obj.get_numbers());
        return convertView;
    }



    public static class ViewHolder {

        TextView nameTv,numberTv;

        public ViewHolder(View view) {
            nameTv = (TextView)view.findViewById(R.id.name);
            numberTv = (TextView) view.findViewById(R.id.numbers);

        }
    }





}
