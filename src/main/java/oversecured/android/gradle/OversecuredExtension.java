package oversecured.android.gradle;

import java.util.Arrays;
import java.util.List;

public class OversecuredExtension {
    public static final String EXTENSION_NAME = "oversecured";
    public static final String TASK_NAME = "oversecuredTask";

    private ExtensionSettings settings;
    private List<String> types;

    public OversecuredExtension() {
        settings = new ExtensionSettings();
    }

    ExtensionSettings getSettings() {
        return settings;
    }

    boolean handleBuildType(String type) {
        return types != null && types.contains(type);
    }

    public void buildTypes(String[] types) {
        this.types = Arrays.asList(types);
    }

    public void integrationId(String id) {
        settings.setIntegrationId(id);
    }

    public void accessToken(String token) {
        settings.setAccessToken(token);
    }
}
