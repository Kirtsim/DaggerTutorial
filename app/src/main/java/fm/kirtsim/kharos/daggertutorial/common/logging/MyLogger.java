package fm.kirtsim.kharos.daggertutorial.common.logging;

import android.util.Log;

/**
 * Created by kharos on 23/07/2017
 */

public class MyLogger {

    public void e(String tag, String message) {
        Log.e(tag, message);
    }

    public void d(String tag, String message) {
        Log.d(tag, message);
    }

    public void w(String tag, String message) {
        Log.w(tag, message);
    }

    public void v(String tag, String message) {
        Log.v(tag, message);
    }

}
