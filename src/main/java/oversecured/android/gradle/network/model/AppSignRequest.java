package oversecured.android.gradle.network.model;

import com.google.gson.annotations.SerializedName;

public class AppSignRequest {
    @SerializedName("file_name")
    private String fileName;

    @SerializedName("platform")
    private String platform;

    public AppSignRequest(String platform, String fileName) {
        this.platform = platform;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
