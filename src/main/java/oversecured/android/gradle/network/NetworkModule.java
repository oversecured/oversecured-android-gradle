package oversecured.android.gradle.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {
    private static final String BASE_URL = "https://api.oversecured.com/";

    public static OversecuredService getService(String accessToken) {
        Retrofit retrofit = new Retrofit.Builder().client(getClient(accessToken)).baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(OversecuredService.class);
    }

    private static OkHttpClient getClient(String accessToken) {
        Interceptor tokenInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                if (chain.request().url().toString().startsWith(BASE_URL)) {
                    Request newRequest = chain.request().newBuilder().addHeader("Authorization", accessToken).build();
                    return chain.proceed(newRequest);
                }
                return chain.proceed(chain.request());
            }
        };

        return new OkHttpClient.Builder().addInterceptor(tokenInterceptor).callTimeout(15, TimeUnit.MINUTES).build();
    }
}
