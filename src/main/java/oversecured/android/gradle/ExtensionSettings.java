package oversecured.android.gradle;

public class ExtensionSettings {
    private String accessToken;
    private String integrationId;

    public ExtensionSettings() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }
}
