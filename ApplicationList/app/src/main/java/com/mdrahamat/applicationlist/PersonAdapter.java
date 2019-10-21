package com.mdrahamat.applicationlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class PersonAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    int mResourec;

    public PersonAdapter(@NonNull Context context,int resource, ArrayList<Person> objects) {
        super(context, resource,objects);
        this.mContext = context;
        this.mResourec = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String name = getItem(position).getName();
        String birthday = getItem(position).getBirthday();
        String sex = getItem(position).getSex();
        Person person = new Person(name, birthday, sex);

        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(mResourec, parent, false);

        TextView tvName = convertView.findViewById(R.id.textViewId1);
        TextView tvBirthday = convertView.findViewById(R.id.textViewId2);
        TextView tvSex = convertView.findViewById(R.id.textViewId3);

        tvName.setText(name);
        tvBirthday.setText(birthday);
        tvSex.setText(sex);

        return convertView;
    }
}
