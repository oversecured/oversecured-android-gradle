package oversecured.android.gradle.network.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class SettingsRequest {
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

    public SettingsRequest(String name, String description, String logoKey, boolean smartFilter, boolean notifyWhenDone,
            boolean autoPull) {

        this.name = name;
        this.description = description;
        this.logoKey = logoKey;
        this.smartFilter = smartFilter;
        this.notifyWhenDone = notifyWhenDone;
        this.autoPull = autoPull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoKey() {
        return logoKey;
    }

    public void setLogoKey(String logoKey) {
        this.logoKey = logoKey;
    }

    public boolean getSmartFilter() {
        return smartFilter;
    }

    public void setSmartFilter(boolean smartFilter) {
        this.smartFilter = smartFilter;
    }

    public boolean getNotifyWhenDone() {
        return notifyWhenDone;
    }

    public void setNotifyWhenDone(boolean notifyWhenDone) {
        this.notifyWhenDone = notifyWhenDone;
    }

    public boolean getAutoPull() {
        return autoPull;
    }

    public void setAutoPull(boolean autoPull) {
        this.autoPull = autoPull;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, logoKey, smartFilter, notifyWhenDone, autoPull);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SettingsRequest) {
            SettingsRequest req = (SettingsRequest) o;
            return Objects.equals(name, req.name) && Objects.equals(description, req.description)
                    && Objects.equals(logoKey, req.logoKey) && Objects.equals(smartFilter, req.smartFilter)
                    && Objects.equals(notifyWhenDone, req.notifyWhenDone) && Objects.equals(autoPull, req.autoPull);
        }
        return false;
    }
}
