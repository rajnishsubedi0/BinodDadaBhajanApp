package com.example.realbhajanbinoddada.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.realbhajanbinoddada.MainActivity;
import com.example.realbhajanbinoddada.R;
import com.example.realbhajanbinoddada.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

public class HomeFragment extends Fragment {
    String url_mocky="https://mocki.io/v1/9221f64f-bca3-4003-a32f-173067d06ce9 ";
    public static ArrayList<DataHolder> arrayList=new ArrayList<DataHolder>();

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

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        myAdapterClass=new AdapterClass();
        loadVolleyData();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapterClass);



    }




    public void loadVolleyData(){
        RequestQueue queue= Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url_mocky, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array=response.getJSONArray("employees");
                    for (int i=0; i<array.length();i++){
                        JSONObject object=array.getJSONObject(i);
                        String name=object.getString("name");
                        arrayList.add(new DataHolder(name));
                      // Toast.makeText(getContext(), ""+name, Toast.LENGTH_SHORT).show();
                        myAdapterClass.notifyDataSetChanged();
                    }
                    Toast.makeText(getContext(), "Succeed", Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    throw new RuntimeException(e);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);

    }
}