package com.chengfu.android.utils.demo.ui.main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chengfu.android.utils.demo.R;
import com.chengfu.android.utils.demo.bean.MainItem;

import java.util.List;

public class MainItemAdapter extends RecyclerView.Adapter<MainItemAdapter.ViewHolder> {

    private List<MainItem> list;

    public void submitList(List<MainItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainItem item = list.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(v -> {
                MainItem item = list.get(getAdapterPosition());
                Intent intent = new Intent(v.getContext(), item.getTargetActivity());
                intent.putExtra("title", item.getName());
                v.getContext().startActivity(intent);
            });
        }
    }
}
