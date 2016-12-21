package br.com.levimendesestudos.spidermagazine.dagger;

import br.com.levimendesestudos.spidermagazine.dagger.components.AppComponent;
import br.com.levimendesestudos.spidermagazine.dagger.components.DaggerAppComponent;
import br.com.levimendesestudos.spidermagazine.dagger.modules.ApiSpiderModule;

public class DaggerInjector {

    private static AppComponent appComponent = DaggerAppComponent.builder().apiSpiderModule(new ApiSpiderModule()).build();

    public static AppComponent get() {
        return appComponent;
    }
}
