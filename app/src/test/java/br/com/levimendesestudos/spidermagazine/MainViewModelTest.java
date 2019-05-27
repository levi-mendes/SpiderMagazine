package br.com.levimendesestudos.spidermagazine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.MainPresenter;

public class MainViewModelTest {

    MainPresenter mainViewModel;
    @Mock
    MainMVP.View mView;

    public MainViewModelTest() {
        mainViewModel = new MainPresenter(mView);
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void aaaa() {
        //Assert.assertTrue(false);
        //verify(mView).
    }

}
