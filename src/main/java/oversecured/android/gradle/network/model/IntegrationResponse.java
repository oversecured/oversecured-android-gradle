package oversecured.android.gradle.network.model;

import com.google.gson.annotations.SerializedName;

public class IntegrationResponse {
    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("logo_bucket_key")
    private String logoKey;

    @SerializedName("smart_filter_enabled")
    private boolean smartFilter;

    @SerializedName("notify_when_done")
    private boolean notifyWhenDone;

    @SerializedName("auto_pull_new_versions")
    private boolean autoPull;

    // ignoring other values...

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLogoKey() {
        return logoKey;
    }

    public boolean getSmartFilter() {
        return smartFilter;
    }

    public boolean getNotifyWhenDone() {
        return notifyWhenDone;
    }

    public boolean getAutoPull() {
        return autoPull;
    }
}
