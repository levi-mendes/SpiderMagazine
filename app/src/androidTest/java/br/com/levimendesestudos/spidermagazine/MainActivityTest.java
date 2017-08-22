package br.com.levimendesestudos.spidermagazine;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.levimendesestudos.spidermagazine.activities.MainActivity;
import br.com.levimendesestudos.spidermagazine.activities.SobreActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Created by 809778 on 21/08/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> mMainActivity = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void deve_chamar_a_tela_SobreActivity() {
        //clique no item de menu
        onView(withId(R.id.action_profile))
                .perform(ViewActions.click());

        //verifica se a tela SobreActivity foi chamada
        intended(hasComponent(SobreActivity.class.getName()));
    }

}