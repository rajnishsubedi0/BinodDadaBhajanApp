package com.example.realbhajanbinoddada.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realbhajanbinoddada.R;

public class AdapterClass extends RecyclerView.Adapter<ViewHolderClass> {
    String []arr={"rajju","ritesh","hola"};

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list,parent,false);
        return new ViewHolderClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
    String string=arr[holder.getAdapterPosition()].toString();
    holder.textView.setText(string);

    }

    @Override
    public int getItemCount() {
        return arr.length;
    }
}
