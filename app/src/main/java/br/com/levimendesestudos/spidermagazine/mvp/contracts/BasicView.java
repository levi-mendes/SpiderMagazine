package br.com.levimendesestudos.spidermagazine.mvp.contracts;

/**
 * Created by 809778 on 21/08/2017.
 */

public interface BasicView {

    boolean isActive();

    void showToast(String msg);

    void showToast(int msg);

    boolean hasInternet();

}