package com.rahamat.androidrecyclerview;

import android.content.Context;
import android.content.Intent;
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
    private Context mContext;
    private List<String>mImageName = new ArrayList<>();
    private List<String>mImage = new ArrayList<>();

    public RecycleViewAdapter(Context mContext, List<String> mImageName, List<String> mImage) {
        this.mContext = mContext;
        this.mImageName = mImageName;
        this.mImage = mImage;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_demo,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: createstart");
        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                .into(holder.image);
        holder.imageName.setText(mImageName.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: parentLayout sTart"+mImageName.get(position));
                Toast.makeText(mContext, mImageName.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext,GalleryActivity.class);
                intent.putExtra("image_url",mImage.get(position));
                intent.putExtra("imageName",mImageName.get(position));
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.imageText);
            parentLayout = itemView.findViewById(R.id.parentLayoutId);

        }
    }
}
