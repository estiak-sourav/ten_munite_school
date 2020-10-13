package com.sourav.tenmuniteschool.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sourav.tenmuniteschool.R;
import com.sourav.tenmuniteschool.modes.HomeMainList;
import com.sourav.tenmuniteschool.modes.SubItem;

import java.util.ArrayList;
import java.util.List;

public class ChapterDetailsAdapter extends RecyclerView.Adapter<ChapterDetailsAdapter.ViewHolder>{
    List<SubItem> subItemArrayList;
    Context context;

    public ChapterDetailsAdapter(Context context, List<SubItem> chapterDetailsList) {
        this.subItemArrayList = chapterDetailsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChapterDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chapter_details, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ChapterDetailsAdapter.ViewHolder holder, int position) {
        final SubItem homeMainList = subItemArrayList.get(position);

        holder.titleTv.setText(" "+homeMainList.getContent());

    }

    @Override
    public int getItemCount() {
        return subItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTv = itemView.findViewById(R.id.titleTv);
        }
    }
}
