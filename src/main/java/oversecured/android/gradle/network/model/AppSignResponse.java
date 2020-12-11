package oversecured.android.gradle.network.model;

import com.google.gson.annotations.SerializedName;

public class AppSignResponse {
    @SerializedName("bucket_key")
    private String bucketKey;

    @SerializedName("url")
    private String url;

    public String getBucketKey() {
        return bucketKey;
    }

    public String getUrl() {
        return url;
    }
}
