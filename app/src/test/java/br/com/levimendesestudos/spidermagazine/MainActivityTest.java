package br.com.levimendesestudos.spidermagazine;

import android.os.Build;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by 809778 on 23/01/2017.
 */


@RunWith(RobolectricTestRunner.class)
//@Config(sdk = 23, constants = BuildConfig.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP, manifest = Config.NONE, constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    public void clickingButton_shouldCallSobreActivity() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        TextView results = (TextView) activity.findViewById(R.id.tvCopyright);
        Assert.assertEquals(results.getText().toString(), "Levi Mendes");

        assertFalse(false);
        assertTrue(true);
    }

}