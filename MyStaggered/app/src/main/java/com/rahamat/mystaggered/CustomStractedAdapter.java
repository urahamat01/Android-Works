package com.rahamat.mystaggered;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class CustomStractedAdapter extends RecyclerView.Adapter<CustomStractedAdapter.ViewHolder> {

    private static final String TAG = "CustomStractedAdapter";
    private List<String> mImage = new ArrayList<>();
    private List<String> mName = new ArrayList<>();
    private Context mContext;

    public CustomStractedAdapter( Context mContext,List<String> mImage, List<String> mName) {
        this.mContext = mContext;
        this.mImage = mImage;
        this.mName = mName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_demo,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: callered");

        //Request Options Set


      //  RequestOptions requestOptions = new RequestOptions();
//        requestOptions.placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
               // .apply(requestOptions)
                .into(holder.image);

        holder.name.setText(mName.get(position));

        //toast
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //log create
                    Log.d(TAG, "onClick: setOncLICk"+mName.get(position));

                    //Toast create
                    Toast.makeText(mContext,mName.get(position), Toast.LENGTH_SHORT).show();
                }
            });

    }

    @Override
    public int getItemCount() {
        return mImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image =itemView.findViewById(R.id.imageId);
            name = itemView.findViewById(R.id.nameId);
        }
    }
}
