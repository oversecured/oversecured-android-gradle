package oversecured.android.gradle;

public class ExtensionSettings {
    private String accessToken;
    private String integrationId;
    private String branchName;

    public ExtensionSettings() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
