package com.example.realbhajanbinoddada.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.realbhajanbinoddada.R;
import com.example.realbhajanbinoddada.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    String url="https://wallpaperaccess.com/full/265770.jpg";
    String a_url="https://raw.githubusercontent.com/rajnishsubedi0/hosting_items/f4e4554f45c709e07f7fbbcbce7255fc4511a52f/pngwing.com(1).png";
    ImageView imageView;
    private FragmentGalleryBinding binding;
        public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
         imageView=root.findViewById(R.id.my_image);


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
        Glide.with(getContext()).load(a_url)
                .centerCrop()
                .into(imageView);
    }
}