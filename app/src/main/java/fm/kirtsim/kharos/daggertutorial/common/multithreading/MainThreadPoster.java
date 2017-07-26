package fm.kirtsim.kharos.daggertutorial.common.multithreading;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by kharos on 23/07/2017
 */

public class MainThreadPoster {

    private Handler mainHandler;

    public MainThreadPoster() {
        mainHandler = getMainHandler();
    }

    protected Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public void post(Runnable runnable) {
        mainHandler.post(runnable);
    }
}
