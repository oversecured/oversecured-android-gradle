Oversecured Extension for Gradle
============================

First of all, a plugin user must have an [active Integration](https://oversecured.com/integrations). For more information, visit the [Quick Start](https://oversecured.com/docs/quick-start/) page.

User documentation
------------------

### Using the plugin directly in a project

Add the dependency to the project-level `build.gradle` file:

```gradle
buildscript {
    repositories {
        maven {
            url 'https://plugins.gradle.org/m2/'
        }
    }
    dependencies {
        classpath 'com.oversecured:gradle-android:1.2'
    }
}
```

In the module-level `build.gradle` file, apply the plugin:

```
apply plugin: 'com.oversecured'
```

and set the following settings:

```gradle
oversecured {
    buildTypes 'beta', 'release'
    integrationId '5e7096e2-7fed-43f0-9290-22d03c64cfbf'
    branchName 'main'
    accessToken System.env['OVERSECURED_ACCESS_TOKEN']
}
```

where `buildTypes` are types of assemblies that will be automatically sent for scanning


### How the plugin works

After building each of the specified assembly types, the plugin will automatically send it as a new version of the application to the specified Integration. The user can also omit `buildTypes` and call `oversecuredTask.execute(apkFilePath)` at the desired moment.

Have Question or Feedback?
--------------------------

Submit a request using the [contact form](https://support.oversecured.com/hc/en-us/requests/new).

---------------------------------------
*Licensed under the Simplified BSD License*

*Copyright (c) 2024, Oversecured Inc*

https://oversecured.com/
