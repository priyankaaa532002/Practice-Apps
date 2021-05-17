package com.example.recyclerviewwithvolley;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Data> localDataSet ;
    private TextView userId;
    private TextView id;
    private TextView title;
    private TextView completed;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.userId);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * STEP 1
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(ArrayList<Data> dataSet) {
        localDataSet = dataSet;
    }

    // STEP 2  : Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        userId = view.findViewById(R.id.userId);
        id = view.findViewById(R.id.id);
        title = view.findViewById(R.id.title);
        completed = view.findViewById(R.id.completed);

        return new ViewHolder(view);
    }

    // STEP 3 : Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        Data data = localDataSet.get(position);
        userId.setText(String.valueOf(data.getUserId()));
        id.setText(String.valueOf(data.getId()));
        title.setText(data.getTitle());
        completed.setText(String.valueOf(data.isCompleted()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
