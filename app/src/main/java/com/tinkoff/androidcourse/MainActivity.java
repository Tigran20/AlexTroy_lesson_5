package com.tinkoff.androidcourse;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.tinkoff.androidcourse.item_touch.SwipeController;
import com.tinkoff.androidcourse.model.Worker;
import com.tinkoff.androidcourse.model.WorkerGenerator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private static WorkerRecyclerAdapter adapter;
    private List<Worker> workers;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worker_list);

        fab = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        workers = WorkerGenerator.generateWorkers(2);
        adapter = new WorkerRecyclerAdapter(this, workers);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SwipeController swipeController = new SwipeController(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Worker was added!", Toast.LENGTH_SHORT).show();
                workers = WorkerGenerator.generateWorkers(1);

                newItem(0);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    private void newItem(int position) {
        Worker worker = workers.get(position);
        adapter.addItem(position, worker);
        adapter.notifyItemChanged(position);
    }

    public static void removeItem(int position) {
        adapter.removeItem(position);
        adapter.notifyItemRemoved(position);
    }


}
