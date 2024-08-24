package com.example.realbhajanbinoddada.ui.home;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;


public class AnotherThreadClass implements Runnable {
    String url_mocky="https://mocki.io/v1/9221f64f-bca3-4003-a32f-173067d06ce9 ";
    Context context;
    Handler handler;
    public AnotherThreadClass(Context context){
        this.context=context;
        this.handler=new Handler(Looper.getMainLooper());
    }
    @Override
    public void run() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "Hola from thread", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
