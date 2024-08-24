package com.example.realbhajanbinoddada.ui.home;

import static com.example.realbhajanbinoddada.ui.home.HomeFragment.arrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realbhajanbinoddada.R;


public class AdapterClass extends RecyclerView.Adapter<ViewHolderClass> {


    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list,parent,false);
        return new ViewHolderClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
    String string=arrayList.get(holder.getAdapterPosition()).getName();
    holder.textView.setText(string);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
