package oversecured.android.gradle.network.model;

import com.google.gson.annotations.SerializedName;

public class Error {
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }
}
