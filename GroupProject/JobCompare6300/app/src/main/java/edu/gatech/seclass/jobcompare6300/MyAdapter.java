package edu.gatech.seclass.jobcompare6300;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final List<Job> localDataSet;
    private ArrayList<Job> checkedJob=new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView jobDescription;
        CheckBox myCheckBox;
        ItemClickListener itemClickListener;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            myCheckBox= itemView.findViewById(R.id.jobCheckBox);
            jobDescription = itemView.findViewById(R.id.jobDescription);
            myCheckBox.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener ic)
        {
            this.itemClickListener=ic;
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v,getLayoutPosition());
        }

        interface ItemClickListener {

            void onItemClick(View v,int pos);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet List<Job> containing the data to populate views to be used
     * by RecyclerView.
     */
    public MyAdapter(List<Job> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_in_recycler_in_job_ranking, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Job job = localDataSet.get(position);

        if (job.getStatus().equals("current")){
            viewHolder.jobDescription.setText(job.getTitle() + "@" + job.getCompany() + " with " + job.getScore() + " *");
        }else {
            viewHolder.jobDescription.setText(job.getTitle() + "@" + job.getCompany() + " with " + job.getScore());
        }



        viewHolder.setItemClickListener(new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                CheckBox myCheckBox= (CheckBox) v;

                if(myCheckBox.isChecked()) {
                    checkedJob.add(job);
//                    System.out.println("checked");
                }
                else if(!myCheckBox.isChecked()) {
                    checkedJob.remove(job);
                    System.out.println("unchecked");
                }
//                System.out.println(checkedJob);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public ArrayList<Job> getCheckedJob() {
        return checkedJob;
    }
}
