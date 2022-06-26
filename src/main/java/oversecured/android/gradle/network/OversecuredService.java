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

    @PUT
    Call<Void> uploadAppFile(@Url String url, @Body RequestBody appFile);

    @POST("v1/integrations/{integration_id}/branches/{branch_name}/versions/add")
    Call<Void> scanVersion(@Path("integration_id") String integrationId, @Path("branch_name") String branchName,
            @Body AddVersionRequest addVersion);
}
