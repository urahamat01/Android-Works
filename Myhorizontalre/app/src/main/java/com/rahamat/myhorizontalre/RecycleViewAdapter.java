package com.rahamat.myhorizontalre;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
  //log variable
    private static final String TAG = "RecycleViewAdapter";

    //variable
    private List<String> mImage = new ArrayList<>();
    private List<String>mName = new ArrayList<>();
    private Context mContext;

    public RecycleViewAdapter(Context mContext, List<String> mImage, List<String> mName) {
        this.mContext = mContext;
        this.mImage = mImage;
        this.mName = mName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_horijental,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: start bindViewHolder ");
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_launcher_foreground);

        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                .apply(requestOptions)
                .into(holder.circleImageView);
        
        holder.name.setText(mName.get(position));
        holder.circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: onclick"+mName.get(position));
                Toast.makeText(mContext, mName.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView circleImageView;
        private TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.imageId);
            name = itemView.findViewById(R.id.nameId);


        }
    }
}
