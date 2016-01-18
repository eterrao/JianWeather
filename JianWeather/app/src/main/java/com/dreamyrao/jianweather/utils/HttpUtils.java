package com.dreamyrao.jianweather.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raomengyang on 1/18/16.
 */
public class HttpUtils {

    public static String getWeatherUrl() {
        return AppConstant.API_WEATHER_URL;
    }


    public static void doVolleyGet(AsyncRequestable qa, String getUrl,
                                   final Executable<String> execOnSuccess,
                                   final Executable<VolleyError> execOnError,
                                   final String... strKVs) {
        doVolleyRequest(Request.Method.GET, qa, getUrl, execOnSuccess, execOnError, strKVs);
    }


    public static void doVolleyPost(AsyncRequestable qa, String getUrl,
                                    final Executable<String> execOnSuccess,
                                    final Executable<VolleyError> execOnError,
                                    final String... strKVs) {
        doVolleyRequest(Request.Method.POST, qa, getUrl, execOnSuccess, execOnError, strKVs);
    }


    private static void doVolleyRequest(int requestMethod, AsyncRequestable qa, String requestUrl,
                                        final Executable<String> execOnSuccess,
                                        final Executable<VolleyError> execOnError,
                                        final String... strKVs) {
        StringRequest requestPost = new StringRequest(requestMethod, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String resultStr) {
                if (execOnSuccess != null) execOnSuccess.execute(resultStr);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (execOnError != null) execOnError.execute(volleyError);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                if (strKVs != null && (strKVs.length % 2 == 0)) {
                    for (int i = 0; i < strKVs.length; i += 2) {
                        map.put(strKVs[i], strKVs[i + 1]);
                    }
                }
                return map;
            }
        };
        // queueTag 用于调用cancelAll(queueTag)取消加入队列的请求
        requestPost.setTag(qa.getQueueTag());
        qa.getQueue().add(requestPost);
    }
}
