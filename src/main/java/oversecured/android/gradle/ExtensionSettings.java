package oversecured.android.gradle;

public class ExtensionSettings {
    private boolean alerts;
    private boolean smartFilter;
    private String accessToken;
    private String integrationId;

    public ExtensionSettings() {
        alerts = true;
        smartFilter = true;
    }

    public boolean getAlerts() {
        return alerts;
    }

    public boolean getSmartFilter() {
        return smartFilter;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public void setAlerts(boolean alerts) {
        this.alerts = alerts;
    }

    public void setSmartFilter(boolean smartFilter) {
        this.smartFilter = smartFilter;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }
}
