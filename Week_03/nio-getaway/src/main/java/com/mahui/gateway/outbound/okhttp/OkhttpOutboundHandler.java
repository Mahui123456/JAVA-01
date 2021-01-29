package com.mahui.gateway.outbound.okhttp;

import java.io.IOException;
import okhttp3.*;
import org.apache.http.protocol.HTTP;

public class OkhttpOutboundHandler {

    public static Response sendGet(String url) {
        Response response = null;
        try {
            OkHttpClient httpClient = new OkHttpClient() ;

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("mahui","mahui")
                    .addHeader(HTTP.CONN_DIRECTIVE,HTTP.CONN_KEEP_ALIVE)
                    .build();

            response = httpClient.newCall(request).execute();
        }catch (IOException e){
            e.printStackTrace();
        }
        return response;
    }
}
