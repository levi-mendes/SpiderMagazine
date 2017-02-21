package br.com.levimendesestudos.spidermagazine;

import android.content.Intent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by 809778 on 23/01/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
//@Config(constants = BuildConfig.class, manifest = "src/main/AndroidManifest.xml")
//@Config(emulateSdk = Build.VERSION_CODES.LOLLIPOP, manifest = Config.NONE)
public class MainActivityTest {

    @Test
    public void clickingButton_shouldCallSobreActivity() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        /*
        activity.onOptionsItemSelected(item);

        ShadowActivity shadowActivity = Robolectric.shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = Robolectric.shadowOf(startedIntent);
        */
        // Get shadow
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);

        // Click menu
        shadowActivity.clickMenuItem(R.id.action_profile);

        // Get intent
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = Shadows.shadowOf(startedIntent);

        // Make your assertion
        assertThat(shadowIntent.getClass().getName(), equalTo(MainActivity.class.getName()));
    }

}