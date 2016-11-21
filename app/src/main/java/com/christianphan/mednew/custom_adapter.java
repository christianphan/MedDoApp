package com.christianphan.mednew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/19/16.
 */

public class custom_adapter extends RecyclerView.Adapter<custom_adapter.ViewHolder> {


    // Store a member variable for the list
    private List<ActivityItem> mActivity;
    private String[] stringarray = new String[5];


    // Store the context for easy access
    private Context mContext;

    custom_adapter(Context context, ArrayList<ActivityItem> items)
    {
        mContext = context;
        mActivity = items;

    }

    private Context getContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        public TextView nameTextView;
        public Button button;


        //creates viewholder
        public ViewHolder(View itemView) {


            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.activity_name);
            Button go = (Button) itemView.findViewById(R.id.gotocheck_button);
            go.setOnClickListener(this);

        }


        // onClick Listener for view
        @Override
        public void onClick(View v) {

            Context thiscontext = v.getContext();
            Intent i = new Intent(thiscontext, UserCheckInPage.class);

            Bundle b = new Bundle();
            b.putString("Name", nameTextView.getText().toString());

            i.putExtras(b);

            thiscontext.startActivity(i);

        }

    }


    //override methods
    @Override
    public void onBindViewHolder(custom_adapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        ActivityItem activityItem = mActivity.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;

        //sets the name of each item by calling the getname fuction of ActivityItemg
        textView.setText(activityItem.getName());
    }


    @Override
    public int getItemCount() {
        return mActivity.size();
    }


    @Override
    public custom_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.activity_row_layout, parent, false);


        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }



}
