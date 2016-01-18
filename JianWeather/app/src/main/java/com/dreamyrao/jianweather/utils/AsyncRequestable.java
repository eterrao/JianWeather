package com.dreamyrao.jianweather.utils;

import com.android.volley.RequestQueue;

/**
 * Created by raomengyang on 11/23/15.
 */
public interface AsyncRequestable {
    String getQueueTag();
    RequestQueue getQueue();
}
