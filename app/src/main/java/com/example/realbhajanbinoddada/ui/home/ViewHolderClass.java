package com.example.realbhajanbinoddada.ui.home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realbhajanbinoddada.R;

public class ViewHolderClass extends RecyclerView.ViewHolder {
    TextView textView;
    public ViewHolderClass(@NonNull View itemView) {
        super(itemView);
        this.textView=itemView.findViewById(R.id.recycler_text_view);

    }
}
