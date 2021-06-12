package com.subhechhu.daggertest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.subhechhu.daggertest.model.ItemsItem;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    List<ItemsItem> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder holder, int position) {
        holder.description.setText(list.get(position).getDescription());
        holder.name.setText(list.get(position).getName());
        holder.name.setText(list.get(position).getCreatedAt());

        Glide.with(holder.imageView)
                .load(list.get(position)
                        .getOwner()
                        .getAvatarUrl())
                .transform(new CircleCrop())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        else
            return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, description, created;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            created = itemView.findViewById(R.id.createdOn);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }

    public void updateData(List<ItemsItem> list) {
        this.list = list;
    }
}
