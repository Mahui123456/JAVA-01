package com.mahui.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;
import okhttp3.Response;

public class HeaderHttpResponseFilter implements com.mahui.gateway.filter.HttpResponseFilter {
    @Override
    public void filter(Response response) {
        response.newBuilder().addHeader("kk", "java-1-nio");
    }
}
