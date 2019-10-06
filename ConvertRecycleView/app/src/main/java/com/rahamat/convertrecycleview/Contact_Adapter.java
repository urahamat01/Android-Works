package com.rahamat.convertrecycleview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class Contact_Adapter extends RecyclerView.Adapter<Contact_Adapter.ViewHolder> {
    private List<Contact> contactList;
    private Context context;

    public Contact_Adapter(List<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_contact_degin, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Contact contact = contactList.get(position);
        holder.textViewId.setText(contact.getName());
        holder.imageViewCallId.setImageResource(contact.getPhoto());
        holder.imageViewCallId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + context));

                Toast.makeText(context, contact.getName(), LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewIcId, imageViewCallId;
        private TextView textViewId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewIcId = itemView.findViewById(R.id.imageViewIcId);
            imageViewCallId = itemView.findViewById(R.id.imageViewCallId);
            textViewId = itemView.findViewById(R.id.textViewId);
        }
    }
}
