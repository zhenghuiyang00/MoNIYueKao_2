package com.bwei.moniyuekao_2.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwei.moniyuekao_2.app.App;

import java.util.Map;

public class VolleyUtils {
    private RequestQueue requestQueue;
    private static VolleyUtils instance;

    private VolleyUtils(){
        requestQueue= Volley.newRequestQueue(App.getContext());
    }

    public static VolleyUtils getInstance() {
        if (instance==null){
            synchronized (VolleyUtils.class){
                if (instance==null){
                    instance=new VolleyUtils();
                }
            }
        }
        return instance;
    }

    /**
     * doGet
     * @param url
     * @param volleyCallback
     */

    public void doGet(String url, final VolleyCallback volleyCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (volleyCallback != null) {
                    volleyCallback.success(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.failure(error);
            }
        });
        requestQueue.add(stringRequest);
    }

    public void doPost(String url, final Map<String,String>pamas, final VolleyCallback volleyCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (volleyCallback != null) {
                    volleyCallback.success(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.failure(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return pamas;
            }
        };
        requestQueue.add(stringRequest);
    }







    //回调接口
    public interface VolleyCallback{
        void success(String response);
        void failure(Throwable error);
    }






}
