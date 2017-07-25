package fm.kirtsim.kharos.daggertutorial.dependencyinjection.application;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;
import fm.kirtsim.kharos.daggertutorial.common.logging.MyLogger;
import fm.kirtsim.kharos.daggertutorial.common.multithreading.BackgroundPoster;
import fm.kirtsim.kharos.daggertutorial.common.multithreading.MainThreadPoster;

/**
 * Created by kharos on 23/07/2017
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationScope
    public Application getApplication() {
        return application;
    }

    @Provides
    @ApplicationScope
    public MyLogger getLogger() {
        return new MyLogger();
    }

    @Provides
    @ApplicationScope
    public EventBus getEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @ApplicationScope
    public MainThreadPoster mainThreadPoster() {
        return new MainThreadPoster();
    }

    @Provides
    @ApplicationScope
    public BackgroundPoster backgroundPoster() {
        return new BackgroundPoster();
    }
}
