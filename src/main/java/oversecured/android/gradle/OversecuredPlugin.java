package oversecured.android.gradle;

import java.io.File;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;

public class OversecuredPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        OversecuredExtension extension = project.getExtensions().create(OversecuredExtension.EXTENSION_NAME,
                OversecuredExtension.class);

        OversecuredTask oversecuredTask = project.getTasks().create(OversecuredExtension.TASK_NAME,
                OversecuredTask.class);
        oversecuredTask.setSettings(extension.getSettings());

        AppExtension appExtension = project.getExtensions().getByType(AppExtension.class);
        appExtension.getApplicationVariants().all(variant -> {
            String buildType = variant.getBuildType().getName();
            if (extension.handleBuildType(buildType)) {
                attachToVariant(variant, oversecuredTask);
            }
        });
    }

    private void attachToVariant(ApplicationVariant variant, OversecuredTask oversecuredTask) {
        variant.getOutputs().all(output -> {
            variant.getAssembleProvider().configure(it -> {
                File outputFile = output.getOutputFile();
                System.out.println(String.format("oversecured: adding task for %s build type, output file %s",
                        variant.getBuildType().getName(), outputFile));
                it.doLast(action -> {
                    oversecuredTask.execute(outputFile);
                });
            });
        });
    }
}
