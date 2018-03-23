package com.example.aishwaryasathyadas.veyec;

/**
 * Created by aishwaryasathyadas on 11/03/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Details> MainImageUploadInfoList;

    public RecyclerViewAdapter(Context context, List<Details> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Details studentDetails = MainImageUploadInfoList.get(position);

        holder.DateTextView.setText(studentDetails.getDate());
        holder.PhoneTextView.setText(studentDetails.getPhone());
        holder.VideourlTextView.setText(studentDetails.getVideourl());
        holder.LongitudeTextView.setText(String.valueOf(studentDetails.getLongitude()));
        holder.LatitudeTextView.setText(String.valueOf(studentDetails.getLatitude()));
        holder.LocationTextView.setText(studentDetails.getLocation());

    }
    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView DateTextView;
        public TextView PhoneTextView;
        public TextView VideourlTextView;
        public TextView LongitudeTextView;
        public TextView LatitudeTextView;
        public TextView LocationTextView;
        public ViewHolder(View itemView) {

            super(itemView);

            DateTextView = (TextView) itemView.findViewById(R.id.DateTextView);
            PhoneTextView = (TextView) itemView.findViewById(R.id.PhoneTextView);
            VideourlTextView = (TextView) itemView.findViewById(R.id.VideourlTextView);
            LongitudeTextView = (TextView) itemView.findViewById(R.id.LongitudeTextView);
            LatitudeTextView = (TextView) itemView.findViewById(R.id.LatitudeTextView);
            LocationTextView = (TextView) itemView.findViewById(R.id.LocationTextView);
        }
    }
}