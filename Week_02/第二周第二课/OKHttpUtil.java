package java0.nio01.netty;

import okhttp3.*;

import java.io.IOException;

/**
 * @Author: mahui
 * @Description:
 * @Date: Create in 1:29 PM 1/22/21
 */
public class OKHttpUtil {
   private static final String url = "http://localhost:8801/";

    public static void main(String[] args) {
        sendGet(url);
    }

    private static void sendGet(String url) {
        OkHttpClient httpClient = new OkHttpClient() ;
        Request request = new Request.Builder()
                .url(url)
                .build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    // Get response headers
                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    // Get response body
                    System.out.println(responseBody.string());
                }
            }
        });
    }
}
