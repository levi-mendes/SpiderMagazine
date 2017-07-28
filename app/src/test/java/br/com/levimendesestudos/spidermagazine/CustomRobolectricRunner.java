package br.com.levimendesestudos.spidermagazine;

import android.os.Build;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.FileFsFile;

/**
 * Created by 809778 on 21/06/2017.
 */

public class CustomRobolectricRunner extends RobolectricTestRunner {

    @Override
    protected Config buildGlobalConfig() {
        return Config.Builder.defaults()
                .setPackageName("br.com.levimendesestudos.spidermagazine")
                .setManifest("build/intermediates/manifests/full/debug/AndroidManifest.xml")
                .setResourceDir("../../../res/merged/debug") // relative to manifest
                .setAssetDir("../../../assets/debug") // relative to manifest
                .build();
    }

    public CustomRobolectricRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }
}