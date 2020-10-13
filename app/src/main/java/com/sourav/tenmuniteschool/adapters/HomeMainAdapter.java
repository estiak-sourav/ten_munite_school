package com.sourav.tenmuniteschool.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.sourav.tenmuniteschool.R;
import com.sourav.tenmuniteschool.activitys.ChapterActivity;
import com.sourav.tenmuniteschool.activitys.MainActivity;
import com.sourav.tenmuniteschool.modes.HomeMainList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeMainAdapter extends RecyclerView.Adapter<HomeMainAdapter.ViewHolder>{
    ArrayList<HomeMainList> homeMainLists;
    Context context;

    public HomeMainAdapter(MainActivity mainActivity, ArrayList<HomeMainList> homeMainLists) {
        this.homeMainLists = homeMainLists;
        this.context = mainActivity;
    }

    /*public HomeMainAdapter(MainActivity mainActivity, Object homeList) {

    }*/

    @NonNull
    @Override
    public HomeMainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeMainAdapter.ViewHolder holder, int position) {
        final HomeMainList homeMainList = homeMainLists.get(position);

        holder.titleTv.setText(homeMainList.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if (Objects.requireNonNull(homeMainList.getTitle()).contains("Chapter")){
                    Intent intent = new Intent(context, ChapterActivity.class);
                    context.startActivity(intent);
                }else {
                    Toast.makeText(context, homeMainList.getTitle()+" is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeMainLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTv = itemView.findViewById(R.id.titleTv);
        }
    }
}
