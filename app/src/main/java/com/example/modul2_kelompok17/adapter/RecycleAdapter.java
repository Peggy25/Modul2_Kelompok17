package com.example.modul2_kelompok17.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.modul2_kelompok17.Model.DataItem;
import com.example.modul2_kelompok17.R;
import com.example.modul2_kelompok17.activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private ArrayList<DataItem> dataUser;
    private Context ctx;

    public RecycleAdapter(ArrayList<DataItem> dataUser, Context mContext) {
        this.dataUser = dataUser;
        this.ctx = mContext;
    }


    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_list_user,parent,false
        );
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {
        holder.tvFirstName.setText(dataUser.get(position).getFirstName());
        holder.tvLastName.setText(dataUser.get(position).getLastName());
        holder.tvEmail.setText(String.format("Email : %s",dataUser.get(position).getEmail()));

        Glide.with(ctx).load(dataUser.get(position).getAvatar()).into(holder.imgPhoto);

        // variable
        String firstName = dataUser.get(position).getFirstName();
        String lastName = dataUser.get(position).getLastName();
        String email = dataUser.get(position).getEmail();
        String img = dataUser.get(position).getAvatar();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(ctx, DetailActivity.class);
                detail.putExtra("firstName", firstName);
                detail.putExtra("lastName", lastName);
                detail.putExtra("email",email);
                detail.putExtra("avatar",img);
                ctx.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPhoto;
        private TextView tvFirstName,tvLastName,tvEmail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.profile_image);
            tvFirstName = itemView.findViewById(R.id.tv_name);
            tvLastName = itemView.findViewById(R.id.tv_last_name);
            tvEmail = itemView.findViewById(R.id.tv_email);

        }
    }
}
