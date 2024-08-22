package com.example.realbhajanbinoddada.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realbhajanbinoddada.R;
import com.example.realbhajanbinoddada.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private Button button;
    RecyclerView recyclerView;
    AdapterClass myAdapterClass;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView=root.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());

        myAdapterClass=new AdapterClass();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapterClass);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}