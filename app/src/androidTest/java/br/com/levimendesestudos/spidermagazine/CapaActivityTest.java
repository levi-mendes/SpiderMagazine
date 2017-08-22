package br.com.levimendesestudos.spidermagazine;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.levimendesestudos.spidermagazine.activities.CapaActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;


/**
 * Created by 809778 on 22/08/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CapaActivityTest {

    @Rule
    public ActivityTestRule<CapaActivity> mActivity = new ActivityTestRule<>(CapaActivity.class);

    @Test
    public void deve_fechar_a_tela_ao_clicar_no_botao_fechar() {
        onView(withId(R.id.ivFechar)).perform(click());
        assertTrue(mActivity.getActivity().isFinishing());
    }
}
