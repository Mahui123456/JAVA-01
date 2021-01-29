package com.mahui.gateway.filter;

import okhttp3.Response;

public interface HttpResponseFilter {

    void filter(Response response);

}
