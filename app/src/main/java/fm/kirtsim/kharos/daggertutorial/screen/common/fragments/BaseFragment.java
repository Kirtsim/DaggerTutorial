package fm.kirtsim.kharos.daggertutorial.screen.common.fragments;

import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;

import fm.kirtsim.kharos.daggertutorial.MyApplication;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ControllerComponent;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ControllerModule;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ViewMvcModule;

/**
 * Created by kharos on 23/07/2017
 */

public abstract class BaseFragment extends Fragment {

    private boolean isControllerComponentUsed = false;

    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (isControllerComponentUsed)
            throw new IllegalStateException("must not use ControllerComponent more than once");
        isControllerComponentUsed = true;
        return ((MyApplication)getActivity().getApplication()).getApplicationComponent().
                newControllerComponent(new ControllerModule(getActivity()), new ViewMvcModule());
    }
}
