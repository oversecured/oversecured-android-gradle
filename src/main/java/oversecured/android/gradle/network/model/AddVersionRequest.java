package oversecured.android.gradle.network.model;

import com.google.gson.annotations.SerializedName;

public class AddVersionRequest {
    @SerializedName("file_name")
    private String fileName;

    @SerializedName("bucket_key")
    private String bucketKey;

    public AddVersionRequest(String fileName, String bucketKey) {
        this.fileName = fileName;
        this.bucketKey = bucketKey;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBucketKey() {
        return bucketKey;
    }

    public void setBucketKey(String bucketKey) {
        this.bucketKey = bucketKey;
    }
}