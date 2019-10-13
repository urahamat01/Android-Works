package com.rahamat.recyclerviewuse;

import android.content.Context;
import android.nfc.Tag;
import android.os.PowerManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private static final String TAG = "RecycleViewAdapter";

    private List<String> mImageNames = new ArrayList<>();

    private List<String> mImage = new ArrayList<>();

    private Context mContext;


    public RecycleViewAdapter(Context mContext, List<String> mImageNames, List<String> mImage) {
        this.mContext = mContext;
        this.mImageNames = mImageNames;
        this.mImage = mImage;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listener, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));
        holder.prentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clickON " + mImageNames.get(position));
                Toast.makeText(mContext, "Set Listener", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: count Postion :");
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView imageName;
        RelativeLayout prentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageId);
            imageName = itemView.findViewById(R.id.imageTextId);
            prentLayout = itemView.findViewById(R.id.parentLayout);

        }
    }
}
