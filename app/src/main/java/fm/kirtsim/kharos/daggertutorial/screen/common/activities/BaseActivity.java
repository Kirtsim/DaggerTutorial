package fm.kirtsim.kharos.daggertutorial.screen.common.activities;

import android.support.annotation.UiThread;
import android.support.v4.app.FragmentActivity;

import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ControllerComponent;

/**
 * Created by kharos on 23/07/2017
 */

public abstract class BaseActivity extends FragmentActivity {

    private boolean isControllerComponentUsed = false;

    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (isControllerComponentUsed)
            throw new IllegalStateException("must not use ControllerComponent more than once");
        isControllerComponentUsed = true;
        // TODO: return the component
        return null;
    }

}
