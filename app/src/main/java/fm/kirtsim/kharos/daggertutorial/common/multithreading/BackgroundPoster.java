package fm.kirtsim.kharos.daggertutorial.common.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kharos on 23/07/2017
 */

public class BackgroundPoster {

    private ExecutorService  executorService;

    public BackgroundPoster() {
        executorService = Executors.newCachedThreadPool();
    }

    public void post(Runnable runnable) {
        executorService.execute(runnable);
    }
}
