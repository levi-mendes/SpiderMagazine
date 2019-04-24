package br.com.levimendesestudos.spidermagazine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.levimendesestudos.spidermagazine.mvp.contracts.MainMVP;
import br.com.levimendesestudos.spidermagazine.mvp.presenter.MainPresenter;

import static org.mockito.Mockito.verify;

public class MainPresenterTest {

    MainPresenter mainPresenter;
    @Mock
    MainMVP.View mView;

    public MainPresenterTest() {
        mainPresenter = new MainPresenter(mView);
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
