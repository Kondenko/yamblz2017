package com.vladimirkondenko;

import com.vladimirkondenko.yamblz.BuildConfig;
import com.vladimirkondenko.yamblz.TestApp;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

public class CustomRobolectricTestRunner extends RobolectricTestRunner {

    /**
     * Creates a runner to run {@code testClass}. Looks in your working directory for your AndroidManifest.xml file
     * and res directory by default. Use the {@link Config} annotation to configure.
     *
     * @param testClass the test class to be run
     * @throws InitializationError if junit says so
     */
    public CustomRobolectricTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected Config buildGlobalConfig() {
        return Config.Builder.defaults()
                .setSdk(25)
                .setApplication(TestApp.class)
                .setConstants(BuildConfig.class)
                .setManifest("/src/main/AndroidManifest.xml")
                .build();
    }
}
