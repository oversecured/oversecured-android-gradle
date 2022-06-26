package oversecured.android.gradle;

import java.io.File;
import java.io.IOException;

import org.gradle.api.GradleException;
import org.gradle.api.internal.ConventionTask;

import com.google.common.base.Strings;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import oversecured.android.gradle.network.NetworkModule;
import oversecured.android.gradle.network.OversecuredService;
import oversecured.android.gradle.network.Utils;
import oversecured.android.gradle.network.model.AddVersionRequest;
import oversecured.android.gradle.network.model.AppSignRequest;
import oversecured.android.gradle.network.model.AppSignResponse;
import retrofit2.Response;

public class OversecuredTask extends ConventionTask {
    private static final String PLATFORM = "android";
    private static final MediaType APP_CONTENT_TYPE = MediaType.parse("application/octet-stream");

    private OversecuredService service;
    private ExtensionSettings settings;

    public void setSettings(ExtensionSettings settings) {
        this.settings = settings;
    }

    public void execute(File target) {
        service = NetworkModule.getService(settings.getAccessToken());
        try {
            verifyConfig(target);
            processVersionUpload(target);
        } catch (IOException e) {
            throw new GradleException(e.getMessage(), e);
        }
    }

    private void processVersionUpload(File target) throws IOException {
        System.out.println("oversecured: file upload");

        Response<AppSignResponse> appSignResp = service.getSignedLink(new AppSignRequest(PLATFORM, target.getName()))
                .execute();
        if (appSignResp.code() != 200) {
            throw requestErr("Signed URL", appSignResp);
        }

        AppSignResponse signInfo = appSignResp.body();
        Response<Void> uploadResp = service
                .uploadAppFile(signInfo.getUrl(), RequestBody.create(APP_CONTENT_TYPE, target)).execute();

        if (uploadResp.code() != 200) {
            throw requestErr("S3 Upload", uploadResp);
        }

        AddVersionRequest addVersion = new AddVersionRequest(target.getName(), signInfo.getBucketKey());
        Response<Void> addVersionResp = service.scanVersion(settings.getIntegrationId(),
                settings.getBranchName(), addVersion).execute();
        if (addVersionResp.code() != 200) {
            throw requestErr("Scan Version", addVersionResp);
        }
        System.out.println("oversecured: success");
    }

    private GradleException requestErr(String msg, Response<?> resp) {
        ResponseBody errorBody = resp.errorBody();
        String informativeMessage = String.format("oversecured: Step %s failed with code %d, server message: %s", msg,
                resp.code(), Utils.getServerError(errorBody));
        return new GradleException(informativeMessage);
    }

    private void verifyConfig(File target) {
        if (!target.exists() || !target.isFile()) {
            throw new GradleException("App file '" + target + "' is missing");
        }
        if (Strings.isNullOrEmpty(settings.getAccessToken())) {
            throw new GradleException("accessToken is not set");
        }
        if (Strings.isNullOrEmpty(settings.getIntegrationId())) {
            throw new GradleException("integrationId is not set");
        }
        if (Strings.isNullOrEmpty(settings.getBranchName())) {
            throw new GradleException("branchName is not set");
        }
    }
}
