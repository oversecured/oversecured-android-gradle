package oversecured.android.gradle.network;

import okhttp3.RequestBody;
import oversecured.android.gradle.network.model.AddVersionRequest;
import oversecured.android.gradle.network.model.AppSignRequest;
import oversecured.android.gradle.network.model.AppSignResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface OversecuredService {
    @POST("v1/upload/app")
    Call<AppSignResponse> getSignedLink(@Body AppSignRequest signInfo);

    @POST("v1/integrations/{integration_id}/versions/add")
    Call<Void> scanVersion(@Path("integration_id") String id, @Body AddVersionRequest addVersion);

    @PUT
    Call<Void> uploadAppFile(@Url String url, @Body RequestBody appFile);
}
