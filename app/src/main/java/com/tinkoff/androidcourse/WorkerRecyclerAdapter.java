package com.tinkoff.androidcourse;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tinkoff.androidcourse.model.Worker;

import java.util.List;

public class WorkerRecyclerAdapter extends RecyclerView.Adapter<WorkerRecyclerAdapter.ViewHolder> {

    private List<Worker> workers;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView photo;
        public TextView age;

        ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            photo = itemView.findViewById(R.id.photo);
            age = itemView.findViewById(R.id.age);
        }
    }


    public WorkerRecyclerAdapter(Context context, List<Worker> workers) {
        this.workers = workers;
        this.context = context;
    }

    @Override
    public WorkerRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Worker worker = workers.get(position);

        ImageView photo = holder.photo;
        TextView name = holder.name;
        TextView age = holder.age;

        photo.setImageResource(worker.getPhoto());
        name.setText(worker.getName());
        age.setText(worker.getAge());
    }

    @Override
    public int getItemCount() {
        return workers.size();
    }

    public void addItem(int position, Worker worker){
        this.workers.add(position, worker);
        super.notifyItemInserted(position);
    }

    public void removeItem(int position){
        this.workers.remove(position);
        super.notifyItemRemoved(position);
    }


    public void onItemMove(int fromPosition, int toPosition){}
    public void onItemDismiss(int position){}

}

